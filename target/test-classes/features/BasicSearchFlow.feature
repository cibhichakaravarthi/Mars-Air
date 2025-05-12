#language: en

@tw
Feature: Basic Search Flow
  As a MarsAir Sales Director (Mark)
  I want potential customers to be able to search for flights to Mars
  So that they see what trips are available

  Background:
    Given user is in the home page

  @searchFields
  Scenario: There should be a "departure" field on a search form
    Then departure field should be available

  @searchFields
  Scenario: There should be a "return" field on a search form
    Then return field should be available

  @seatsAvailability
  Scenario: Check success message for available seats
    Given user selects a departure date "July"
    And user selects a return date "December (two years from now)"
    When click on search button
    Then a success message for available seats should be displayed

  @seatsAvailability
  Scenario: Check message for no available seats
    Given user selects a departure date "July"
    And user selects a return date "July (two years from now)"
    When click on search button
    Then a message for no available seats should be displayed