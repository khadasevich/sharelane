Feature: Search
  Scenario: Search for offline Front-end course
    Given Main TMS page opened
    When User goes to "Курсы"
    And Selects "Офлайн курсы"
    Then "Front End" course presents on page