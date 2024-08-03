FROM openjdk:22-jdk-buster

WORKDIR /dbh-command-service-app

COPY target/dbh-command-service-v1.jar dbh-command-service-app.jar

EXPOSE 8003

ENTRYPOINT ["java", "-jar", "dbh-command-service-app.jar"]