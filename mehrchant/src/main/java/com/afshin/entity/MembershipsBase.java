package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "MEMBERSHIPS_BASE", schema = "FusionOrderDemo", catalog = "")
public class MembershipsBase {
    private Integer membershipId;
    private String membershipTypeCode;
    private Integer contactId;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<EligibleDiscounts> eligibleDiscountsByMembershipId;
    private Collection<MembershipTranslations> membershipTranslationsByMembershipId;
    private Collection<Persons> personsByMembershipId;

    @Id
    @Column(name = "MEMBERSHIP_ID")
    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    @Basic
    @Column(name = "MEMBERSHIP_TYPE_CODE")
    public String getMembershipTypeCode() {
        return membershipTypeCode;
    }

    public void setMembershipTypeCode(String membershipTypeCode) {
        this.membershipTypeCode = membershipTypeCode;
    }

    @Basic
    @Column(name = "CONTACT_ID")
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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

        MembershipsBase that = (MembershipsBase) o;

        if (membershipId != null ? !membershipId.equals(that.membershipId) : that.membershipId != null) return false;
        if (membershipTypeCode != null ? !membershipTypeCode.equals(that.membershipTypeCode) : that.membershipTypeCode != null)
            return false;
        if (contactId != null ? !contactId.equals(that.contactId) : that.contactId != null) return false;
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
        result = 31 * result + (membershipTypeCode != null ? membershipTypeCode.hashCode() : 0);
        result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "membershipsBaseByMembershipId")
    public Collection<EligibleDiscounts> getEligibleDiscountsByMembershipId() {
        return eligibleDiscountsByMembershipId;
    }

    public void setEligibleDiscountsByMembershipId(Collection<EligibleDiscounts> eligibleDiscountsByMembershipId) {
        this.eligibleDiscountsByMembershipId = eligibleDiscountsByMembershipId;
    }

    @OneToMany(mappedBy = "membershipsBaseByMembershipId")
    public Collection<MembershipTranslations> getMembershipTranslationsByMembershipId() {
        return membershipTranslationsByMembershipId;
    }

    public void setMembershipTranslationsByMembershipId(Collection<MembershipTranslations> membershipTranslationsByMembershipId) {
        this.membershipTranslationsByMembershipId = membershipTranslationsByMembershipId;
    }

    @OneToMany(mappedBy = "membershipsBaseByMembershipId")
    public Collection<Persons> getPersonsByMembershipId() {
        return personsByMembershipId;
    }

    public void setPersonsByMembershipId(Collection<Persons> personsByMembershipId) {
        this.personsByMembershipId = personsByMembershipId;
    }
}
