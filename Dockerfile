# Use the JDK image to build the application
FROM openjdk:17-jdk-slim as build

WORKDIR /app

# Copy Gradle wrapper and build files
COPY ./gradlew ./
COPY ./gradle ./gradle
COPY ./build.gradle.kts ./build.gradle.kts
COPY ./settings.gradle.kts ./settings.gradle.kts
COPY ./src ./src

# Give execute permission to the gradlew
RUN chmod +x gradlew

# Build the JAR file
RUN ./gradlew clean build --no-daemon

# Create a new image to run the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR file into the container
COPY --from=build /app/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
