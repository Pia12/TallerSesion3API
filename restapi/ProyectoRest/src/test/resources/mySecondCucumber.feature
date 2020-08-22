Feature: Login

  # Generar comentarios
  Scenario Outline:  como usuario administrador
  quiero loguearme en mi aplicacion usando email y password
  para ingresar de forma segura a mi cuenta

    Given yo tengo acceso a facebook
    And yo tengo acceso a whatsapp
    And yo tengo acceso a universidad
    And yo tengo acceso a todo.ly
    And usando mi cuenta de administrador
    When lleno el campo email con <email>
    And lleno el campo password con <password>
    Then yo deberia ingresar en la pagina principal

    Examples:
      |email|password |
      |cucumber1@gmail.com     | 123|
      |cucumber2@gmail.com     | 234|
      |cucumber3@gmail.com     | 345|



  Scenario Outline:  como usuario administrador
  quiero loguearme en mi aplicacion usando email y password
  para ingresar de forma segura a mi cuenta

    Given yo tengo acceso a facebook
    And yo tengo acceso a whatsapp
    And yo tengo acceso a universidad
    And yo tengo acceso a todo.ly
    And usando mi cuenta de administrador
    When lleno el campo email con <email>
    And lleno el campo password con <password>
    Then yo deberia ingresar en la pagina principal

    Examples:
      |email|password |
      |cucumber1@gmail.com     | 123|
      |cucumber2@gmail.com     | 234|
      |cucumber3@gmail.com     | 345|


  # tags ----> Suites  ---> una forma de agrupar test cases
  @SmokeTest @Regresion @SanityTest
  Scenario: Como usuario administrator
  Quiero loguearme en mi aplicacion usando email y password
  Para ingresar de forma seguro a mi cuenta

    Given yo tengo acceso a facebook
    And yo tengo acceso a whatsapp
    And yo tengo acceso a universidad
    And yo tengo acceso a todo.ly
    And usando mi cuenta de administrador
    When lleno el campo email con cucumber@cucumber.com
    And lleno el campo password con MiPassword123
    Then yo deberia ingresar en la pagina principal