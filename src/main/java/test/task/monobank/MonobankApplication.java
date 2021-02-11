package test.task.monobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MonobankApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MonobankApplication.class, args);
    }

}
