package consumer.example;

import consumer.example.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "QA")
public class QAConsumer {

    @RabbitHandler
    public void receive(String in) {
        System.out.println(" QA [x] Received '" + in + "'");
    }

    @RabbitHandler
    public void receive(User user) {
        System.out.println(" QA [x] Received '" + user + "'");
    }
}
