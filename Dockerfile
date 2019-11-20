FROM openjdk:8-jdk-alpine3.9
ADD target/drivers_license_service-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar drivers_license_service-0.0.1-SNAPSHOT.jar