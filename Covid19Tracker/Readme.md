#Covid19 Patient Management REST API

REST Implmentation

Problem
Making track of Covid19 Patient details.Adding new patient,Changing status of the Patients and Fetching details of the patient using different Unique reference.


Concepts Covered in this project.
1.)REST Controller.(All the methods)
2.)JPA Repository.
3.)Swagger2 API documentation.
4.)Custom Validation by using implementation of ConstraintValidator interface.
5.)Exception handling by extending ResponseEntityExceptionHandler.



# How to run this project
## Step 1)
The project requires Java and Maven installed in order to run
Java SE Development Kit 8 (1.8.0) or latest

Run this command in your terminal to see what version you have setup
```bash
java -version
```

Maven 3.0 or latest

Run this command in your terminal to see what version you have setup
```bash
mvn -version
```

## Step 2)
Download the project using git commands or as .zip and extract the project

## Step 3)

Once you have the project, using your terminal navigate to its root folder (containing "README.md","pom.xml" file)
Now run this command: 
```bash
mvn clean install
```
This will use Maven to download the required dependencies, and build an executable jar file in the newly created "target" folder

## Step 4)

You can now execute the project by navigating inside the target folder and running this command

```bash
java -jar target/covid.jar
```

Request and response for api calls

After runnig the project just use http://<IP>:<PORT>/swagger-ui.html to get the detailed info about apis.

## Author
Subhash Konar

