Feature: Search functionality on different search engines

  @test
  Scenario Outline: Search on browser
    Given I am on the "<searchEngine>" search engine
    When I search for "<searchKeyword>"
    Then the first result should be present

    Examples:
      | searchEngine | searchKeyword      |
      | Google       | cucumber framework |
      | Bing         | cucumber framework |
      | Yahoo        | cucumber framework |


