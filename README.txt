Java 11
Spring Boot 2.6.14-SNAPSHOT
MVN 3.8.1

1 - Solicitar token al endpoint: localhost:8080/token con Body
        {
            "username": "cencosuduser",
            "password": "easypass"
        }

2 - Hacer GET REQUEST a endpoint: http://localhost:8080/listarUsuarios con Bearer token

3 - Hacer POST Request a endpoint: http://localhost:8080/buscarUsuario
Body:
    {
          "id":"10",
          "first_name":"Byron"
    }
-Replazar id y Name del body con valores
-Agregar Bearer Token


