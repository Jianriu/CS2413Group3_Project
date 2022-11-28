# CS2413Group3_Project 
This is the guide I followed to setup this web application project: https://www.infoworld.com/article/3619031/build-a-java-application-in-visual-studio-code.html

## Prerequisites
1. Java (version 17)
2. Install Maven (Guide: https://www.baeldung.com/install-maven-on-windows-linux-mac)

If you use Visual Studio Code like me, there's some extensions that the guide tells you to install: Java Extension Pack, Spring Boot Extension Pack, Svelte for VS Code extension. 

## Folders
 * **demo**: contains all the back end code, which is in Java.
 * **vs-java-frontend**: contains all the front-end code, which is written in JavaScript and HTML. 

 ## Quick Setup 
  1. Go into a terminal and change to **CS2413Group3_Project/demo** directory. type this command in: ***"mvn spring-boot:run"***. This should run the backend at localhost:5000. You can change the port number in application.properties file. 

  2. Create a new terminal and go to the **CS2413Group3_Project/vs-java-frontend** directory. type this command in: ***"npm run dev"***. This should run the front-end portion at localhost:8080 (if it doesnt work: ***npm install*** before running npm dev??)
  
  
