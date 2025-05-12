#language: en

@tw @logo @linkToPage
Feature: Link to Home Page
  As a MarsAir Sales Director (Mark)
  I want potential customers to be able to go back to the flight search from anywhere on the site
  So that they are guided towards booking trips

  Background:
    Given user is in the home page

  Scenario: User is in the main page so clicking the MarsAir logo on the top left should refresh the page
    When user clicks on the MarsAir logo on the top left from home
    Then user should be taken to home page

  Scenario: User is in the results page so clicking the MarsAir logo on the top left should go to the home page
    Given user selects a departure date "July"
    And user selects a return date "July (two years from now)"
    And click on search button
    When user clicks on the MarsAir logo on the top left from search results page
    Then user should be taken to home page