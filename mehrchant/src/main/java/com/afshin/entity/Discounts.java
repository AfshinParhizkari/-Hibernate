package com.afshin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Discounts {
    private Integer discountId;
    private String description;
    private String discountTypeCode;
    private Integer discountAmount;
    private String applyAsPercentageFlag;
    private String easyCode;
    private String addFreeShippingFlag;
    private String onetimeDiscountFlag;

    @Basic
    @Column(name = "DISCOUNT_ID")
    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "DISCOUNT_TYPE_CODE")
    public String getDiscountTypeCode() {
        return discountTypeCode;
    }

    public void setDiscountTypeCode(String discountTypeCode) {
        this.discountTypeCode = discountTypeCode;
    }

    @Basic
    @Column(name = "DISCOUNT_AMOUNT")
    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Basic
    @Column(name = "APPLY_AS_PERCENTAGE_FLAG")
    public String getApplyAsPercentageFlag() {
        return applyAsPercentageFlag;
    }

    public void setApplyAsPercentageFlag(String applyAsPercentageFlag) {
        this.applyAsPercentageFlag = applyAsPercentageFlag;
    }

    @Basic
    @Column(name = "EASY_CODE")
    public String getEasyCode() {
        return easyCode;
    }

    public void setEasyCode(String easyCode) {
        this.easyCode = easyCode;
    }

    @Basic
    @Column(name = "ADD_FREE_SHIPPING_FLAG")
    public String getAddFreeShippingFlag() {
        return addFreeShippingFlag;
    }

    public void setAddFreeShippingFlag(String addFreeShippingFlag) {
        this.addFreeShippingFlag = addFreeShippingFlag;
    }

    @Basic
    @Column(name = "ONETIME_DISCOUNT_FLAG")
    public String getOnetimeDiscountFlag() {
        return onetimeDiscountFlag;
    }

    public void setOnetimeDiscountFlag(String onetimeDiscountFlag) {
        this.onetimeDiscountFlag = onetimeDiscountFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discounts discounts = (Discounts) o;

        if (discountId != null ? !discountId.equals(discounts.discountId) : discounts.discountId != null) return false;
        if (description != null ? !description.equals(discounts.description) : discounts.description != null)
            return false;
        if (discountTypeCode != null ? !discountTypeCode.equals(discounts.discountTypeCode) : discounts.discountTypeCode != null)
            return false;
        if (discountAmount != null ? !discountAmount.equals(discounts.discountAmount) : discounts.discountAmount != null)
            return false;
        if (applyAsPercentageFlag != null ? !applyAsPercentageFlag.equals(discounts.applyAsPercentageFlag) : discounts.applyAsPercentageFlag != null)
            return false;
        if (easyCode != null ? !easyCode.equals(discounts.easyCode) : discounts.easyCode != null) return false;
        if (addFreeShippingFlag != null ? !addFreeShippingFlag.equals(discounts.addFreeShippingFlag) : discounts.addFreeShippingFlag != null)
            return false;
        if (onetimeDiscountFlag != null ? !onetimeDiscountFlag.equals(discounts.onetimeDiscountFlag) : discounts.onetimeDiscountFlag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = discountId != null ? discountId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (discountTypeCode != null ? discountTypeCode.hashCode() : 0);
        result = 31 * result + (discountAmount != null ? discountAmount.hashCode() : 0);
        result = 31 * result + (applyAsPercentageFlag != null ? applyAsPercentageFlag.hashCode() : 0);
        result = 31 * result + (easyCode != null ? easyCode.hashCode() : 0);
        result = 31 * result + (addFreeShippingFlag != null ? addFreeShippingFlag.hashCode() : 0);
        result = 31 * result + (onetimeDiscountFlag != null ? onetimeDiscountFlag.hashCode() : 0);
        return result;
    }
}
