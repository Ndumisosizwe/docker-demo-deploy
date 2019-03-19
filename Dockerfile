FROM openjdk:8
ADD target/docker-demo-java.jar docker-demo-java.jar
EXPOSE 8182
ENTRYPOINT ["java", "-jar", "docker-demo-java.jar"]