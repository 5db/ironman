#!/bin/sh

# Set environment variables so that Java and Groovy is accessible
export JAVA_HOME=/home/jsingh/dev/jdks/jdk1.7.0_21
export M2_HOME=/home/jsingh/dev/maven/apache-maven-3.0.5
PATH=$PATH:$JAVA_HOME/bin:$M2_HOME/bin
export PATH

mvn clean
