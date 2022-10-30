FROM adoptopenjdk/openjdk11:ubi
ADD target/Banking-1.0-SNAPSHOT.jar app.jar
ADD src/main/resources/application.yml app-config.yml
EXPOSE 8020
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar", "server", "app-config.yml"]