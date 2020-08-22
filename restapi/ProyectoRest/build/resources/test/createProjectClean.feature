
Feature: Project API - Clean

  Scenario: Como usuario comun
  Quiero crear un proyecto
  Para monitorias mis tareas

    Given I have token ready to use in Todo.ly
    When I send a POST request http://todo.ly/api/projects.json with json body
    """
    {
      "Content" : "SESSION3",
      "Icon":4
    }
    """
    Then I expected the response code 200
    And I expected the jsonBody
    """
      {
        "Id": "IGNORE",
        "Content" : "SESSION3",
        "ItemsCount": 0,
        "Icon": 4,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [

        ],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """
    And I get the value the attribute Id and save in ID_EYNAR
    And I send a PUT request http://todo.ly/api/projects/ID_EYNAR.json with json body
    """
    {
      "Content" : "UPDATE",
      "Icon":4
    }
    """
    Then I expected the response code 200
    And I expected the jsonBody
    """
      {
        "Id": "IGNORE",
        "Content" : "IGNORE",
        "ItemsCount": 0,
        "Icon": 4,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [

        ],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """
    And I get the value the attribute Id and save in ID_DELETE
    And I send a DELETE request http://todo.ly/api/projects/ID_DELETE.json with json body
    """
    """
    Then I expected the response code 200
