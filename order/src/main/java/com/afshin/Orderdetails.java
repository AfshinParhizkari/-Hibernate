package com.afshin;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderdetailsPK.class)
public class Orderdetails {
    public Orderdetails() {
    }

    @Id
    @Column(name = "orderNumber")
    private Integer orderNumber;

    @Id
    @Column(name = "productCode")
    private String productCode;

    @Column(name = "quantityOrdered")
    private Integer quantityOrdered;

    @Column(name = "priceEach")
    private BigDecimal priceEach;

    @Column(name = "orderLineNumber")
    private Integer orderLineNumber;

    @ManyToOne()
    @JoinColumn(name = "orderNumber",insertable = false,updatable = false)
    private Order order;

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

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Orderdetails{" +
                "orderNumber=" + orderNumber +
                ", productCode='" + productCode + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                //", order=" + order +
                '}';
    }
}

