Feature: Login
     Scenario:  como usuario administrador
                quiero loguearme en mi aplicacion usando email y password
                para ingresar de forma segura a mi cuenta

       Given yo tengo acceso a facebook
       And yo tengo acceso a whatsapp
       And yo tengo acceso a universidad
       And yo tengo acceso a todo.ly
       And usando mi cuenta de administrador
       When lleno el campo email con cucumber@cucumber.com
       And lleno el campo password con MiPassword123
       Then yo deberia ingresar en la pagina principal

