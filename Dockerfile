FROM openjdk:latest
COPY ./target/test1-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "test1-0.1.0.1-jar-with-dependencies.jar"]