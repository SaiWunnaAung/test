FROM openjdk:latest
COPY ./target/test1.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "test1.jar", "db:3306", "500000"]