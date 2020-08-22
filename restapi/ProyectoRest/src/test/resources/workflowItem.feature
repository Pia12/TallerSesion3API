Feature: Item Api

  Scenario: como usuario comun
  quiero crear un Item
  para monitorear  mis tareas

    Given yo tengo un token usando mi usuario: javierapi@api.com y password: api123
    When  yo envio un POST a la url https://todo.ly/api/items.json con json body
    """
    {
     "Content": "Item_Taller02"
    }
    """
    Then espero que mi codigo de respuesta sea 200
    And  yo espero que la propiedad : Content creado sea Item_Taller02
    And guardo el valor de Id en la variable ID_ITEM


    When  envio un PUT request a la url https://todo.ly/api/items/ID.json usando el ID : ID_ITEM con json body
    """
    {
      "Content": "UPDATE_ITEM02"
    }
    """
    Then espero que mi codigo de respuesta sea 200
    And yo espero que la propiedad : Content creado sea UPDATE_ITEM02

    When  envio un DELETE request a la url https://todo.ly/api/items/ID.json usando el ID : ID_ITEM
    Then  espero que mi codigo de respuesta sea 200