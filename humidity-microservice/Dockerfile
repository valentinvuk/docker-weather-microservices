FROM amazoncorretto:17
ADD build/libs/humidity-microservice-0.0.1-SNAPSHOT.jar /opt/app.jar
ADD readings.csv /
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]
