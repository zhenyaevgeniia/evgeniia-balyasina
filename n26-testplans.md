TASK2

My suggestion to create scenarios for Best Buy API Playground for each listed endpoint with following priority:
1. Healthy check endpoints to check that service works in general.
2. CRUD with valid data for each of endpoint to check that endpoints are working.
3. CRUD with invalid data for each endpoint to check error messages are taken correctly (without 500).
4. Specific situations, such are dependencies.

2 and 3 are covered in Services.feature.

1 could be covered same way as GET /services.
For version I would hardcode the version in test to let the test fail after first version update. To be sure that version number is updated correctly.
For healthcheck success status is the most critical part.
Response body and values for healthcheck should be discussed with developers or product managers, ex. is there any limit for uptime.

Initially it was a plan to cover 4 by creating feature "Stores" because of connection with "Services".
Example of specific scenario could be following:
 Scenario: DELETE services used in stores
 Given POST services is sent with body
 """
    "name": "POST service for store"
 """
 And POST stores is sent with body
 """
    "name": "POST store"
    ...
    "service": {LAST_CREATED_SERVICE}
 """
 When DELETE last created service is sent
 Then .... [here either success either 404, depend on implementation]

Unfortunately, documentation does't provide the way how Stores and Services could be connected.
I've tried in Postman POST http://localhost:3030/stores with body
    {
    "name": "POST stores test",
    ...
    "services":
     {
        "id": 1
     }
    }
Entity was created as a result but with "services": {}.
Possible solutions:
- find the way how services could be linked with stores and update documentation;
- if there is bug here that services should come in post, create a ticket to fix the bug.
