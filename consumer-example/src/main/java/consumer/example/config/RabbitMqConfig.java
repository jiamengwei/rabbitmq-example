package consumer.example.config;

import consumer.example.entity.User;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue queueA(){
        return new Queue("QA");
    }

    @Bean
    public Queue queueB(){
        return new Queue("QB");
    }

//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory factory){
//        RabbitTemplate rabbitTemplate = new RabbitTemplate();
//        rabbitTemplate.setConnectionFactory(factory);
//        //解决: Caused by: org.springframework.amqp.AmqpException: No method found for class [B 异常
//        //消息转换器,消息转化为json, setMessageConverter(MessageConverter ),这个方法就是这次异常的解决方案,创建一个Jackson2JsonMessageConverter对象放进去
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//        return rabbitTemplate;
//    }
//
//    @Bean
//    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(){
//        SimpleRabbitListenerContainerFactory container = new SimpleRabbitListenerContainerFactory();
//        container.setDefaultRequeueRejected(false);
//        Jackson2JsonMessageConverter j2jmc = new Jackson2JsonMessageConverter();
//        container.setMessageConverter(j2jmc);
//        return container;
//    }

    @Bean
    public MessageConverter messageConverter(){
        Jackson2JsonMessageConverter j2jmc = new Jackson2JsonMessageConverter();

        Map<String, Class<?>> classMap = new HashMap<>();
        classMap.put("user", User.class);

        DefaultJackson2JavaTypeMapper jackson2JavaTypeMapper = new DefaultJackson2JavaTypeMapper();
        jackson2JavaTypeMapper.setIdClassMapping(classMap);

        j2jmc.setClassMapper(jackson2JavaTypeMapper);
        return j2jmc;
    }
}
