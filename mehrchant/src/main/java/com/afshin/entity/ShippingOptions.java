package com.afshin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPPING_OPTIONS", schema = "FusionOrderDemo", catalog = "")
public class ShippingOptions {
    private String shippingMethod;
    private Integer shippingOptionId;
    private String countryCode;
    private Double costPerClass1Item;
    private Double costPerClass2Item;
    private Double costPerClass3Item;
    private String freeShippingAllowedFlag;

    @Basic
    @Column(name = "SHIPPING_METHOD")
    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @Basic
    @Column(name = "SHIPPING_OPTION_ID")
    public Integer getShippingOptionId() {
        return shippingOptionId;
    }

    public void setShippingOptionId(Integer shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    @Basic
    @Column(name = "COUNTRY_CODE")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "COST_PER_CLASS1_ITEM")
    public Double getCostPerClass1Item() {
        return costPerClass1Item;
    }

    public void setCostPerClass1Item(Double costPerClass1Item) {
        this.costPerClass1Item = costPerClass1Item;
    }

    @Basic
    @Column(name = "COST_PER_CLASS2_ITEM")
    public Double getCostPerClass2Item() {
        return costPerClass2Item;
    }

    public void setCostPerClass2Item(Double costPerClass2Item) {
        this.costPerClass2Item = costPerClass2Item;
    }

    @Basic
    @Column(name = "COST_PER_CLASS3_ITEM")
    public Double getCostPerClass3Item() {
        return costPerClass3Item;
    }

    public void setCostPerClass3Item(Double costPerClass3Item) {
        this.costPerClass3Item = costPerClass3Item;
    }

    @Basic
    @Column(name = "FREE_SHIPPING_ALLOWED_FLAG")
    public String getFreeShippingAllowedFlag() {
        return freeShippingAllowedFlag;
    }

    public void setFreeShippingAllowedFlag(String freeShippingAllowedFlag) {
        this.freeShippingAllowedFlag = freeShippingAllowedFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippingOptions that = (ShippingOptions) o;

        if (shippingMethod != null ? !shippingMethod.equals(that.shippingMethod) : that.shippingMethod != null)
            return false;
        if (shippingOptionId != null ? !shippingOptionId.equals(that.shippingOptionId) : that.shippingOptionId != null)
            return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (costPerClass1Item != null ? !costPerClass1Item.equals(that.costPerClass1Item) : that.costPerClass1Item != null)
            return false;
        if (costPerClass2Item != null ? !costPerClass2Item.equals(that.costPerClass2Item) : that.costPerClass2Item != null)
            return false;
        if (costPerClass3Item != null ? !costPerClass3Item.equals(that.costPerClass3Item) : that.costPerClass3Item != null)
            return false;
        if (freeShippingAllowedFlag != null ? !freeShippingAllowedFlag.equals(that.freeShippingAllowedFlag) : that.freeShippingAllowedFlag != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shippingMethod != null ? shippingMethod.hashCode() : 0;
        result = 31 * result + (shippingOptionId != null ? shippingOptionId.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (costPerClass1Item != null ? costPerClass1Item.hashCode() : 0);
        result = 31 * result + (costPerClass2Item != null ? costPerClass2Item.hashCode() : 0);
        result = 31 * result + (costPerClass3Item != null ? costPerClass3Item.hashCode() : 0);
        result = 31 * result + (freeShippingAllowedFlag != null ? freeShippingAllowedFlag.hashCode() : 0);
        return result;
    }
}
