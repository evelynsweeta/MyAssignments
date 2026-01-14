Feature: Create accounts in Salesforce

Scenario: Verify the created accounts name in the Salesforce application

Given Launch the chrome browser and get the url and maximize the window

When Enter the username in the field

And Enter the password in the field

And Click login button

And Click on toggle menu button 

And Click view All and click Sales from App Launcher

And Click on Accounts tab 

And Click on New button 

And Enter account name

And Select Ownership as Public 

And Click save

Then Verify the account name is created successfully