package com.afshin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CouponUsagesPK implements Serializable {
    private Integer customerId;
    private Integer discountId;

    @Column(name = "CUSTOMER_ID")
    @Id
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "DISCOUNT_ID")
    @Id
    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CouponUsagesPK that = (CouponUsagesPK) o;

        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (discountId != null ? !discountId.equals(that.discountId) : that.discountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (discountId != null ? discountId.hashCode() : 0);
        return result;
    }
}
