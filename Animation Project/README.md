Our Project is Broken down into three Main Components.
Shape Class/Interface
Model & Animation Class/Interface
View Class/Interface

Our Shape is designed to minimize the Reuse of the code. We created an interface that contains 15 different methods. This methods will be passed to an abstract method. This abstract method will then be used to minimize code as our three sub classes will call the super method to inherit the design of the abstract class.

The abstract class will contain objects to the Dimensions, Colour, Duration, and Position Class. These classes will use delegation so when we create a shape object the specification/limitations of the position, times and colour fields are passed of to these classes.

Once the Shape class is done, we will use this object in our animation class. Our animation class will be used to determine if the shape object is being used or not. There are 8 methods that check to see if the object has moved, change colour, or resized. The animation class can do this since it takes a Shape object as a parameter. The shape object has 15 methods, which can get every Colour, Position and Dimensions component. This means we can use basic subtraction to see if the object moves or not. This information about movement, is passed to text and SVG View so it can formatted appropriately.

Once the animation part is completed the IModel interface needs to be made. The IModel interface will be made by parsing a text file into three different data structures. 
1. Treemap
2.ArrayList
3.PriorityQueue

The Treemap is used as a check to make sure that we are not doubling adding the same shape. The Treemap is important since its hashing feature will allow us to look up elements instanteously, giving up a O(1) add time. 

The priority Queue will then be added if the Treemap allows it. The priority queue will be added based on StartTime. The priority Queue will be moved to the AnimationView/GUI file as the main input. 

The ArrayList is used to print out the order in which the elements are added. This makes formatting the textfile easier. It also makes it formmated in O(n) time. 

Once the model is implemented, we will pass off our model into the controller. 

The controller will take the inputController and the IModel as parameters.  The inputController parses the Command Line arguments in O(N) time since we use a switch statement instead of a nested for loop. The parameters for this class are only added is certain conditions are meet. If there are not meet then they are set to the default values.

The IModel will be converted into a AdapterModel. If we convert the IModel to an AdapterModel, we can only pass clones of our data structures to our View Class. This makes sure that the View has the relevant information it needs without Breaking MVC basics. 
 
 Lastly, the controller will control what is passed to the Views.
 
 The TextView takes in a hashmap and a priority Queue. The hashmap is used to look up information in O(1) time, the priority is used to maintain the order the shapes are added in O(n) time. 
 
 The SVG View, takes in a Treemap and a canvas. The canvas is used to used to set the boundaries of where the shapes can move, and the treemap is used to look up and append elements. 
 
 The Animation GUI view firstly sets up a Frame. This frame is formatted in another Class. Within this Frame Class, we will add a JPane object. This Jpane object will contain most of the GUI work. Here the Jpane will add elements from the priority Queue passed through the animationView->JFrame->Jpan view. Here we will parse throught the priority Queue using a for each loop and only draw eleemnts based on the time Frame. 
 
 The elements are added if and only if the seconds counter is between the start time and endtime. If the seconds counter is between these two amounts, we will either add the shape right away or we will format the shape into a new shape using linear interpolation if the time is run time of the obejct is larger than one second. This will allow us to draw frame by frame. 
 
 Lastly, within this class, the repaint and Actionlistener Methods will change the speed, and will start or stop the clock, giving the GUI Functionality.  
 
 
 
 