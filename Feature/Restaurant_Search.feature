Feature: Able to find restaurants in my area by giving Postcode


 Scenario Outline: TC001_Validating restaurants in an area by giving postcode
 
 Given Initialize the browser
 And Navigate to JUST EAT Site 
 When user enters the <Post_Code>
 And click on "Search"
 Then user sees search results
 And verify user should see some restaurants for <Post_Code>
 And Close the browser
 
 Examples:
 | Post_Code|
 | AR51 1AA|
 
 

  Scenario Outline: TC002_Validating open Restaurant display header with that of number Restaurants listed
 
 
 Given Initialize the browser
 And Navigate to JUST EAT Site 
 When user enters the <Post_Code>
 And click on "Search"
 Then user sees search results
 And verify number of Restaurant listed should be equal to the number of open Restaurant displayed in the header
 And Close the browser
 
 Examples:
 | Post_Code|
 | AR51 1AA|

 
 
 
 Scenario Outline: TC003_Validating Error message when invalid postcode is inputted in the search
 
 Given Initialize the browser
 And Navigate to JUST EAT Site 
 When user enters the <Post_Code>
 And click on "Search"
 Then Verify display of <Error_Message>
 And Close the browser
 
 Examples:
 
 |Post_Code|Error_Message|
 |Azzz45 1AA|Please enter a full, valid postcode|
 
 
 
 
 