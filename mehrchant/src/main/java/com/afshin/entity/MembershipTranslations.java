package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MEMBERSHIP_TRANSLATIONS", schema = "FusionOrderDemo", catalog = "")
public class MembershipTranslations {
    private Integer membershipTranslationsId;
    private Integer membershipId;
    private String membershipName;
    private String description;
    private String language;
    private String sourceLanguage;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private MembershipsBase membershipsBaseByMembershipId;

    @Id
    @Column(name = "MEMBERSHIP_TRANSLATIONS_ID")
    public Integer getMembershipTranslationsId() {
        return membershipTranslationsId;
    }

    public void setMembershipTranslationsId(Integer membershipTranslationsId) {
        this.membershipTranslationsId = membershipTranslationsId;
    }

    @Basic
    @Column(name = "MEMBERSHIP_ID")
    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
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
    @Column(name = "LANGUAGE")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "SOURCE_LANGUAGE")
    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
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

        MembershipTranslations that = (MembershipTranslations) o;

        if (membershipTranslationsId != null ? !membershipTranslationsId.equals(that.membershipTranslationsId) : that.membershipTranslationsId != null)
            return false;
        if (membershipId != null ? !membershipId.equals(that.membershipId) : that.membershipId != null) return false;
        if (membershipName != null ? !membershipName.equals(that.membershipName) : that.membershipName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (sourceLanguage != null ? !sourceLanguage.equals(that.sourceLanguage) : that.sourceLanguage != null)
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
        int result = membershipTranslationsId != null ? membershipTranslationsId.hashCode() : 0;
        result = 31 * result + (membershipId != null ? membershipId.hashCode() : 0);
        result = 31 * result + (membershipName != null ? membershipName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (sourceLanguage != null ? sourceLanguage.hashCode() : 0);
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
}
