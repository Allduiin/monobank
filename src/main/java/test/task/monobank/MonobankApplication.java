package test.task.monobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonobankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonobankApplication.class, args);
    }
}
