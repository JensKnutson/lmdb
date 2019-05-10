#!/bin/bash
mvn clean && mvn package && \
sudo docker-compose build && \
docker-compose up
