Feature: Style Validation

@Validate_Red_From_Validation_Styling
Scenario Outline: Validate the text box highlighting if user search invalid data
Given Run the URL to launch  application 
When user fill invalid data in to the input text box "<input>"
And click on calculate button
Then Please enter an integer validation message shuold display
And the input text box should highlight in red colour

Examples:
| input       |
|   Biswajit    |