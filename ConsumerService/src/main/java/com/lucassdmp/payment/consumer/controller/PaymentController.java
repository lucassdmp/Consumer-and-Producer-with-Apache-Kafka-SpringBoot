package com.lucassdmp.payment.consumer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucassdmp.payment.consumer.service.KafkaConsumer;
import com.lucassdmp.payment.constants.PaymentServiceConstants;

@CrossOrigin
@RestController
@RequestMapping(PaymentServiceConstants.GET_STRING)
public class PaymentController {

    private final KafkaConsumer kafkaConsumer;

    public PaymentController(KafkaConsumer kafkaConsumer) {
        this.kafkaConsumer = kafkaConsumer;
    }

    @GetMapping(PaymentServiceConstants.GET_PAYMENT)
    public Double getPayment() {
        Double payment = kafkaConsumer.getPayment();
        System.out.println("Returning payment: " + payment);
        return payment;
    }

    @GetMapping("/payments")
    public String totalPayments() {
        String total = kafkaConsumer.getPayments();
        System.out.println("Returning total payments: " + total);
        return total;
    }

    @GetMapping("/total")
    public Double total() {
        Double total = kafkaConsumer.totalPayments();
        System.out.println("Returning total payments: " + total);
        return total;
    }
}
