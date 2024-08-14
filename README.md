# Yet-Another-Spring-App

This Spring Boot app is used by me to learn and expand my knowledge of the spring ecosystem. It's a backend REST API which provides it's consumers with information about cars. It uses spring security with JWT authentication using the JJWT library, spring data jpa for communicating with the mariaDB instance and spring data rest for HATEOAS.
Companion frontend app written in react: (https://github.com/KuszmarJacek/Yet-Another-React-App)

## Configuration

This app uses mariaDB as it's database so if you want to use mysql or postgresql you need to change this app's configuration yourself.
In order for this app to work you need to provide a .env file in the resources directory. This .env file holds your database credentials aswell as a JWT secret for signing with JJWT library.
If you want to strap in a frontend to it, you will have to modify the `CorsConfigurationSource` bean in security config to allow your frontend app to communicate with the backend. By default `localhost:5173` is allowed, so you can change your frontend port to it or change the cors configuration.

## Security considerations

Right now this app uses a JWT bearer token for authentication, however if you want to use a frontend application, it is advised to use an HttpOnly cookie for jwt storage on the frontend and this is currently not implemented.

## Future ideas

- [ ] Add the ability for users to signup. Check how to work with e-mail verification.
- [ ] Add the ability for an organization to be an owner of a car, thus rething the database schema
- [ ] Add HttpOnly cookie authentication functionality
- [ ] Move secrets to a HashiCorp Vault
- [ ] Move the application to a docker container and provide a docker-compose to run the mariadb and app instance together
- [ ] Add role based and method security for required REST endpoints and methods
- [ ] Add authentication testing
- [ ] Reconsider security requirements and spring authorizaiton server with Oauth or keycloak as your security provider
- [ ] Add the ability to signup users
