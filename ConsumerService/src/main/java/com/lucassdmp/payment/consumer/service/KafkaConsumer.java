package com.lucassdmp.payment.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lucassdmp.payment.constants.PaymentServiceConstants;

@Service
public class KafkaConsumer {

    private String payment;

    @KafkaListener(topics = PaymentServiceConstants.TOPIC, groupId = PaymentServiceConstants.GROUP_ID)
    public void consume(String payment) {
        System.out.println("Consumed payment: " + payment);
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }
}