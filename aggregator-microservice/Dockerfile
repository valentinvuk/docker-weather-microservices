FROM amazoncorretto:17
ADD build/libs/aggregator-microservice-0.0.1-SNAPSHOT.jar /opt/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]
