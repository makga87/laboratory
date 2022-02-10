#!/usr/bin/env bash

docker stop `(docker ps | grep prometheus | awk '{print $1}')`
