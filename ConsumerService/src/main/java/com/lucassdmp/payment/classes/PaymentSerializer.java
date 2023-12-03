package com.lucassdmp.payment.classes;

import org.apache.kafka.common.serialization.Serializer;

public class PaymentSerializer implements Serializer<Payment>{
    @Override
    public byte[] serialize(String topic, Payment data) {
        try{
            return data.getSerializedReady().getBytes();
        }catch (Exception e){
            return "Failed".getBytes();
        }
    }
}
