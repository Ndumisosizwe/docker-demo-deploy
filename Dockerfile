FROM openjdk:8
ADD target/docker-springboot-demo.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]