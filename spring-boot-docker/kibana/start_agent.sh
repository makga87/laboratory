#!/usr/bin/env bash

java -javaagent:./apm_agent/elastic-apm-agent-1.28.4.jar \
-Delastic.apm.service_name=spring-boot-docker \
-Delastic.apm.server_urls=http://localhost:8200 \
-Delastic.apm.secret_token= \
-Delastic.apm.environment=local \
-Delastic.apm.application_packages=com.example.docker \
-jar ../target/spring-boot-docker-0.0.1-SNAPSHOT.jar