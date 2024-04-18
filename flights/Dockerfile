FROM eclipse-temurin:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} flights.jar
ENTRYPOINT ["java", "-jar", "/flights.jar"]