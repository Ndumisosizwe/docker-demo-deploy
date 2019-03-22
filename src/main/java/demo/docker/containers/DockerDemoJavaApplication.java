package demo.docker.containers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DockerDemoJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerDemoJavaApplication.class, args);
    }
}
