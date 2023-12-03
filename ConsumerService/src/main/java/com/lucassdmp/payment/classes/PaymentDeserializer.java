package com.lucassdmp.payment.classes;

import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentDeserializer implements Deserializer<Payment>{
    @Override
    public Payment deserialize(String topic, byte[] bytes) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            String string = mapper.readValue(bytes, String.class);
            String[] data = string.split(",");
            return new Payment(Double.parseDouble(data[2]), data[0], data[1]);
        }catch (Exception e){
            return null;
        }
    }
}
