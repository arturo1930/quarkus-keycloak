# quarkus-keycloak

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-keycloak-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- REST JSON-B ([guide](https://quarkus.io/guides/rest#json-serialisation)): JSON-B serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- SmallRye JWT ([guide](https://quarkus.io/guides/security-jwt)): Secure your applications with JSON Web Token

## Provided Code

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

# KeyCloak Config

https://www.youtube.com/watch?v=zaVmgAp5MY0

https://github.com/tuxtor/microprofile-samples

## Intalar en windows
```
    keycloak/bin/
    kc.bat start-dev --http-port 8086
```

Para poderse conectar a keykloak se debe autorizar al microservicio o al cliente, los clientes son unicos

- Creacion de un cliente
    -   Nombre: microprofiledemo
    -   Protocolo: OpenIDConnect

Realm: Master
    Group: DEMO_KEYCLOAK
    USER: prueba
    
# Conectarse a KEYCLOAK
http://localhost:8086/realms/master/protocol/openid-connect/token

```
var settings = {
  "url": "http://localhost:8086/realms/master/protocol/openid-connect/token",
  "method": "POST",
  "timeout": 0,
  "headers": {
    "Content-Type": "application/x-www-form-urlencoded"
  },
  "data": {
    "realm": "master",
    "grant_type": "password",
    "client_id": "microprofile",
    "username": "prueba",
    "password": "prueba",
    "client_secret": "g0VPNy4A3WdUcoNPqSVTI3Xo4LNRK4OJ"
  }
};

$.ajax(settings).done(function (response) {
  console.log(response);
});
```
# Ver informacion del token de keycloak
https://jwt.io/

# Configuracion en el proyecto
- certificado publico: http://localhost:8086/realms/master/protocol/openid-connect/certs
- 