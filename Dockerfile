# Use an official Maven image with OpenJDK 21 to build the app
FROM maven:3.8.1-openjdk-21 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the source code into the container
COPY . /app

# Build the app (this generates the target/ directory and .jar file)
RUN mvn clean install -DskipTests

# Use Amazon Corretto 21 as a minimal JDK to run the app
FROM amazoncorretto:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the .jar file from the build stage
COPY --from=builder /app/target/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar /app/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar"]