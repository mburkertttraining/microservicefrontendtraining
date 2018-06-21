# microservicesfrontendtraining

This Microservice should show a basic front end scenario with a basic unit testing and a Selenium testing

#### System requirements:


* Operation Systems: 		Windows (7, 8, 10), Linux Ubuntu, Mint
* Java:					Java 8 (version upgrade to nine still not complete)
* Maven: 					at least Maven 3 or higher

#### Install Java:

http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

With windows you have simply to download and install the java jdk from the link and it is done.
After the installation you have to set the JAVA_HOME environment variable.
Here is a nice tutorial for this on windows
https://www.mkyong.com/java/how-to-set-java_home-on-windows-10/
Here is the same for Linux
https://askubuntu.com/questions/175514/how-to-set-java-home-for-java
When this is done we need Maven next.

#### Install Maven:

https://maven.apache.org/install.html you will find Maven here.
You have to unpack your package (like for Java you have to set the MAVEN_HOME also.
Heres a Tutorial to set the maven home: https://www.mkyong.com/maven/how-to-install-maven-in-windows/
here is one with also the linux way to do it: http://www.baeldung.com/install-maven-on-windows-linux-mac

# What we will do in this training:

In this training, we will learn about quick set up a database and how to test it bu we will also learn about the limitations of it.

* 1. Activate the test in ErnianFormControllerSeleniumTest again and run them after this check them and try to understand what happens.
* 2. What kind of validation would make sense to check with Selenium? Would a Client side check make sense ? If not why?
* 3. In the html which is actually a thymeleaf template, you will see, that there is a validation check this validation in the template as well as in the controller and the model.
* 4. Build a Selenium test which is Filling all fields with data and resets them afterwards, after this, this test has to proof the validation is working and no file is generated.
* 5. Execute the MockMvc test in the ErnianFormControllerTest and the Selenium tests, do you think there is a difference?



