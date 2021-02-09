# Gas Reader Application

## About
This application is simulation of fetching gas usage data from mocked data stream and showing this data in a web-site page. A main parts of the application are fictional gas companies and employees of these companies, who can log in to the site with their personal account and view gas consumption data of their company. Application can accept any number of companies and employees.

## Installation and usage
Before running an application, make sure that you downloaded and installed:
1.  [Java SE Development Kit 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
2.  [Intellij IDEA Community Edition](https://www.jetbrains.com/idea/download)
3.  [Node.Js](https://nodejs.org/en/)

## To setup and run back-end
1. Open Intellij IDEA and clone this project by clicking "Get from Version Control" in the starting window
2. Wait until maven will resolved all required dependencies.
3. Find file "src/main/java/com/msh/gasapp/GasappApplication.java" and click on green arrow near "main" method to run application

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

As starting point of application we have 3 fictional companies and 3 employees: 

Company - "Lightning inc." : Employee Username : "alex", password - "1234"  
Company - "Blizzard inc." : Employee Username : "mary", password - "2345"  
Company - "Thunderbolt inc." : Employee Username : "mike", password - "3456"  

Application consumer can add any number of companies and employees by adding new rows into "src/main/resources/data.sql" file. Note that password stored in Bcrypt hash. To convert plain password to Bcrypt hash you can use [online converter](https://passwordhashing.com/BCrypt)

## Author
[Mikhail Shepelev](https://github.com/mikhailshepelev)
