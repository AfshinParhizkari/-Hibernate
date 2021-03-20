package com.afshin.Entity;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orderdetails")
@JsonFilter("OrderdetailFilter")
@IdClass(OrderdetailPK.class)
@XmlRootElement(name = "OrderdetailXML")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orderdetail {
    public Orderdetail() {}

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

    @ManyToOne
    @JoinColumn(name = "orderNumber",referencedColumnName = "orderNumber",insertable = false,updatable = false)
    @XmlTransient
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productCode",referencedColumnName = "productCode",insertable = false,updatable = false)
    @XmlTransient
    private Product product;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Orderdetails{" +
                "orderNumber=" + orderNumber +
                ", productCode=" + productCode +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }
    @Transient
    public Set<String> getfilters(){
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("orderNumber");hash_Set.add("productCode");hash_Set.add("quantityOrdered");
        hash_Set.add("priceEach");hash_Set.add("orderLineNumber");
        return hash_Set;
    }
}
