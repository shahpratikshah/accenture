FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} config-gateway-server.jar
ENTRYPOINT ["java", "-jar", "/config-gateway-server.jar"]