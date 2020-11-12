package com.afshin;


import java.io.Serializable;

public class PaymentPK implements Serializable {
    public PaymentPK() {
    }

    public PaymentPK(Integer customerNumber, String checkNumber) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    private Integer customerNumber;
    private String checkNumber;

    @Override
    public String toString() {
        return "PaymentPK{" +
                "customerNumber=" + customerNumber +
                ", checkNumber='" + checkNumber + '\'' +
                '}';
    }

}
