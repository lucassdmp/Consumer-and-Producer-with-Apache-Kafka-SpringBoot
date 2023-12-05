package com.lucassdmp.payment.constants;

public class PaymentServiceConstants {
    public static final String TOPIC = "payments";
    public static final String BOOTSTRAP_SERVER = "localhost:9092";
    public static final String GROUP_ID = "paymentGroup";
    public static final String GROUP_ID2 = "paymentGroup2";
    public static final String CONTAINER_FACTORY = "paymentContainerFactory";

    // Routes
    public static final String GET_STRING = "/get";
    public static final String GET_PAYMENT = "/payment";
    public static final String CONSUMER = "/consumer";

}
