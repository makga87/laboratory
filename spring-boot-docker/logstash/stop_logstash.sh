#!/usr/bin/bash

docker stop `(docker ps | grep logstash | awk '{print $1}')`
