Feature: User tests with database
  Scenario Outline: User tests shopping site with database
    Given User navigates to "amazonURL"
    When User writes some "<products>" into the searchbox and starts search
    Then User clicks first result element
    And User gets productname and productprice
    And User closes to browser
    Examples:
      | products  |
      | Iphone 15 |
       | Iphone 14   |
 | Iphone 13   |
  | PlayStation 5|