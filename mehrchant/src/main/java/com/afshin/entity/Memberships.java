package com.afshin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Memberships {
    private Integer membershipId;
    private String membershipTypeCode;
    private String membershipName;
    private String description;
    private Integer contactId;

    @Basic
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
    @Column(name = "MEMBERSHIP_NAME")
    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
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
    @Column(name = "CONTACT_ID")
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Memberships that = (Memberships) o;

        if (membershipId != null ? !membershipId.equals(that.membershipId) : that.membershipId != null) return false;
        if (membershipTypeCode != null ? !membershipTypeCode.equals(that.membershipTypeCode) : that.membershipTypeCode != null)
            return false;
        if (membershipName != null ? !membershipName.equals(that.membershipName) : that.membershipName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (contactId != null ? !contactId.equals(that.contactId) : that.contactId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = membershipId != null ? membershipId.hashCode() : 0;
        result = 31 * result + (membershipTypeCode != null ? membershipTypeCode.hashCode() : 0);
        result = 31 * result + (membershipName != null ? membershipName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
        return result;
    }
}
