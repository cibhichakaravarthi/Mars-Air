#language: en

@tw @invalidReturnDates
Feature: Invalid Return Dates
  As a MarsAir Sales Director (Mark)
  I want to prevent potential customers from searching for invalid trips
  So that they don’t waste time, and book valid ones

  Background:
    Given user is in the home page

  Scenario Outline: return can not be less than 1 year from the departure date
    Given user selects a departure date <departure>
    And user selects a return date <return>
    When click on search button
    Then an invalid return date message should be displayed
    Examples:
      | departure                       | return                          |
      | 'July'                          | 'July'                          |
      | 'July'                          | 'December'                      |
      | 'December'                      | 'December'                      |
      | 'December'                      | 'July (next year)'              |
      | 'July (next year)'              | 'July (next year)'              |
      | 'July (next year)'              | 'December (next year)'          |
      | 'December (next year)'          | 'December (next year)'          |
      | 'December (next year)'          | 'July (two years from now)'     |
      | 'July (two years from now)'     | 'July (two years from now)'     |
      | 'July (two years from now)'     | 'December (two years from now)' |
      | 'December (two years from now)' | 'December (two years from now)' |