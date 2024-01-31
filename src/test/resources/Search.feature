Feature: Search functionality on different search engines

  @test
  Scenario Outline: Search on browser
    Given I am on the "<search>" search engine
    When I search for "Cucumber framework"
    Then the first result should be "Cucumber - BDD Testing Framework"
    Examples:
    |search |
    |Google |