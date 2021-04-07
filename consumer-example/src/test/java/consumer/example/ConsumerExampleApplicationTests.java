package consumer.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ConsumerExampleApplication.class)
class ConsumerExampleApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

}
