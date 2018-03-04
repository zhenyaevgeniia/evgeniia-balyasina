#Here is an example how I would test each of endpoint with CRUD operations
#Ideally names and values should have a random data. Ex. "name": "TestService_"+RANDOM_NUMBER
#Services were chosen because of dependency with stores

@API @services
Feature: Services scenarios

  #Scenario will fail because implementation is made based on documentation http://localhost:3030/docs/#!/services/addService
  Scenario: POST services
    When POST services is sent with body
    """
      {
        "name": "POST service"
      }
    """
    Then last response should have status '200'
    # And last response content type should be equal "application/json; charset=utf-8"
    And last response should be empty

  #Let's make an assumption that swagger documentation is wrong and POST should return 201.
  #In that case, scenario given above could be combined with following
  Scenario: POST services. GET services/{id}
    Given GET 'services' is sent
    And total number of services is stored
    When POST services is sent with body
    """
      {
        "name": "POST service for GET id"
      }
    """
    Then last response should have status '201'
    And last response should contain following data
      | name | POST service for GET id |
    When GET services with id of last created service
    Then last response should have status '200'
    And last response should contain last created service
    Then GET 'services' is sent
    And total number should be increased to 1

  #This scenario could be combined with previous one. Didn't find which filters could be used, GET http://localhost:3030/services?limit=5 returns 500
  Scenario: GET services
    When GET 'services' is sent
    Then last response should have status '200'
    And last response should not be empty


  Scenario: PATCH services.
    Given POST services is sent with body
    """
      {
        "name": "POST service for PATCH"
      }
    """
    And GET 'services' is sent
    And total number of services is stored
    When PATCH last created service is sent with body
    """
      {
        "name": "POST service for PATCH updated"
      }
    """
    Then last response should have status '200'
    And last response should contain following data
      | name | POST service for PATCH updated |
    When GET services with id of last created service
    Then last response should contain following data
      | name | POST service for PATCH updated |
    When GET 'services' is sent
    Then total number should not be changed

  #Scenario will fail because implementation is made based on http://localhost:3030/docs/#!/services/deleteservice
  Scenario: DELETE services
    Given POST services is sent with body
    """
      {
        "name": "POST service for DELETE"
      }
    """
    When DELETE last created service is sent
    Then last response should have status '200'
    And last response should be empty

  #In my point of view this scenario should be combined with previous one. Didn't do it because of failed step
  Scenario: GET deleted service by ID
    Given POST services is sent with body
    """
      {
        "name": "POST service for DELETE2"
      }
    """
    And GET 'services' is sent
    And total number of services is stored
    When DELETE last created service is sent
    Then last response should have status '200'
    When GET services with id of last created service
    Then last response should have status '404'
    When GET 'services' is sent
    Then total number should be decreased to 1

