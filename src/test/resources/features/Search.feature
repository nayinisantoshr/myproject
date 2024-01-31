Feature: Search functionality on different search engines

  @test
  Scenario Outline: Search on browser
    Given I am on the "<searchEngine>" search engine
    When I search for "<searchKeyword>"
    Then the first result should be "<expectedResult>"

    Examples:
      | searchEngine | searchKeyword      | expectedResult                                        |
      | Google       | cucumber framework | Cucumber: BDD Testing & Collaboration Tools for Teams |
