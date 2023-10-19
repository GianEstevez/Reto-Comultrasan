# Use an official Maven runtime as a parent image
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory to the project root
WORKDIR /app

# Copy the Project Object Model (POM) file and the rest of the source code to the container
COPY ./pom.xml ./pom.xml
COPY ./src ./src

# Expose the port your application will run on (change to your application's port)
EXPOSE 8080

# Run spring boot
CMD ["mvn", "spring-boot:run"]

# # Stage 2: Use a smaller image to run the application
# FROM openjdk:17-jdk-slim

# # Set the working directory to /app
# WORKDIR /app

# # Copy the JAR file from the build stage to the new container
# COPY --from=build /app/target/your-app-name.jar ./app.jar

# # Specify the command to run your application
# CMD ["java", "-jar", "app.jar"]
