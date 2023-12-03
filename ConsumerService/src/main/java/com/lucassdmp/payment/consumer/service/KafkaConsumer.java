package com.lucassdmp.payment.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lucassdmp.payment.classes.Payment;
import com.lucassdmp.payment.constants.PaymentServiceConstants;

@Service
public class KafkaConsumer {
    private Payment payment;

    @KafkaListener(topics = PaymentServiceConstants.TOPIC)
    public void consume(Payment payment){
        System.out.println("Consumed payment: " + payment);
        this.payment = payment;
    }

    public Payment getPayment(){
        return payment;
    }
}
