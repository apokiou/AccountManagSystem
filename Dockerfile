# Use an official OpenJDK runtime as a parent image
FROM openjdk:latest

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper and build files to the container
COPY gradlew build.gradle settings.gradle /app/

# Copy the Gradle wrapper folder
COPY gradle /app/gradle

# Copy the source code to the container
COPY src /app/src

# Give execution permission to the Gradle wrapper script
RUN chmod +x gradlew

# Install dependencies and build the application (without running the tests)
RUN ./gradlew build -x test

# Expose the port that the application will run on
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "intrasoft.jar"]
