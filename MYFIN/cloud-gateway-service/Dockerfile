FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cloud-gateway-registry.jar
ENTRYPOINT ["java", "-jar", "/cloud-gateway-registry.jar"]