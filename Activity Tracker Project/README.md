# CS5500Project
Repo for CS5500 Group Project

This project is done by Ka Foon (Kelvin) Siu, Saurav Shah and Vedanta Prusty.

This project is for the CS5500 - Foundations of Software Engineering Class. 

We have designed an end to end program where the user can do the following:
  - Insert data using a json data file
  - Creating a MySQL Schema
  - Run an API to extract data from the database
  - Several webpages to access the data and create/delete data off our database. (Detailed features in the product delivery report (productdeliveryreport.pdf)
  
Our project includes the following packages/folders:
1. ActivityTracker: this folder includes the following additional folders
   1. API: This folder contains all the auto-generated code that was produced by the api.yaml file, which can be found in our resources folder. The auto-generated 
           code are APIs for each of the objects/entities that we have created for our project. For each object/entity there is an API interface, Controller class 
           and Delegate interface. By implementing the methods from the Delegate interace, the project is able to successfully meet the requirements for our 
           endpoints and our HTTP requests.
   
   2. DAO: This folder contains the data access objects to read data from the database, to create data in the database and to delete the data in the database. This 
           separates out our connection to the database and doesn’t allow any other code to create a connection. We are able to restrict access to specific methods 
           by using this DAO package. ConnManager.java is the file that establishes the connection to the database and all the other DAOs have create, read and 
           delete methods.
   
   3. Model: This folder contains the objects we use to translate database data into java objects. Each of the model objects represents a table on the database. 
             These models easily helps us retrieve data using get methods and also insert data into the database. In addition, these model objects also played a big 
             role in the API implementation and the web implementations. For instance, we used thymeleaf and springboot controller to create post requests and 
             thymeleaf gave us the ability to directly convert the data entered by a user into one of these objects and further utilize it to retrieve data and also 
             create data.
   
   4. WebController: This folder contains all the web controller classes that are used to map endpoints to our desired html files. We are able to do GET, POST and 
                     DELETE requests using the web controller.
    
2. Resources:
   1. Static: images for our web page and index.html page, which is our homepage.
   2. Template: the html files for our webpages. 
   3. api.yaml: file used to auto-generate our APIs
   
For more information about how to run our project please refer to the installation instructions.pdf or installationinsructions.md
