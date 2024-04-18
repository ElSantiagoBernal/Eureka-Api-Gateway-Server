FROM eclipse-temurin:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} users.jar
ENTRYPOINT ["java", "-jar", "/users.jar"]