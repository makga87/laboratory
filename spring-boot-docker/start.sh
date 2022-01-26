#!/usr/bin/env bash

docker run -d -p 8012:8080 \
  -e URLS_PRIMARY_NAME=SpringRestdocs \
  -e URLS="[ \
    { url: 'docs/swagger.json', name: 'Swagger' } \2
    , { url: 'docs/restdocs.json', name: 'SpringRestdocs' } \
  ]" \
  -v "$PWD"/target/restdoc-spec/:/usr/share/nginx/html/docs/ \
  swaggerapi/swagger-ui
