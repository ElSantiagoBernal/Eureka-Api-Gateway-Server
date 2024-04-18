FROM eclipse-temurin:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} hosts.jar
ENTRYPOINT ["java", "-jar", "/hosts.jar"]