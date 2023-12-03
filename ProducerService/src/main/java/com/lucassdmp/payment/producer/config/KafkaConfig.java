package com.lucassdmp.payment.producer.config;

import com.lucassdmp.payment.constants.PaymentServiceConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic getNewTopic(){
        return TopicBuilder.name(PaymentServiceConstants.TOPIC).build();
    }

}
