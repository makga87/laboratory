#!/usr/bin/env bash

docker run -d -p 80:8080 \
  -e URLS_PRIMARY_NAME=SpringRestdocs \
  -e URLS="[ \
    { url: 'docs/swagger.json', name: 'Swagger' } \2
    , { url: 'docs/restdocs.json', name: 'SpringRestdocs' } \
  ]" \
  -v /Users/hgkim/Desktop/intellij/workspace/laboratory/spring-boot-docker/target/restdoc/snippets/helloWorld/:/usr/share/nginx/html/docs/ \
  swaggerapi/swagger-ui
