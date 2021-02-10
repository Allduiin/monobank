package test.task.monobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static test.task.monobank.model.Request.Status.PROCESSING;

@SpringBootApplication
public class MonobankApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonobankApplication.class, args);
        System.out.println(PROCESSING.toString());
    }

}
