FROM openjdk:8-jre-alpine3.9
VOLUME /tmp
ARG JAR_FILE=target/spring-camel-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java" , "-jar", "/app.jar"]