package com.lucassdmp.payment.consumer.service;

import java.util.ArrayList;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lucassdmp.payment.constants.PaymentServiceConstants;

@Service
public class KafkaConsumer {

    private ArrayList<Double> payments = new ArrayList<Double>();

    @KafkaListener(topics = PaymentServiceConstants.TOPIC, groupId = PaymentServiceConstants.GROUP_ID)
    public void consume(Double payment){
        System.out.println("Consumed payment: " + payment);
        this.payments.add(payment);

    }

    @KafkaListener(topics = PaymentServiceConstants.TOPIC, groupId = PaymentServiceConstants.GROUP_ID2)
    public void consume2(Double payment){
        System.out.println("Consumed payment: " + payment);
        this.payments.add(payment);

        String paymentsString = getPayments();

    }

    public Double getPayment() {
        if (this.payments.size() > 0) {
            return this.payments.get(this.payments.size() - 1);
        } else {
            return 0.0;
        }
    }

    public String getPayments() {
        String paymentsString = "";
        for (Double payment : this.payments) {
            paymentsString += payment + ", ";
        }
        return paymentsString;
    }

    public Double totalPayments() {
        Double total = 0.0;
        for (Double payment : this.payments) {
            total += payment;
        }
        return total;
    }


}
