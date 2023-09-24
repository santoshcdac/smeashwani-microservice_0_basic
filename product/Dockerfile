#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

#Information around who maintains the image
Label project=training.com

# Add the application's jar to the image
COPY target/product*.jar app.jar

# execute the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Create image
# Docker build . -t smeashwani/product:dev
# create container
# Docker run -it -p 8881:8888 smeashwani/product:dev
# Docker run -it -p 8882:8888 smeashwani/product:dev
# push image to hub.docker.com , must be login
# Docker push 
