#language: en

@tw @promoCodes
Feature: Promotional Codes
  As a MarsAir Sales Director (Mark)
  I want to distribute promotional codes to customers
  So that they get discounts and are more tempted to purchase tickets

  Background:
    Given user is in the home page

  Scenario Outline: User uses a valid code
    Given user selects a departure date "July"
    And user selects a return date "December (two years from now)"
    And user informs a promotional code <valid code>
    When click on search button
    Then the search result should have a message <valid message>
    Examples:
      |  valid code      | valid message                                      |
      | 'AF1-FJK-427'    | 'Promotional code AF1-FJK-427 used: 10% discount!' |
      | 'GH9-LRY-009'    | 'Promotional code GH9-LRY-009 used: 90% discount!' |
      | 'AF5-FJK-500'    | 'Promotional code AF5-FJK-500 used: 50% discount!' |
      | 'BL7-WZU-131'    | 'Promotional code BL7-WZU-131 used: 70% discount!' |
      | 'AF0-FJK-437'    | 'Promotional code AF0-FJK-437 used: 00% discount!' |

  Scenario Outline: User uses an invalid code
    Given user selects a departure date "July"
    And user selects a return date "December (two years from now)"
    And user informs a promotional code <invalid code>
    When click on search button
    Then the search result should have a message <invalid message>
    Examples:
      |  invalid code    | invalid message                        |
      | 'AF1-FJK-428'    | 'Sorry, code AF1-FJK-428 is not valid' |
      | 'AF1-FJK-426'    | 'Sorry, code AF1-FJK-426 is not valid' |
      | 'AF8-FJK-447'    | 'Sorry, code AF8-FJK-447 is not valid' |
      | 'AF8-FJK-445'    | 'Sorry, code AF8-FJK-445 is not valid' |
      | '004x000*228'    | 'Sorry, code 004x000*228 is not valid' |