#!/usr/bin/env bash

docker run -d -p 8012:8080 \
  -e URLS_PRIMARY_NAME=SpringRestdocs \
  -e URLS="[ \
    { url: 'docs/openapi-3.0.json', name: '사용자조회 api' } \
  ]" \
  -v $PWD/target/restdocs-spec/:/usr/share/nginx/html/docs/ \
  swaggerapi/swagger-ui
