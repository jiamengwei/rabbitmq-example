package consumer.example;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConsumerExampleApplication {
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(ConsumerExampleApplication.class, args);
    }
}
