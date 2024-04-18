FROM eclipse-temurin:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} comments.jar
ENTRYPOINT ["java", "-jar", "/comments.jar"]