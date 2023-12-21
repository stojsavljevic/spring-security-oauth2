# Spring Boot Security OAuth2 Example Application ![build status](https://github.com/stojsavljevic/spring-security-oauth2/actions/workflows/maven.yml/badge.svg)

This example showcases Spring Security 6 OAuth2 configuration for both the client and resource server.

## Getting Started

To begin, utilize Keycloak for authentication. The recommended starting point is to build the Keycloak image using `docker-compose` and the `docker-compose.yaml` file within the `keycloak` directory. Once the image is built, start it. It will automatically import the `SpringBootKeycloak` realm from `realm-import.json`, which includes the `oauth2-client` client and the user `user/user`. Keycloak is available on port 8080, administrator credentials are `admin/admin`.

If you prefer to use a different Keycloak instance, ensure that Keycloak is correctly configured with the necessary realms, clients, users, and roles. The client must have Service Accounts Enabled for the client credentials flow. Adjust the `application.yaml` in both modules according to your specific settings.

## Usage

The `spring-security-oauth2-client` module communicates with the `spring-security-oauth2-resource-server` to retrieve the username. Refer to [spring-security-oauth2-client/README.md](spring-security-oauth2-client/README.md) for a list of endpoints that demonstrate various authentication mechanisms.

