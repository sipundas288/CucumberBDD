Feature: Customers
Background: Steps common for all scenarios
Given User Launch Chrome browser
	When User opens URL "http://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view Dashbord

@Regression
Scenario: Add New Customer


	When User click on customers Menu
	And  click on customer Menu Item
	And click on Add new button
	Then User can view Add new customer page
	When User enter customer info
	And click on save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser
 @Regression
 Scenario: Search Customer by Email
 
	When User click on customers Menu
	And click on customer Menu Item
	And clich on search bar
	And Enter customer EMail
	When Click on search button
	Then User should found Email in the Search table
	And close browser 
@Regression	
Scenario: Search Customer by Name

	When User click on customers Menu 
	And click on customer Menu Item 
	And Enter customer FirstName
	And Enter customer LastName
	When Click on search button
	Then User should found Name in the Search table
	And close browser 