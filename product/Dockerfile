#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
Label project=training.com

# Add the application's jar to the image
COPY target/product*.jar app.jar

# execute the application
ENTRYPOINT ["java", "-jar", "app.jar"]