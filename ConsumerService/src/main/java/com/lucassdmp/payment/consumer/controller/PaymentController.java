package com.lucassdmp.payment.consumer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucassdmp.payment.consumer.service.KafkaConsumer;
import com.lucassdmp.payment.constants.PaymentServiceConstants;


@CrossOrigin
@RestController
@RequestMapping(PaymentServiceConstants.GET_PAYMENT)
public class PaymentController{

    private final KafkaConsumer kafkaconsumer;

    public PaymentController(KafkaConsumer kafkaconsumer){
        this.kafkaconsumer = kafkaconsumer;
    }

    @GetMapping
    public Double getPayment(){
        return kafkaconsumer.getPayment();
    }
}
