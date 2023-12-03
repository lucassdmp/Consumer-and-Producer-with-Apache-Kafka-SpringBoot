package com.lucassdmp.payment.producer.controller;

import com.lucassdmp.payment.classes.Payment;
import com.lucassdmp.payment.constants.PaymentServiceConstants;
import com.lucassdmp.payment.producer.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/pay/send")
    public ResponseEntity<String> sendPayment(
            @RequestParam("value") double value,
            @RequestParam("name") String name,
            @RequestParam("cpf") String cpf
    ) {

        Payment payment = new Payment(value, name, cpf);

        paymentService.sendPayment(payment);

        return new ResponseEntity<>("Payment inserted!", HttpStatus.OK);
    }
}
