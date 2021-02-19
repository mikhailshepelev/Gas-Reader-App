# Gas Reader Application

## About
This application is simulation of fetching gas usage data from mocked data stream and showing this data in a web-site page. A main parts of the application are fictional gas readers. A data gathered by these readers can be viewed in a main page of site. Employees are able to log in to the site with their personal accounts and view overall gas consumption data of all readers.

## Installation and usage
Before running an application, make sure that you downloaded and installed:
1.  [Java SE Development Kit 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
2.  [Intellij IDEA Community Edition](https://www.jetbrains.com/idea/download)
3.  [Node.Js](https://nodejs.org/en/)

## To setup and run back-end
1. Open Intellij IDEA and clone this project by clicking "Get from Version Control" in the starting window
2. Wait until maven will resolve all required dependencies.
3. Install ["Lombok"](https://www.jetbrains.com/help/idea/managing-plugins.html) plugin in Intellij IDEA
4. Find file "src/main/java/com/msh/gasapp/GasappApplication.java" and click on green arrow near "main" method to run application

## To setup and run front-end
1. Install angular by executing following command in terminal/command line (you can find more information [here](https://angular.io/guide/setup-local))
```bash
npm install -g @angular/cli
```
2. Open terminal/command line at "angularview" folder.
3. Run following command to add all required libraries:
```bash
npm install
```
4. Run the application:
```bash
ng serve --open
```
5. Your browser will be opened at http://localhost:4200. You can navigate through app by using this address.

## General information about app

As starting point of application we have 3 fictional readers and 3 employees: 

Employee Username : "alex", password - "1234"  
Employee Username : "mary", password - "2345"  
Employee Username : "mike", password - "3456"  

## Author
[Mikhail Shepelev](https://github.com/mikhailshepelev)
