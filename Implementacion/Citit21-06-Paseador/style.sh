#!/bin/bash

BASE=src/main/java
SOURCES=$(find $BASE -name "*.java")

clang-format -i $SOURCES -style=file