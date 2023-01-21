FROM amazoncorretto:17
ADD build/libs/eureka-server-0.0.1-SNAPSHOT.jar /opt/app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]
