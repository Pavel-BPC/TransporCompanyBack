FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY ./api/target/company-exec.jar company-exec.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","company-exec.jar"]