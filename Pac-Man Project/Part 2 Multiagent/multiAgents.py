# multiAgents.py
# --------------
# Licensing Information:  You are free to use or extend these projects for
# educational purposes provided that (1) you do not distribute or publish
# solutions, (2) you retain this notice, and (3) you provide clear
# attribution to UC Berkeley, including a link to http://ai.berkeley.edu.
#
# Attribution Information: The Pacman AI projects were developed at UC Berkeley.
# The core projects and autograders were primarily created by John DeNero
# (denero@cs.berkeley.edu) and Dan Klein (klein@cs.berkeley.edu).
# Student side autograding was added by Brad Miller, Nick Hay, and
# Pieter Abbeel (pabbeel@cs.berkeley.edu).

#GROUP - Ka Foon, Meet, Dishant, Karishma

from game import Directions
import random
import util
import sys

from game import Agent
from util import manhattanDistance

class ReflexAgent(Agent):
    """
    A reflex agent chooses an action at each choice point by examining
    its alternatives via a state evaluation function.

    The code below is provided as a guide.  You are welcome to change
    it in any way you see fit, so long as you don't touch our method
    headers.
    """

    def getAction(self, gameState):
        """
        You do not need to change this method, but you're welcome to.

        getAction chooses among the best options according to the evaluation function.

        Just like in the previous project, getAction takes a GameState and returns
        some Directions.X for some X in the set {NORTH, SOUTH, WEST, EAST, STOP}
        """
        # Collect legal moves and successor states
        legalMoves = gameState.getLegalActions()

        # Choose one of the best actions
        scores = [self.evaluationFunction(
            gameState, action) for action in legalMoves]
        # print(scores)
        bestScore = max(scores)
        bestIndices = [index for index in range(
            len(scores)) if scores[index] == bestScore]
        # Pick randomly among the best
        chosenIndex = random.choice(bestIndices)

        "Add more of your code here if you want to"

        return legalMoves[chosenIndex]

    def evaluationFunction(self, currentGameState, action):
        """
        Design a better evaluation function here.

        The evaluation function takes in the current and proposed successor
        GameStates (pacman.py) and returns a number, where higher numbers are better.

        The code below extracts some useful information from the state, like the
        remaining food (newFood) and Pacman position after moving (newPos).
        newScaredTimes holds the number of moves that each ghost will remain
        scared because of Pacman having eaten a power pellet.

        Print out these variables to see what you're getting, then combine them
        to create a masterful evaluation function.
        """
        # Useful information you can extract from a GameState (pacman.py)
        successorGameState = currentGameState.generatePacmanSuccessor(action)
        newPos = successorGameState.getPacmanPosition()
        newFood = successorGameState.getFood()
        newGhostStates = successorGameState.getGhostStates()
        newScaredTimes = [
            ghostState.scaredTimer for ghostState in newGhostStates]

        "*** YOUR CODE HERE ***"
        # Five key components to consider when creating the evaluation function: score, action, food, scaredTimes and ghosts

        # Score'''
        '''Need to take into account the score when a particular action is taken.'''
        score = successorGameState.getScore()

        # Action
        '''We never want pacman to stop at any point in the game. Hence, if the action is equal to "Stop",
        then we return the worst possible socre (negative infinity).'''
        if action == "Stop":
            score = float("-Inf")
            return score

        # Food
        '''We first initialize a list, which will contain the manhattan distance between the new
        position of pacman (based on the action, NESW, it will take from the current position)
        and the currently available food pellets in the current game state. Next, we will find
        the minimium distance in the list since we want pacman to move in the direction where the
        food pellet is closest. The min manhattan distance will be subtracted from the score.
        The larger the manhattan distance (ex. 7) the smaller the score will become (2 - 7 = -5),
        the smaller the manhattan distance (ex. 1) the larger the score will become (2 - 1 = 1).
        Remember, getAction() will pick the largest score in the list called scores.'''
        food_distance_lst = []
        for food_position in currentGameState.getFood().asList():
            food_distance_lst.append(
                util.manhattanDistance(newPos, food_position))
        score += -min(food_distance_lst)

        # Ghosts
        '''As long as the minimum scared time (or the number of moves that each ghost will remain
        scared for) is greater than zero, then pacman can continue to traverse to the closest food pellet
        without having to account for the ghosts. If the scared time is zero, then pacman must take into
        account the ghosts in the game. Therefore, we will find the distance between the new position that 
        pacman will take based on the action and the position of the ghost in the successor game state. We
        want to find the minimum distance out of the list since we only care about the ghost that is closest.
        The greater the distance, the better for pacman b/c the ghost will be further. Thus, we want to add to
        the score that will also contain the sum of the score and food distance.'''
        if min(newScaredTimes) > 0:
            return score
        else:
            ghost_distance_lst = []
            ghost_minimum_distance = 0
            for ghost_position in successorGameState.getGhostPositions():
                ghost_distance_lst.append(
                    util.manhattanDistance(newPos, ghost_position))

            score += min(ghost_distance_lst)

        return score


def scoreEvaluationFunction(currentGameState):
    """
    This default evaluation function just returns the score of the state.
    The score is the same one displayed in the Pacman GUI.

    This evaluation function is meant for use with adversarial search agents
    (not reflex agents).
    """
    return currentGameState.getScore()


class MultiAgentSearchAgent(Agent):
    """
    This class provides some common elements to all of your
    multi-agent searchers.  Any methods defined here will be available
    to the MinimaxPacmanAgent, AlphaBetaPacmanAgent & ExpectimaxPacmanAgent.

    You *do not* need to make any changes here, but you can if you want to
    add functionality to all your adversarial search agents.  Please do not
    remove anything, however.

    Note: this is an abstract class: one that should not be instantiated.  It's
    only partially specified, and designed to be extended.  Agent (game.py)
    is another abstract class.
    """

    def __init__(self, evalFn='scoreEvaluationFunction', depth='2'):
        self.index = 0  # Pacman is always agent index 0
        self.evaluationFunction = util.lookup(evalFn, globals())
        self.depth = int(depth)


class MinimaxAgent(MultiAgentSearchAgent):
    """
    Your minimax agent (question 2)
    """

    def getAction(self, gameState):
        """
        Returns the minimax action from the current gameState using self.depth
        and self.evaluationFunction.

        Here are some method calls that might be useful when implementing minimax.

        gameState.getLegalActions(agentIndex):
        Returns a list of legal actions for an agent
        agentIndex=0 means Pacman, ghosts are >= 1

        gameState.generateSuccessor(agentIndex, action):
        Returns the successor game state after an agent takes an action

        gameState.getNumAgents():
        Returns the total number of agents in the game

        gameState.isWin():
        Returns whether or not the game state is a winning state

        gameState.isLose():
        Returns whether or not the game state is a losing state
        """
        "*** YOUR CODE HERE ***"

        '''
        Function: max_value (pacman)
        Parameters:(1) gameState: current game state
                   (2) agentIndex: agentIndex = 0 (pacman), agentIndex >= 1 (ghosts) 
                                   If the number of agents is 3, then it means that pacman
                                   pacman is agentIndex = 0, ghost one is agentIndex = 1 and
                                   ghost two is agentIndex = 2
                   (3) depth_limit: depth of tree
                                    If the number of agents is 3, then it means that one pacman
                                    and two ghosts count as 1 depth. Each new depth starts off 
                                    with pacman.
        Return: [utility value, action]
        '''
        def max_value(gameState, agentIndex, depth_limit):
            # Initialize value to be as small as possible
            value = float("-Inf")
            legal_actions_lst = gameState.getLegalActions(agentIndex)
            result_lst = [value, legal_actions_lst[0]]

            # for-loop goes through every legal action that can be made by the current
            # game state. Retrieve the utility value by calling minimax function. If
            # the utility value returned by minimax is larger than the current
            # utility value, then the value and action of the better utility value will
            # now be the new result_lst.
            for action in legal_actions_lst:
                successor = gameState.generateSuccessor(agentIndex, action)
                successor_value = minimax(
                    successor, agentIndex + 1, depth_limit)
                if result_lst[0] < successor_value[0]:
                    result_lst[0] = successor_value[0]
                    result_lst[1] = action

            return result_lst

        '''
        Function: min_value (for adversary aka ghosts)
        Parameters:(1) gameState: current game state
                   (2) agentIndex: agentIndex = 0 (pacman), agentIndex >= 1 (ghosts) 
                                   If the number of agents is 3, then it means that pacman
                                   pacman is agentIndex = 0, ghost one is agentIndex = 1 and
                                   ghost two is agentIndex = 2
                   (3) depth_limit: depth of tree
                                    If the number of agents is 3, then it means that one pacman
                                    and two ghosts count as 1 depth. Each new depth starts off 
                                    with pacman.
        Return: [utility value, action]
        '''
        def min_value(gameState, agentIndex, depth_limit):
            # Initialize value to be as large as possible
            value = float("+Inf")

            legal_actions_lst = gameState.getLegalActions(agentIndex)

            # Initialize the result list where the value is positive infinitiy
            # and the action is the first legal action in the getLegalActions list
            result_lst = [value, legal_actions_lst[0]]

            # for-loop goes through every legal action that can be made by the current
            # game state. Retrieve the utility value by calling minimax function. If
            # the utility value returned by minimax is smaller than the current
            # utility value, then the value and action of the better utility value will
            # now be the new result_lst.
            for action in legal_actions_lst:
                successor = gameState.generateSuccessor(
                    agentIndex, action)
                successor_value = minimax(
                    successor, agentIndex + 1, depth_limit)
                if result_lst[0] > successor_value[0]:
                    result_lst[0] = successor_value[0]
                    result_lst[1] = action

            return result_lst

        '''
        Function: Minimax search
        Parameters:(1) gameState: current game state
                   (2) agentIndex: agentIndex = 0 (pacman), agentIndex >= 1 (ghosts) 
                                   If the number of agents is 3, then it means that pacman
                                   pacman is agentIndex = 0, ghost one is agentIndex = 1 and
                                   ghost two is agentIndex = 2
                   (3) depth_limit: depth of tree
                                    If the number of agents is 3, then it means that one pacman
                                    and two ghosts count as 1 depth. Each new depth starts off 
                                    with pacman.
        Return: [utility value, action]
        '''
        def minimax(gameState, agentIndex, depth_limit):
            # gameState.getNumAgents() will return the number of agents. For example, if the
            # number of agents is 3, it means there is 1 pacman and 2 ghosts.
            if ((agentIndex % gameState.getNumAgents()) == 0):
                agentIndex = 0
                index = agentIndex
                depth_limit += 1
            else:
                index = agentIndex

            # If the game state is win or lose or if the depth limit is reached, then the
            # terminal state has been reached and the utility value can be retrieved.
            # Utiltiy value returned in the form of a list.
            if (gameState.isWin() or gameState.isLose() or (depth_limit == self.depth)):
                return [self.evaluationFunction(gameState)]

            # When index equals to 0, it means that we're dealing with pacman's move
            # so max_value function is called
            elif (index == 0):
                return max_value(gameState, agentIndex, depth_limit)

            # When index is greater than or equal to 1, it means that we're dealing
            # with ghost's so min_value function is called
            elif (index >= 1):
                return min_value(gameState, agentIndex, depth_limit)

        result = minimax(gameState, 0, -1)
        action = result[1]

        return action


class AlphaBetaAgent(MultiAgentSearchAgent):
    """
    Your minimax agent with alpha-beta pruning (question 3)
    """

    def getAction(self, gameState):
        """
        Returns the minimax action using self.depth and self.evaluationFunction
        """
        "*** YOUR CODE HERE ***"
        def alphaValue(alpha, beta, depth, gameState):
            if gameState.isWin() or gameState.isLose() or depth == self.depth:
                return self.evaluationFunction(gameState), ""
            result = (float('-Inf'), "")
            for action in gameState.getLegalActions(0):
                newBetaValue = betaValue(alpha, beta, depth, 1, gameState.generateSuccessor(0, action))
                if newBetaValue[0] > result[0]: result = (newBetaValue[0], action)
                if result[0] > beta: return result
                alpha = max(result[0], alpha)
            return result

        def betaValue(alpha, beta, depth, agents, gameState):
            if gameState.isWin() or gameState.isLose(): return self.evaluationFunction(gameState), ""
            result = (float('Inf'), "")
            for action in gameState.getLegalActions(agents):
                if agents == gameState.getNumAgents() - 1: value = alphaValue(alpha, beta, depth + 1, gameState.generateSuccessor(agents, action))
                else: value = betaValue(alpha, beta, depth, agents + 1, gameState.generateSuccessor(agents, action))
                if value[0] < result[0]: result = (value[0], action)
                if result[0] < alpha: return result
                beta = min(result[0], beta)
            return result

        return alphaValue(float('-Inf'), float('Inf'), 0, gameState)[1]

        
class ExpectimaxAgent(MultiAgentSearchAgent):
    """
      Your expectimax agent (question 4)
    """

    def getAction(self, gameState):
        """
        Returns the expectimax action using self.depth and self.evaluationFunction

        All ghosts should be modeled as choosing uniformly at random from their
        legal moves.
        """
        "*** YOUR CODE HERE ***"

        agents = gameState.getNumAgents()
        actions = gameState.getLegalActions(0)
        remaining = agents * self.depth  
        agentIndex = 0 

        def search(agentIndex, agents, remaining, gameState):
            currentMax = float('-Inf')
            result = float(0)
            if(remaining == 0): return self.evaluationFunction(gameState)
            actions = gameState.getLegalActions(agentIndex)
            if len(actions) == 0: return self.evaluationFunction(gameState)
            for action in actions:
                nextState = gameState.generateSuccessor(agentIndex, action)
                value = search((agentIndex + 1) % agents, agents, remaining - 1, nextState)
                result += float(value) / float(len(actions)) 
                currentMax = max(currentMax, value)
            if(agentIndex == 0): return currentMax
            return result

        res = search(agentIndex, agents, remaining, gameState)
        for action in actions:
            nextState = gameState.generateSuccessor(0, action)
            remaining = agents * self.depth - 1
            agentIndex = 1 % agents
            if search(agentIndex, agents, remaining, nextState) == res: return action
        util.raiseNotDefined()


def betterEvaluationFunction(currentGameState):
    """
    Your extreme ghost-hunting, pellet-nabbing, food-gobbling, unstoppable
    evaluation function (question 5).

    DESCRIPTION: <write something here so we know what you did>
    """
    "*** YOUR CODE HERE ***"

    result = 0
    if currentGameState.isLose(): result -= sys.maxsize / 1000
    if currentGameState.isWin(): result += sys.maxsize / 1000
    for nextState in currentGameState.getGhostStates():
        if(manhattanDistance(currentGameState.getPacmanPosition(), nextState.getPosition()) <= 1) : result -= sys.maxsize / 100
        if(manhattanDistance(currentGameState.getPacmanPosition(), nextState.getPosition()) <= 4) :
            result += 3 * manhattanDistance(currentGameState.getPacmanPosition(), nextState.getPosition())
    return currentGameState.getScore() + result
    util.raiseNotDefined()


# Abbreviation
better = betterEvaluationFunction
