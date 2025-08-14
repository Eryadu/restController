FROM openjdk:17
LABEL mentainer="xyz@gmail.com"
LABEL description="Design pattern app image"
WORKDIR /app
COPY target/designPattern-0.0.1-SNAPSHOT.jar /app/designdocker.jar
ENTRYPOINT ["java", "-jar", "designdocker.jar"]