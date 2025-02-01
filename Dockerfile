# Use an image with JDK to build your app
FROM maven:3.8.1-openjdk-21-slim AS builder

# Set the working directory
WORKDIR /app

# Copy your project files to the container
COPY . /app

# Build your app (this generates the target/ directory and the .jar file)
RUN mvn clean install -DskipTests

# Use a lightweight Amazon Corretto image to run the app
FROM amazoncorretto:21-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the .jar from the builder stage
COPY --from=builder /app/target/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar /app/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar"]