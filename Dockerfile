FROM maven:3-jdk-11-slim AS build

COPY src /home/app/src
COPY pom.xml /home/app/pom.xml
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:11-jre-slim

COPY --from=build /home/app/target/SprintTwo-0.0.1-SNAPSHOT.jar /home/app/app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/home/app/app.jar" ]
