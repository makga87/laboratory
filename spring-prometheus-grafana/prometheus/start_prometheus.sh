#!/usr/bin/env bash

docker run --rm -it \
    -p 9090:9090 \
    -v $PWD/config/prometheus.yml:/etc/prometheus/prometheus.yml \
    prom/prometheus