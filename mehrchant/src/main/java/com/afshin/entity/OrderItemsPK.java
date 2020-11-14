package com.afshin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderItemsPK implements Serializable {
    private Integer orderId;
    private Integer lineItemId;

    @Column(name = "ORDER_ID")
    @Id
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Column(name = "LINE_ITEM_ID")
    @Id
    public Integer getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Integer lineItemId) {
        this.lineItemId = lineItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemsPK that = (OrderItemsPK) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (lineItemId != null ? !lineItemId.equals(that.lineItemId) : that.lineItemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (lineItemId != null ? lineItemId.hashCode() : 0);
        return result;
    }
}
