package com.afshin;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderdetailsPK that = (OrderdetailsPK) o;
        return Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode);
    }
}
