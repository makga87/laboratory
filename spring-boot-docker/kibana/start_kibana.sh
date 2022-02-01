#!/usr/bin/env bash
docker run -p 127.0.0.1:5601:5601 \
  -e "ELASTICSEARCH_HOSTS=http://host.docker.internal:9200" \
  docker.elastic.co/kibana/kibana:7.17.0
