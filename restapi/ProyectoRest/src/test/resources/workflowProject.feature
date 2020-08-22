Feature: Project API

  Scenario: Como usuario comun
  Quiero crear un proyecto
  PAra monitoriar mis tareas


    Given yo tengo mi token usando mi usuario: javierapi@api.com y password: api123
    When yo envio un POST request a la url http://todo.ly/api/projects.json con json body
    """
    {
      "Content" : "SESSION3",
      "Icon":4
    }
    """
    Then yo espero que mi codigo de respuesta sea 200
    And espero que la propiedad : Content creado sea SESSION3
    And espero que la propiedad int : Icon creado sea 4
    And yo guardo el valor de Id en la variable ID_PROYECTO



    When yo envio un PUT request a la url http://todo.ly/api/projects/ID.json usando el ID : ID_PROYECTO con json body
    """
    {
      "Content" : "UPDATE",
      "Icon":4
    }
    """
    Then yo espero que mi codigo de respuesta sea 200
    And espero que la propiedad : Content creado sea UPDATE
    And espero que la propiedad int : Icon creado sea 4



    When yo envio un DELETE request a la url http://todo.ly/api/projects/ID.json usando el ID : ID_PROYECTO
    Then yo espero que mi codigo de respuesta sea 200