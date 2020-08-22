Feature: Project API

  Scenario Outline: Como usuario comun
  Quiero crear un proyecto
  PAra monitoriar mis tareas


    Given yo tengo mi token usando mi usuario: javierapi@api.com y password: api123
    When yo envio un POST request a la url http://todo.ly/api/projects.json con json body
    """
    {
      "Content" : "<nombreProjecto>",
      "Icon":<iconoProjecto>
    }
    """
    Then yo espero que mi codigo de respuesta sea 200
    And espero que la propiedad : Content creado sea <nombreProjecto>
    And espero que la propiedad int : Icon creado sea <iconoProjecto>

    Examples:

    | nombreProjecto | iconoProjecto |
    | eynar1         | 1             |
    | eynar2         | 2             |
    | eynar3         | 3             |
    | eynar4         | 4             |