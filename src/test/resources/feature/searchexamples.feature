Feature: Search

  Scenario Outline: User goes to main page open Курсы tab selects <type> type and checks <course> course
    Given Main TMS page opened
    When User goes to "Курсы"
    And Selects <type>
    Then <course> course presents on page
    Examples:
      | type         | course      |
      | "Офлайн курсы" | "Front End" |
      | "Офлайн курсы" | "Python"    |