#User can choose options 4,8,12 items for displaying on the page
#All items should have name, photo, add to cart button and rating in stars.

Feature: Apparel and shoes

  Background:
    Given I open Main page and then Apparel & Shoes page

  @option_4 @run
  Scenario: Choose option 4 items
    When I open quantity items dropdown menu
    And choose option four items
    Then I see 4 items on page
    And Each item has name
    And There are 4 names
    And Each item has photo
    And There are 4 photos
    And Each item has add to cart button
    And There are 4 buttons
    And Each item has rating in stars
    And There are 4 ratings

  @option_8 @run
  Scenario: Choose option 8 items
    When I open quantity items dropdown menu
    And choose option eight items
    Then I see 8 items on page
    And Each item has name
    And There are 8 names
    And Each item has photo
    And There are 8 photos
    And Each item has add to cart button
    And There are 8 buttons
    And Each item has rating in stars
    And There are 8 ratings

  @option_12 @run
  Scenario: Choose option 12 items
    When I open quantity items dropdown menu
    And choose option twelve items
    Then I see 12 items on page
    And Each item has name
    And There are 12 names
    And Each item has photo
    And There are 12 photos
    And Each item has add to cart button
    And There are 12 buttons
    And Each item has rating in stars
    And There are 12 ratings