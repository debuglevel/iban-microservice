<!--- some badges to display on the GitHub page -->

![Travis (.org)](https://img.shields.io/travis/debuglevel/iban-microservice?label=Travis%20build)
![Gitlab pipeline status](https://img.shields.io/gitlab/pipeline/debuglevel/iban-microservice?label=GitLab%20build)
![GitHub release (latest SemVer)](https://img.shields.io/github/v/release/debuglevel/iban-microservice?sort=semver)
![GitHub](https://img.shields.io/github/license/debuglevel/iban-microservice)

# IBAN Microservice

This is a simple REST microservice to validate IBANs.

# HTTP API

## Swagger / OpenAPI

There is an OpenAPI (former: Swagger) specification created, which is available at <http://localhost:8080/swagger/iban-microservice-0.1.yml>, `build/tmp/kapt3/classes/main/META-INF/swagger/` in the source directory and `META-INF/swagger/` in the jar file. It can easily be pasted into the [Swagger Editor](https://editor.swagger.io) which provides a live demo for [Swagger UI](https://swagger.io/tools/swagger-ui/), but also offers to create client libraries via [Swagger Codegen](https://swagger.io/tools/swagger-codegen/).

## Validate IBAN
To validate an IBAN, it has to be POSTed as JSON payload in the body to the service
```shell script
$ curl -X POST -d '{"iban":"DE89370400440532013000"}' -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/validation/
```
which produces this JSON response
```json
{
  "iban" : "DE89370400440532013000",
  "valid" : true
}
```

There is no GET method because passing strings in URLs just leads to too much problems (e.g. whitespaces or awkward characters).

# Configuration

There is a `application.yml` included in the jar file. Its content can be modified and saved as a separate `application.yml` on the level of the jar file. Configuration can also be applied via the other supported ways of Micronaut (see <https://docs.micronaut.io/latest/guide/index.html#config>). For Docker, the configuration via environment variables is the most interesting one (see `docker-compose.yml`).
