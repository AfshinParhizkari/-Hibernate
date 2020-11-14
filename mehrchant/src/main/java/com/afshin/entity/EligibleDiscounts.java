package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ELIGIBLE_DISCOUNTS", schema = "FusionOrderDemo", catalog = "")
@IdClass(EligibleDiscountsPK.class)
public class EligibleDiscounts {
    private Integer membershipId;
    private Integer discountId;
    private Date validFromDate;
    private Date validToDate;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private MembershipsBase membershipsBaseByMembershipId;
    private DiscountsBase discountsBaseByDiscountId;

    @Id
    @Column(name = "MEMBERSHIP_ID")
    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    @Id
    @Column(name = "DISCOUNT_ID")
    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    @Basic
    @Column(name = "VALID_FROM_DATE")
    public Date getValidFromDate() {
        return validFromDate;
    }

    public void setValidFromDate(Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    @Basic
    @Column(name = "VALID_TO_DATE")
    public Date getValidToDate() {
        return validToDate;
    }

    public void setValidToDate(Date validToDate) {
        this.validToDate = validToDate;
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

        EligibleDiscounts that = (EligibleDiscounts) o;

        if (membershipId != null ? !membershipId.equals(that.membershipId) : that.membershipId != null) return false;
        if (discountId != null ? !discountId.equals(that.discountId) : that.discountId != null) return false;
        if (validFromDate != null ? !validFromDate.equals(that.validFromDate) : that.validFromDate != null)
            return false;
        if (validToDate != null ? !validToDate.equals(that.validToDate) : that.validToDate != null) return false;
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
        int result = membershipId != null ? membershipId.hashCode() : 0;
        result = 31 * result + (discountId != null ? discountId.hashCode() : 0);
        result = 31 * result + (validFromDate != null ? validFromDate.hashCode() : 0);
        result = 31 * result + (validToDate != null ? validToDate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "MEMBERSHIP_ID", referencedColumnName = "MEMBERSHIP_ID", nullable = false)
    public MembershipsBase getMembershipsBaseByMembershipId() {
        return membershipsBaseByMembershipId;
    }

    public void setMembershipsBaseByMembershipId(MembershipsBase membershipsBaseByMembershipId) {
        this.membershipsBaseByMembershipId = membershipsBaseByMembershipId;
    }

    @ManyToOne
    @JoinColumn(name = "DISCOUNT_ID", referencedColumnName = "DISCOUNT_ID", nullable = false)
    public DiscountsBase getDiscountsBaseByDiscountId() {
        return discountsBaseByDiscountId;
    }

    public void setDiscountsBaseByDiscountId(DiscountsBase discountsBaseByDiscountId) {
        this.discountsBaseByDiscountId = discountsBaseByDiscountId;
    }
}
