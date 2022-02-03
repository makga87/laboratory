#!/usr/bin/env bash
docker run --rm -it \
  -p 5601:5601 \
  -e "ELASTICSEARCH_HOSTS=http://host.docker.internal:9200" \
  docker.elastic.co/kibana/kibana:7.16.3
