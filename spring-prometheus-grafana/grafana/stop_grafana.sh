#!/usr/bin/env bash

docker stop `(docker ps | grep grafana | awk '{print $1}')`
