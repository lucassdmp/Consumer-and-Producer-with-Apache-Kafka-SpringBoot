package com.lucassdmp.payment.producer.service;

import com.lucassdmp.payment.constants.PaymentServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;
import com.lucassdmp.payment.classes.Payment;

@Service
public class PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    public boolean sendPayment(Payment payment){
        this.kafkaTemplate.send(PaymentServiceConstants.TOPIC, payment);
        LOGGER.info("Data send succefully");
        return true;
    }
}
