## Spring Boot Security OAuth2 Client Application


Client application that uses both authorization code and client credential grant types.


Calls `spring-security-oauth2-resource-server` to get username from it.


Before using application configure `application.yaml`.


### Endpoints
* <http://localhost:8081/free>: unprotected resource
* <http://localhost:8081/local-username>: returns username from the app
* POST <http://localhost:8081/local-username>: same as above; it just tests CSRF is disabled
* <http://localhost:8081/authorization-code-username>: returns username from resource server using authorization code web client (user that is logged in)
* <http://localhost:8081/client-credentials-username>: returns username from resource server using client credentials  web client (application client)