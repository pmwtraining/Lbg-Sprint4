FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /home/app
COPY src ./src
COPY pom.xml ./pom.xml
RUN mvn -f ./pom.xml clean package


FROM openjdk:11-jre-slim

WORKDIR /home/app
COPY --from=build ./target/SprintTwo-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT [ 'java', '-jar', './app.jar' ]