# search.py
# ---------
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


"""
In search.py, you will implement generic search algorithms which are called by
Pacman agents (in searchAgents.py).
"""

import util


class Node:

    def __init__(self, state, action=None, cost=0, parent=None, evaluation_function_cost=0):
        self.state = state
        self.action = action
        self.cost = cost
        self.parent = parent
        self.evaluation_function_value = evaluation_function_cost


class SearchProblem:
    """
    This class outlines the structure of a search problem, but doesn't implement
    any of the methods (in object-oriented terminology: an abstract class).

    You do not need to change anything in this class, ever.
    """

    def getStartState(self):
        """
        Returns the start state for the search problem.
        """
        util.raiseNotDefined()

    def isGoalState(self, state):
        """
          state: Search state

        Returns True if and only if the state is a valid goal state.
        """
        util.raiseNotDefined()

    def getSuccessors(self, state):
        """
          state: Search state

        For a given state, this should return a list of triples, (successor,
        action, stepCost), where 'successor' is a successor to the current
        state, 'action' is the action required to get there, and 'stepCost' is
        the incremental cost of expanding to that successor.
        """
        util.raiseNotDefined()

    def getCostOfActions(self, actions):
        """
         actions: A list of actions to take

        This method returns the total cost of a particular sequence of actions.
        The sequence must be composed of legal moves.
        """
        util.raiseNotDefined()


def tinyMazeSearch(problem):
    """
    Returns a sequence of moves that solves tinyMaze.  For any other maze, the
    sequence of moves will be incorrect, so only use this for tinyMaze.
    """
    from game import Directions
    s = Directions.SOUTH
    w = Directions.WEST
    return [s, s, w, s, w, w, s, w]


def depthFirstSearch(problem):
    """
    Search the deepest nodes in the search tree first.

    Your search algorithm needs to return a list of actions that reaches the
    goal. Make sure to implement a graph search algorithm.

    To get started, you might want to try some of these simple commands to
    understand the search problem that is being passed in:

    print("Start:", problem.getStartState())
    print("Is the start a goal?", problem.isGoalState(problem.getStartState()))
    print("Start's successors:", problem.getSuccessors(problem.getStartState()))
    """
    "*** YOUR CODE HERE ***"
    ''''''
    output = []
    explored = []
    stack = util.Stack()
    goal_state = None

    root_node = Node(problem.getStartState())
    stack.push(root_node)

    while (stack.isEmpty() == False):
        node = stack.pop()
        if (problem.isGoalState(node.state) == False) and (node.state not in explored):
            explored.append(node.state)
            successors = problem.getSuccessors(node.state)
            for i in range(0, len(successors)):
                if (successors[i][0] not in explored):
                    newNode = Node(
                        successors[i][0], successors[i][1], successors[i][2], node)
                    stack.push(newNode)
        elif (problem.isGoalState(node.state) == True) and (node.state not in explored):
            explored.append(node.state)
            break

    while node.parent != None:
        output.append(node.action)
        node = node.parent

    return list(reversed(output))


def breadthFirstSearch(problem):
    """Search the shallowest nodes in the search tree first."""

    "*** YOUR CODE HERE ***"
    output = []
    explored = []
    queue = util.Queue()
    queue_lst = []
    goal_state = None

    root_node = Node(problem.getStartState())
    queue.push(root_node)
    queue_lst.append(root_node.state)

    while (queue.isEmpty() == False):
        node = queue.pop()
        if (problem.isGoalState(node.state) == False) and (node.state not in explored):
            explored.append(node.state)
            successors = problem.getSuccessors(node.state)
            for i in range(0, len(successors)):
                if (successors[i][0] not in explored) and (successors[i] not in queue_lst):
                    newNode = Node(
                        successors[i][0], successors[i][1], successors[i][2], node)
                    queue_lst.append(successors[i])
                    queue.push(newNode)
        elif (problem.isGoalState(node.state) == True) and (node.state not in explored):
            explored.append(node.state)
            break

    while node.parent != None:
        output.append(node.action)
        node = node.parent

    return list(reversed(output))


def uniformCostSearch(problem):
    """Search the node of least total cost first."""
    "*** YOUR CODE HERE ***"

    output = []
    explored = []
    priority_queue = util.PriorityQueue()
    priority_queue_lst = []
    goal_state = None

    root_node = Node(problem.getStartState())
    priority_queue.update(root_node, root_node.cost)

    while (priority_queue.isEmpty() == False):
        node = priority_queue.pop()
        if (problem.isGoalState(node.state) == False) and (node.state not in explored):
            explored.append(node.state)
            successors = problem.getSuccessors(node.state)
            for i in range(0, len(successors)):
                if (successors[i][0] not in explored) and (successors[i] not in priority_queue_lst):
                    newCost = successors[i][2] + node.cost
                    newNode = Node(
                        successors[i][0], successors[i][1], newCost, node)
                    priority_queue_lst.append(successors[i])
                    priority_queue.update(
                        newNode, newCost)
        elif (problem.isGoalState(node.state) == True) and (node.state not in explored):
            explored.append(node.state)
            break

    while node.parent != None:
        output.append(node.action)
        node = node.parent

    return list(reversed(output))


def nullHeuristic(state, problem=None):
    """
    A heuristic function estimates the cost from the current state to the nearest
    goal in the provided SearchProblem.  This heuristic is trivial.
    """
    return 0


def aStarSearch(problem, heuristic=nullHeuristic):
    """Search the node that has the lowest combined cost and heuristic first."""
    "*** YOUR CODE HERE ***"

    output = []
    explored = []
    priority_queue = util.PriorityQueue()
    priority_queue_lst = []
    goal_state = None

    root_node = Node(problem.getStartState())
    priority_queue.update(root_node, root_node.cost)

    while (priority_queue.isEmpty() == False):
        node = priority_queue.pop()
        if (problem.isGoalState(node.state) == False) and (node.state not in explored):
            explored.append(node.state)
            successors = problem.getSuccessors(node.state)
            for i in range(0, len(successors)):
                if (successors[i][0] not in explored) and (successors[i] not in priority_queue_lst):
                    newCost = successors[i][2] + node.cost
                    evaluation_function_cost = newCost + \
                        heuristic(successors[i][0], problem)
                    newNode = Node(
                        successors[i][0], successors[i][1], newCost, node, evaluation_function_cost)
                    priority_queue_lst.append(successors[i])
                    priority_queue.update(
                        newNode, evaluation_function_cost)
        elif (problem.isGoalState(node.state) == True) and (node.state not in explored):
            explored.append(node.state)
            break

    while node.parent != None:
        output.append(node.action)
        node = node.parent

    return list(reversed(output))


# Abbreviations
bfs = breadthFirstSearch
dfs = depthFirstSearch
astar = aStarSearch
ucs = uniformCostSearch
