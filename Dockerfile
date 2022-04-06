FROM openjdk:latest
COPY ./target/test1.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "test1.jar", "app_db:3306", "30000"]