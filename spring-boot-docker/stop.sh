#!/usr/bin/bash

docker stop `(docker ps | grep swagger | awk '{print $1}')`
