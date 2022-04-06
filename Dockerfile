FROM openjdk:latest
COPY ./target/test1.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "test1.jar", "MYSQL_DB_HOST", "30000"]