#!/usr/bin/env bash

docker run --rm -it \
   -v $PWD/pipeline/:/usr/share/logstash/pipeline \
   -v $PWD/config/:/usr/share/logstash/config \
   docker.elastic.co/logstash/logstash:7.16.3
