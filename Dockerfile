# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="mihir.iiest@gmail.com"

COPY ./target/calculateCo2-1.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch calculateCo2-1.jar'

EXPOSE 8001

ENTRYPOINT ["java","-jar","calculateCo2-1.jar"]