FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} authentication-service.jar
ENTRYPOINT ["java", "-jar", "/authentication-service.jar"]