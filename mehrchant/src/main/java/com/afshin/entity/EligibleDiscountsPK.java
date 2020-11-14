package com.afshin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EligibleDiscountsPK implements Serializable {
    private Integer membershipId;
    private Integer discountId;

    @Column(name = "MEMBERSHIP_ID")
    @Id
    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
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

        EligibleDiscountsPK that = (EligibleDiscountsPK) o;

        if (membershipId != null ? !membershipId.equals(that.membershipId) : that.membershipId != null) return false;
        if (discountId != null ? !discountId.equals(that.discountId) : that.discountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = membershipId != null ? membershipId.hashCode() : 0;
        result = 31 * result + (discountId != null ? discountId.hashCode() : 0);
        return result;
    }
}
