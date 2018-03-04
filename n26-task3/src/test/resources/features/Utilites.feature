@API @utilities
Feature: Utilities scenarios

  #I suggest to keep here version hardcoded and manually update it here together when version is updated in code.
  #To avoid the situation that tests and code take the version value from one source.
  Scenario: GET version
    Given GET 'version' is sent
    Then last response should have status '200'
    And last response should equal
    """
    {
    "version": "1.1.0"
    }
    """

  #Steps for verifying the values could be added in next iteration when requirements of content are more specified
  Scenario: GET healthcheck
    Given GET 'healthcheck' is sent
    Then last response should have status '200'
    And last response should not be empty

