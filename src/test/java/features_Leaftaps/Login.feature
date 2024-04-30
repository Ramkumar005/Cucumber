Feature: Leaftaps Login

Scenario: TC001_Test_With_Valid_Credentials

And Launch Url
And Enter Username 'DemoSalesManager'
And Enter Password 'crmsfa'
When Click Login
Then Homepage should be displayed

