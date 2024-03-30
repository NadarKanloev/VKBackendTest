FROM openjdk:17

WORKDIR /app

COPY target/VKBackendTest-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "VKBackendTest-0.0.1-SNAPSHOT.jar"]
