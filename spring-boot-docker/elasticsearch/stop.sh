#!/usr/bin/bash

docker stop `(docker ps | grep elasticsearch | awk '{print $1}')`
