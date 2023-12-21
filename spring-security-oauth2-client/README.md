# Spring Boot Security OAuth2 Client Application

This client application demonstrates the use of both authorization code and client credential grant types in OAuth2.

## Usage

The client application interacts with `spring-security-oauth2-resource-server` to retrieve the username.

### Endpoints

- **Unprotected Resource:** [http://localhost:8081/free](http://localhost:8081/free) - Access an unprotected resource. Expected outcome: `free`.

- **Local Username Endpoint:** [http://localhost:8081/local-username](http://localhost:8081/local-username) - Returns the username from the application. Expected outcome: `user` if provided realm is used.

  - **POST Version:** [http://localhost:8081/local-username](http://localhost:8081/local-username) (POST) - Same as above, testing CSRF is disabled. Expected outcome: `user` if provided realm is used.

- **Authorization Code Username Endpoint:** [http://localhost:8081/authorization-code-username](http://localhost:8081/authorization-code-username) - Returns the username from the resource server using the authorization code web client (for a logged-in user). Expected outcome: `user` if provided realm is used.

- **Client Credentials Username Endpoint:** [http://localhost:8081/client-credentials-username](http://localhost:8081/client-credentials-username) - Returns the username from the resource server using the client credentials web client (for the application client). Expected outcome: `service-account-oauth2-client` if provided realm is used.
