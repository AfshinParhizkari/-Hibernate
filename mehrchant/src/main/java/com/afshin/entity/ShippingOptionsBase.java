package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "SHIPPING_OPTIONS_BASE", schema = "FusionOrderDemo", catalog = "")
public class ShippingOptionsBase {
    private Integer shippingOptionId;
    private String countryCode;
    private Double costPerClass1Item;
    private Double costPerClass2Item;
    private Double costPerClass3Item;
    private String freeShippingAllowedFlag;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<Orders> ordersByShippingOptionId;
    private Collection<ShippingOptionTranslations> shippingOptionTranslationsByShippingOptionId;

    @Id
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

    @Basic
    @Column(name = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "CREATION_DATE")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "LAST_UPDATED_BY")
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Basic
    @Column(name = "LAST_UPDATE_DATE")
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "OBJECT_VERSION_ID")
    public Integer getObjectVersionId() {
        return objectVersionId;
    }

    public void setObjectVersionId(Integer objectVersionId) {
        this.objectVersionId = objectVersionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShippingOptionsBase that = (ShippingOptionsBase) o;

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
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(that.lastUpdatedBy) : that.lastUpdatedBy != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(that.lastUpdateDate) : that.lastUpdateDate != null)
            return false;
        if (objectVersionId != null ? !objectVersionId.equals(that.objectVersionId) : that.objectVersionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shippingOptionId != null ? shippingOptionId.hashCode() : 0;
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (costPerClass1Item != null ? costPerClass1Item.hashCode() : 0);
        result = 31 * result + (costPerClass2Item != null ? costPerClass2Item.hashCode() : 0);
        result = 31 * result + (costPerClass3Item != null ? costPerClass3Item.hashCode() : 0);
        result = 31 * result + (freeShippingAllowedFlag != null ? freeShippingAllowedFlag.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "shippingOptionsBaseByShippingOptionId")
    public Collection<Orders> getOrdersByShippingOptionId() {
        return ordersByShippingOptionId;
    }

    public void setOrdersByShippingOptionId(Collection<Orders> ordersByShippingOptionId) {
        this.ordersByShippingOptionId = ordersByShippingOptionId;
    }

    @OneToMany(mappedBy = "shippingOptionsBaseByShippingOptionId")
    public Collection<ShippingOptionTranslations> getShippingOptionTranslationsByShippingOptionId() {
        return shippingOptionTranslationsByShippingOptionId;
    }

    public void setShippingOptionTranslationsByShippingOptionId(Collection<ShippingOptionTranslations> shippingOptionTranslationsByShippingOptionId) {
        this.shippingOptionTranslationsByShippingOptionId = shippingOptionTranslationsByShippingOptionId;
    }
}
