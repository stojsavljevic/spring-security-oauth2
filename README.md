## Spring Boot Security OAuth2 Example Application


Demonstrates Spring Security 5 OAuth2 configuration for client and resource server.


Uses Keycloak (or GitHub) for authentication. Make sure that Keycloak is properly configured (realm, client, users, roles...). Client needs to have Service Accounts Enabled for client credentials flow.


Configured using Spring Security properties.


`spring-security-oauth2-client` calls `spring-security-oauth2-resource-server` to get username from it.


Before using application configure `application.yaml` in both modules.