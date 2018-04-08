# LuggageTrackingSystem

### Installation instructions
- Clone the repository at 
- Import the LuggageTrackingSystem project into Eclipse

### How to run the application
- Ensure that no data.xml file exists already in the project (should show at the bottom of the project contents) as this file is created when the application is ran to populate the database in order for the user to demonstrate the correct functionality of the application. 
- Right-click LTSApplication.java in the ca.mcgill.ecse681.lts.application package and Run as > Java Application to open our Self-Adaptive Luggage Tracking System.

### Note1
On subsequent runs of the application, delete the data.xml file. Note that this will unfortunately eliminate any changes made to the database when the application was run the previous time. The reason for doing so originates from a persistence error which occurs when the application is loaded with an existing data.xml file. We apologize for the inconvenience. 

### Note2
A FileNotFoundException occurs when running the application due to the data.xml file being non-existent. Our persistence implementation creates this file to store the data of our system on startup. As such, this does not affect our system's functionality of our system and can be ignored.  

### Important considerations
- We used the Model-View-Controller pattern to implement our application.

### Code structure breakdown
- ca.mcgill.ecse681.lts.database package: 
    - Population.java : creates the predefined database of passengers, flights, luggage when the application is ran to be able to test the application features. 
- ca.mcgill.ecse681.lts.controller package: 
    - Controller.java : contains methods controlling what occurs when the user makes an action (e.g. presses a button) in the application.
- ca.mcgill.ecse681.lts.application package:
    - LTSApplication.java : file from which to run the application as explained in the 'How to run the application' section.
- ca.mcgill.ecse681.lts.model package:
    - automatically generated java files from the LTS.ump source file representing the class diagram of system components and their associations.
- ca.mcgill.ecse681.lts.persistence package: 
    - files to enable persistence of data using XStream.
- ca.mcgill.ecse681.lts.view package:
    - panels for each page displayed by the application, in which controller methods are called to perform certain actions.
