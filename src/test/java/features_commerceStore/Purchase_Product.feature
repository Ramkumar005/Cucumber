Feature: Purchase order 

Scenario: Hair Product Purchase order 

	Given Click Shop now
	And Click Products under Hair Products section 
	And Click Hair Beauty Bath 
	And Click Add to cart 
	And Verify Cart Count 
	And Click Cart
	And Click Checkout
	And Click the Shipping Method dropdown and select 'Worldwide - $5.00 USD' 
	When Click Make payment 
	Then Read the order number and print it in console