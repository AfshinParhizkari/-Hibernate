package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "DISCOUNTS_BASE", schema = "FusionOrderDemo", catalog = "")
public class DiscountsBase {
    private Integer discountId;
    private String discountTypeCode;
    private Integer discountAmount;
    private String applyAsPercentageFlag;
    private String easyCode;
    private String addFreeShippingFlag;
    private String onetimeDiscountFlag;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<CouponUsages> couponUsagesByDiscountId;
    private Collection<DiscountTranslations> discountTranslationsByDiscountId;
    private Collection<EligibleDiscounts> eligibleDiscountsByDiscountId;
    private Collection<Orders> ordersByDiscountId;
    private Collection<Orders> ordersByDiscountId_0;

    @Id
    @Column(name = "DISCOUNT_ID")
    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
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

        DiscountsBase that = (DiscountsBase) o;

        if (discountId != null ? !discountId.equals(that.discountId) : that.discountId != null) return false;
        if (discountTypeCode != null ? !discountTypeCode.equals(that.discountTypeCode) : that.discountTypeCode != null)
            return false;
        if (discountAmount != null ? !discountAmount.equals(that.discountAmount) : that.discountAmount != null)
            return false;
        if (applyAsPercentageFlag != null ? !applyAsPercentageFlag.equals(that.applyAsPercentageFlag) : that.applyAsPercentageFlag != null)
            return false;
        if (easyCode != null ? !easyCode.equals(that.easyCode) : that.easyCode != null) return false;
        if (addFreeShippingFlag != null ? !addFreeShippingFlag.equals(that.addFreeShippingFlag) : that.addFreeShippingFlag != null)
            return false;
        if (onetimeDiscountFlag != null ? !onetimeDiscountFlag.equals(that.onetimeDiscountFlag) : that.onetimeDiscountFlag != null)
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
        int result = discountId != null ? discountId.hashCode() : 0;
        result = 31 * result + (discountTypeCode != null ? discountTypeCode.hashCode() : 0);
        result = 31 * result + (discountAmount != null ? discountAmount.hashCode() : 0);
        result = 31 * result + (applyAsPercentageFlag != null ? applyAsPercentageFlag.hashCode() : 0);
        result = 31 * result + (easyCode != null ? easyCode.hashCode() : 0);
        result = 31 * result + (addFreeShippingFlag != null ? addFreeShippingFlag.hashCode() : 0);
        result = 31 * result + (onetimeDiscountFlag != null ? onetimeDiscountFlag.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "discountsBaseByDiscountId")
    public Collection<CouponUsages> getCouponUsagesByDiscountId() {
        return couponUsagesByDiscountId;
    }

    public void setCouponUsagesByDiscountId(Collection<CouponUsages> couponUsagesByDiscountId) {
        this.couponUsagesByDiscountId = couponUsagesByDiscountId;
    }

    @OneToMany(mappedBy = "discountsBaseByDiscountId")
    public Collection<DiscountTranslations> getDiscountTranslationsByDiscountId() {
        return discountTranslationsByDiscountId;
    }

    public void setDiscountTranslationsByDiscountId(Collection<DiscountTranslations> discountTranslationsByDiscountId) {
        this.discountTranslationsByDiscountId = discountTranslationsByDiscountId;
    }

    @OneToMany(mappedBy = "discountsBaseByDiscountId")
    public Collection<EligibleDiscounts> getEligibleDiscountsByDiscountId() {
        return eligibleDiscountsByDiscountId;
    }

    public void setEligibleDiscountsByDiscountId(Collection<EligibleDiscounts> eligibleDiscountsByDiscountId) {
        this.eligibleDiscountsByDiscountId = eligibleDiscountsByDiscountId;
    }

    @OneToMany(mappedBy = "discountsBaseByDiscountId")
    public Collection<Orders> getOrdersByDiscountId() {
        return ordersByDiscountId;
    }

    public void setOrdersByDiscountId(Collection<Orders> ordersByDiscountId) {
        this.ordersByDiscountId = ordersByDiscountId;
    }

    @OneToMany(mappedBy = "discountsBaseByCouponId")
    public Collection<Orders> getOrdersByDiscountId_0() {
        return ordersByDiscountId_0;
    }

    public void setOrdersByDiscountId_0(Collection<Orders> ordersByDiscountId_0) {
        this.ordersByDiscountId_0 = ordersByDiscountId_0;
    }
}
