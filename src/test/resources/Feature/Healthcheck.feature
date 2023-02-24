@ui @healthcheck

Feature: E-commerce Website healthcheck
@prodisc
Scenario: user is able to open the browser and check product specification 
Given User is open the browser 
And User is nevigate and landing the e-commerce website page 
When User type the product name to be search "Puma"
Then User click on selected product from the list "Puma Casual Shoes"
Then User select the product and specification check on new tab
#Then Search result is displayed "Laptop"
Then User close the window 
 

