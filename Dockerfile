FROM amazoncorretto:21-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled jar file from your local machine to the container
COPY target/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar /app/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/hng-stage-0-backend-task-2024-0.0.1-SNAPSHOT.jar"]
