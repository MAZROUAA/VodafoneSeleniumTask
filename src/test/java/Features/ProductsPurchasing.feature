Feature: Product Purchasing
  I want to check that products are purchased successfully.

  Scenario Outline:  two products purchasing
    Given  the user has registered successfully using "<username>" , "<password>"
    When The user clicks on Log in button in Header
    And  Fill "<username>" , "<password>" in Log in Form
    Then The account should open Successfully
    When The user Clicks on Laptops in categories in home page.
    And  Chooses product one and Clicks on Add to cart button
    Then The product is successfully added
    When The user Chooses product two and Clicks on Add to cart button
    Then The other product is successfully added
    When The user Clicks on Cart button in header
    Then The two products which include (title and Price) are successfully should be added in products page and the total amount is calculated correctly
    When The user Clicks on Place order button
    Then The total amount should be calculated correctly in place order page
    When The user Fills the (Name, Country, City, Credit Card, Month and Year)
    And  The user Clicks on Purchase button in place holder Form
    Then The message ‘Thank you for your purchase!’ should be displayed

    Examples:
      | username | password
      | User4508 | 1234