#!/usr/bin/env bash
docker run -d --rm -it \
  -p 9200:9200 \
  -p 9300:9300 \
  -e "discovery.type=single-node" \
  -e "ES_JAVA_OPTS=-Xmx256m -Xms256m" \
  docker.elastic.co/elasticsearch/elasticsearch:7.16.3