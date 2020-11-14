package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ADDRESS_USAGES", schema = "FusionOrderDemo", catalog = "")
public class AddressUsages {
    private Integer addressUsagesId;
    private Integer associatedOwnerId;
    private String ownerTypeCode;
    private Integer addressId;
    private String usageTypeCode;
    private String expiredFlag;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Persons personsByAssociatedOwnerId;
    private Addresses addressesByAddressId;

    @Id
    @Column(name = "ADDRESS_USAGES_ID")
    public Integer getAddressUsagesId() {
        return addressUsagesId;
    }

    public void setAddressUsagesId(Integer addressUsagesId) {
        this.addressUsagesId = addressUsagesId;
    }

    @Basic
    @Column(name = "ASSOCIATED_OWNER_ID")
    public Integer getAssociatedOwnerId() {
        return associatedOwnerId;
    }

    public void setAssociatedOwnerId(Integer associatedOwnerId) {
        this.associatedOwnerId = associatedOwnerId;
    }

    @Basic
    @Column(name = "OWNER_TYPE_CODE")
    public String getOwnerTypeCode() {
        return ownerTypeCode;
    }

    public void setOwnerTypeCode(String ownerTypeCode) {
        this.ownerTypeCode = ownerTypeCode;
    }

    @Basic
    @Column(name = "ADDRESS_ID")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "USAGE_TYPE_CODE")
    public String getUsageTypeCode() {
        return usageTypeCode;
    }

    public void setUsageTypeCode(String usageTypeCode) {
        this.usageTypeCode = usageTypeCode;
    }

    @Basic
    @Column(name = "EXPIRED_FLAG")
    public String getExpiredFlag() {
        return expiredFlag;
    }

    public void setExpiredFlag(String expiredFlag) {
        this.expiredFlag = expiredFlag;
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

        AddressUsages that = (AddressUsages) o;

        if (addressUsagesId != null ? !addressUsagesId.equals(that.addressUsagesId) : that.addressUsagesId != null)
            return false;
        if (associatedOwnerId != null ? !associatedOwnerId.equals(that.associatedOwnerId) : that.associatedOwnerId != null)
            return false;
        if (ownerTypeCode != null ? !ownerTypeCode.equals(that.ownerTypeCode) : that.ownerTypeCode != null)
            return false;
        if (addressId != null ? !addressId.equals(that.addressId) : that.addressId != null) return false;
        if (usageTypeCode != null ? !usageTypeCode.equals(that.usageTypeCode) : that.usageTypeCode != null)
            return false;
        if (expiredFlag != null ? !expiredFlag.equals(that.expiredFlag) : that.expiredFlag != null) return false;
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
        int result = addressUsagesId != null ? addressUsagesId.hashCode() : 0;
        result = 31 * result + (associatedOwnerId != null ? associatedOwnerId.hashCode() : 0);
        result = 31 * result + (ownerTypeCode != null ? ownerTypeCode.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (usageTypeCode != null ? usageTypeCode.hashCode() : 0);
        result = 31 * result + (expiredFlag != null ? expiredFlag.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ASSOCIATED_OWNER_ID", referencedColumnName = "PERSON_ID", nullable = false)
    public Persons getPersonsByAssociatedOwnerId() {
        return personsByAssociatedOwnerId;
    }

    public void setPersonsByAssociatedOwnerId(Persons personsByAssociatedOwnerId) {
        this.personsByAssociatedOwnerId = personsByAssociatedOwnerId;
    }

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    public Addresses getAddressesByAddressId() {
        return addressesByAddressId;
    }

    public void setAddressesByAddressId(Addresses addressesByAddressId) {
        this.addressesByAddressId = addressesByAddressId;
    }
}
