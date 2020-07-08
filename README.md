<!--- some badges to display on the GitHub page -->

![Travis (.org)](https://img.shields.io/travis/debuglevel/iban-microservice?label=Travis%20build)
![Gitlab pipeline status](https://img.shields.io/gitlab/pipeline/debuglevel/iban-microservice?label=GitLab%20build)
![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/debuglevel/iban-microservice?sort=semver)
![GitHub](https://img.shields.io/github/license/debuglevel/iban-microservice)

# IBAN Microservice

This is a simple REST microservice to validate IBANs.

# HTTP API

## Swagger / OpenAPI

There is an OpenAPI (former: Swagger) specification created, which is available at <http://localhost:8080/swagger/greeter-microservice-0.1.yml>, `build/tmp/kapt3/classes/main/META-INF/swagger/` in the source directory and `META-INF/swagger/` in the jar file. It can easily be pasted into the [Swagger Editor](https://editor.swagger.io) which provides a live demo for [Swagger UI](https://swagger.io/tools/swagger-ui/), but also offers to create client libraries via [Swagger Codegen](https://swagger.io/tools/swagger-codegen/).

## Get greeting

To get an appropriate greeting for a person, send a GET request to the service:

```
$ curl -X GET http://localhost/greetings/Johnny%20Knoxville
{
  "greeting" : "You did not provide a language, but I'll try english: Hello, Johnny Knoxville!"
}
```

You can also define a language as query parameter:

```
$ curl -X GET http://localhost/greetings/Johnny%20Knoxville?language=de_DE
{
  "greeting" : "Grüß Gott, Johnny Knoxville"
}
```

## Add greeting

In this example, a greeting can also be POSTed. This way, the payload is transferred in the body as JSON (which is often a better idea than putting it in the URL or parameters, due to URL encoding issues).

```
$ curl -X POST -d '{"name":"Max", "language":"de_DE"}' -H "Content-Type: application/json" http://localhost/greetings/
```

# Configuration

There is a `application.yml` included in the jar file. Its content can be modified and saved as a separate `application.yml` on the level of the jar file. Configuration can also be applied via the other supported ways of Micronaut (see <https://docs.micronaut.io/latest/guide/index.html#config>). For Docker, the configuration via environment variables is the most interesting one (see `docker-compose.yml`).
