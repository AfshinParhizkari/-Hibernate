package com.afshin;

import java.io.Serializable;

public class OrderdetailsPK implements Serializable {

    public OrderdetailsPK() {
    }

    public OrderdetailsPK(Integer orderNumber, Integer productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    private Integer orderNumber;
    private Integer productCode;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

}
