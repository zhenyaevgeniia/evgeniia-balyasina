$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Services.feature");
formatter.feature({
  "name": "Services scenarios",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@services"
    }
  ]
});
formatter.scenario({
  "name": "POST services",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@services"
    }
  ]
});
formatter.step({
  "name": "POST services is sent with body",
  "keyword": "When ",
  "doc_string": {
    "value": "  {\n    \"name\": \"POST service\"\n  }"
  }
});
formatter.match({
  "location": "ServicesDef.postServiceWithAttributes(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "error_message": "java.lang.IllegalStateException: Status code is not 200: 201\n\n{\n    \"createdAt\": \"2018-03-04T10:58:28.388Z\",\n    \"name\": \"POST service\",\n    \"id\": 166,\n    \"updatedAt\": \"2018-03-04T10:58:28.388Z\"\n}\n\tat api.APICore.verifyLastStatusCode(APICore.java:266)\n\tat stepdefs_api.ServicesDef.lastResponseShouldHaveStatus(ServicesDef.java:71)\n\tat ✽.last response should have status \u0027200\u0027(src/test/resources/features/Services.feature:16)\n",
  "status": "failed"
});
formatter.step({
  "name": "last response should be empty",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldBeEmpty()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "POST services. GET services/{id}",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@services"
    }
  ]
});
formatter.step({
  "name": "GET \u0027services\u0027 is sent",
  "keyword": "Given "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "total number of services is stored",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.storeGetServicesTotalNumber()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "POST services is sent with body",
  "keyword": "When ",
  "doc_string": {
    "value": "  {\n    \"name\": \"POST service for GET id\"\n  }"
  }
});
formatter.match({
  "location": "ServicesDef.postServiceWithAttributes(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027201\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should contain following data",
  "rows": [
    {
      "cells": [
        "name",
        "POST service for GET id"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldContain(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET services with id of last created service",
  "keyword": "When "
});
formatter.match({
  "location": "ServicesDef.getServicesByIdOfLastCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should contain last created service",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldContainLastCreatedService()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET \u0027services\u0027 is sent",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "total number should be increased to 1",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.verifyServicesTotalNumberIncreased()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "GET services",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@services"
    }
  ]
});
formatter.step({
  "name": "GET \u0027services\u0027 is sent",
  "keyword": "When "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should not be empty",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldNotBeEmpty()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "PATCH services.",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@services"
    }
  ]
});
formatter.step({
  "name": "POST services is sent with body",
  "keyword": "Given ",
  "doc_string": {
    "value": "  {\n    \"name\": \"POST service for PATCH\"\n  }"
  }
});
formatter.match({
  "location": "ServicesDef.postServiceWithAttributes(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET \u0027services\u0027 is sent",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "total number of services is stored",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.storeGetServicesTotalNumber()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "PATCH last created service is sent with body",
  "keyword": "When ",
  "doc_string": {
    "value": "  {\n    \"name\": \"POST service for PATCH updated\"\n  }"
  }
});
formatter.match({
  "location": "ServicesDef.patchLastCreatedServiceWithAttributes(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should contain following data",
  "rows": [
    {
      "cells": [
        "name",
        "POST service for PATCH updated"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldContain(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET services with id of last created service",
  "keyword": "When "
});
formatter.match({
  "location": "ServicesDef.getServicesByIdOfLastCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should contain following data",
  "rows": [
    {
      "cells": [
        "name",
        "POST service for PATCH updated"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldContain(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET \u0027services\u0027 is sent",
  "keyword": "When "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "total number should not be changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.verifyServicesTotalNumberNotChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "DELETE services",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@services"
    }
  ]
});
formatter.step({
  "name": "POST services is sent with body",
  "keyword": "Given ",
  "doc_string": {
    "value": "  {\n    \"name\": \"POST service for DELETE\"\n  }"
  }
});
formatter.match({
  "location": "ServicesDef.postServiceWithAttributes(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "DELETE last created service is sent",
  "keyword": "When "
});
formatter.match({
  "location": "ServicesDef.deleteLastCreatedService()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should be empty",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldBeEmpty()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Last Response is not empty\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertFalse(Assert.java:64)\n\tat stepdefs_api.ServicesDef.lastResponseShouldBeEmpty(ServicesDef.java:66)\n\tat ✽.last response should be empty(src/test/resources/features/Services.feature:81)\n",
  "status": "failed"
});
formatter.scenario({
  "name": "GET deleted service by ID",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@services"
    }
  ]
});
formatter.step({
  "name": "POST services is sent with body",
  "keyword": "Given ",
  "doc_string": {
    "value": "  {\n    \"name\": \"POST service for DELETE2\"\n  }"
  }
});
formatter.match({
  "location": "ServicesDef.postServiceWithAttributes(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET \u0027services\u0027 is sent",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "total number of services is stored",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.storeGetServicesTotalNumber()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "DELETE last created service is sent",
  "keyword": "When "
});
formatter.match({
  "location": "ServicesDef.deleteLastCreatedService()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET services with id of last created service",
  "keyword": "When "
});
formatter.match({
  "location": "ServicesDef.getServicesByIdOfLastCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027404\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "GET \u0027services\u0027 is sent",
  "keyword": "When "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "total number should be decreased to 1",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.verifyServicesTotalNumberDecreased()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/features/Utilites.feature");
formatter.feature({
  "name": "Utilities scenarios",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@utilities"
    }
  ]
});
formatter.scenario({
  "name": "GET version",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@utilities"
    }
  ]
});
formatter.step({
  "name": "GET \u0027version\u0027 is sent",
  "keyword": "Given "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should equal",
  "keyword": "And ",
  "doc_string": {
    "value": "{\n\"version\": \"1.1.0\"\n}"
  }
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldEqual(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "GET healthcheck",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@API"
    },
    {
      "name": "@utilities"
    }
  ]
});
formatter.step({
  "name": "GET \u0027healthcheck\u0027 is sent",
  "keyword": "Given "
});
formatter.match({
  "location": "ServicesDef.getServices(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should have status \u0027200\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldHaveStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "last response should not be empty",
  "keyword": "And "
});
formatter.match({
  "location": "ServicesDef.lastResponseShouldNotBeEmpty()"
});
formatter.result({
  "status": "passed"
});
});