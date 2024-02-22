# Build Stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime Stage
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/FBHelpdesk.jar FBHelpdesk.jar
EXPOSE 5001
ENTRYPOINT ["java", "-jar", "FBHelpdesk.jar"]
