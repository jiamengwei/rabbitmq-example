package provider.example;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import provider.example.entity.User;

@SpringBootTest(classes = ProviderExampleApplication.class)
class ProviderExampleApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("hello.direct","a","hello world");
        rabbitTemplate.convertAndSend("hello.direct","a","hei world");
    }

    @Test
    void sendUserTest(){
        User lucy = new User();
        lucy.setId(1).setName("lucy").setAddress("杭州");
        rabbitTemplate.convertAndSend("hello.direct","a", lucy);
    }
}
