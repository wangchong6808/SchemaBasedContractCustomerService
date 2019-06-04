#! /usr/bin/env bash

echo `id`
docker run --rm   -v $(pwd):/opt/app -w /opt/app gradle:4.8-jdk8-alpine gradle clean bootRepackage