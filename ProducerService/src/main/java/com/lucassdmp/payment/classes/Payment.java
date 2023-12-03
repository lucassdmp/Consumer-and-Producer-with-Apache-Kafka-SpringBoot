package com.lucassdmp.payment.classes;

public class Payment {
    private double value;
    private String name;
    private String cpf;

    public Payment(double value, String name, String cpf) {
        this.value = value;
        this.name = name;
        this.cpf = cpf;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSerializedReady() {
        return this.name + "," + this.cpf + "," + this.value;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
