# JUST EAT - BDD Test with Cucumber Framework

https://www.just-eat.co.uk/
JUST EAT website is tested with selenium-cucumber in  a behavior driven development (BDD) approach using JAVA programming language.


##Framework Architecture


JUST_EAT\Feature\Restaurant_Search.feature - all the cucumber features files (files .feature ext) are placed here.

JUST_EAT\src\test\java\Step_Definitions\Restaurant_Search.java  - Step defintion are defined under this package for the feature steps.

JUST_EAT\src\test\java\Test_Runner\Test_Runner.java - Test Runner class

JUST_EAT\target\site\cucumber-pretty : Once Step_Definition\Restaurant_Search.java  file is executed Cucucmber reports are stored in this location in local folder


### Prerequisites

Java
Maven
Eclipse
Eclipse Plugins
Maven
Cucumber

### Running test

This section explains  how to run the automated tests for this system

Select test Runner class file - src/test/java/Test_Runner.java 
Right Click on Test_Runner.java class and Click Run As  > JUnit Test Application


### Test Scenarios

TC001_Validating restaurants in an area by giving postal code
This scenario validates that atleast one restaurant shows up in the results for the given postal code.
Further it clicks on each restaurant link in the search result page iteratively and compares the postal code on the next web page for individual restaurant with the given postal code.

TC002_Validating open Restaurant display header with that of number Restaurants listed
This test scenario compares the total number of open restaurants displayed in the header with the actual number of individual open restaurant links displayed on the search result page.

TC003_Validating Error message when invalid postcode is inputted in the search
This scenario provides invalid postal code as a search input and validates error message.



