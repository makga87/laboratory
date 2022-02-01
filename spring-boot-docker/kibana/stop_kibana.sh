#!/usr/bin/bash

docker stop `(docker ps | grep kibana | awk '{print $1}')`
