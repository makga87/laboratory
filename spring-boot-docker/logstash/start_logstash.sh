#!/usr/bin/env bash

docker run --rm -it \
   -p 15044:15044 \
   -p 9600:9600 \
   -e "LS_JAVA_OPTS=-Xmx256m -Xms256m" \
   -v $PWD/pipeline/:/usr/share/logstash/pipeline \
   -v $PWD/config/logstash.yml:/usr/share/logstash/config/logstash.yml \
   -v $PWD/config/pipelines.yml:/usr/share/logstash/config/pipelines.yml \
   docker.elastic.co/logstash/logstash:7.16.3
