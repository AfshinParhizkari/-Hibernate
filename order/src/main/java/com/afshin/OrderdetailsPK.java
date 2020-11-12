package com.afshin;

import java.io.Serializable;

public class OrderdetailsPK implements Serializable {
    public OrderdetailsPK() {
    }

    public OrderdetailsPK(Integer orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    private Integer orderNumber;
    private String productCode;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
