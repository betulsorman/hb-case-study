Feature: Product Detail Test Scenarios

  Background:
    When dismiss onboarding tool tip
    When search "samsung galaxy s23" product
    Then validate product list has product "samsung galaxy s23"
    Then click first product

  Scenario Outline: Validate product info on Products page
    Then User validates product details page with product "<product>"
    Examples:
      | product            |
      | samsung galaxy s23 |

  Scenario: Validate add product to cart
    When User clicks add to cart
    Then User validates product added to cart successfully
    When User clicks navigate to cart
    Then User validates product is in my cart

  Scenario: Validate reviews on product details
    When User clicks all reviews
    Then User validates review list opened
    Then Validate number of reviews on product and reviews page match

  Scenario: Validate product added to comparison list
    When User clicks compare products
    Then User validates product added to comparison list successfully

  Scenario: Validate merchant on product details
    When User clicks merchant
    Then User validates merchant page opened with correct merchant name
