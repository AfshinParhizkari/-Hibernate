package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "CUSTOMER_IDENTIFICATIONS", schema = "FusionOrderDemo", catalog = "")
public class CustomerIdentifications {
    private Integer customerId;
    private String idTypeCode;
    private String idDetail;
    private String additionalInformation;
    private String verifiedFlag;
    private Date verifiedDate;
    private Integer verifiedBy;
    private String verificationMethodCode;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Persons personsByCustomerId;
    private Persons personsByVerifiedBy;

    @Id
    @Column(name = "CUSTOMER_ID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "ID_TYPE_CODE")
    public String getIdTypeCode() {
        return idTypeCode;
    }

    public void setIdTypeCode(String idTypeCode) {
        this.idTypeCode = idTypeCode;
    }

    @Basic
    @Column(name = "ID_DETAIL")
    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    @Basic
    @Column(name = "ADDITIONAL_INFORMATION")
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Basic
    @Column(name = "VERIFIED_FLAG")
    public String getVerifiedFlag() {
        return verifiedFlag;
    }

    public void setVerifiedFlag(String verifiedFlag) {
        this.verifiedFlag = verifiedFlag;
    }

    @Basic
    @Column(name = "VERIFIED_DATE")
    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    @Basic
    @Column(name = "VERIFIED_BY")
    public Integer getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(Integer verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    @Basic
    @Column(name = "VERIFICATION_METHOD_CODE")
    public String getVerificationMethodCode() {
        return verificationMethodCode;
    }

    public void setVerificationMethodCode(String verificationMethodCode) {
        this.verificationMethodCode = verificationMethodCode;
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

        CustomerIdentifications that = (CustomerIdentifications) o;

        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (idTypeCode != null ? !idTypeCode.equals(that.idTypeCode) : that.idTypeCode != null) return false;
        if (idDetail != null ? !idDetail.equals(that.idDetail) : that.idDetail != null) return false;
        if (additionalInformation != null ? !additionalInformation.equals(that.additionalInformation) : that.additionalInformation != null)
            return false;
        if (verifiedFlag != null ? !verifiedFlag.equals(that.verifiedFlag) : that.verifiedFlag != null) return false;
        if (verifiedDate != null ? !verifiedDate.equals(that.verifiedDate) : that.verifiedDate != null) return false;
        if (verifiedBy != null ? !verifiedBy.equals(that.verifiedBy) : that.verifiedBy != null) return false;
        if (verificationMethodCode != null ? !verificationMethodCode.equals(that.verificationMethodCode) : that.verificationMethodCode != null)
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
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (idTypeCode != null ? idTypeCode.hashCode() : 0);
        result = 31 * result + (idDetail != null ? idDetail.hashCode() : 0);
        result = 31 * result + (additionalInformation != null ? additionalInformation.hashCode() : 0);
        result = 31 * result + (verifiedFlag != null ? verifiedFlag.hashCode() : 0);
        result = 31 * result + (verifiedDate != null ? verifiedDate.hashCode() : 0);
        result = 31 * result + (verifiedBy != null ? verifiedBy.hashCode() : 0);
        result = 31 * result + (verificationMethodCode != null ? verificationMethodCode.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "PERSON_ID", nullable = false)
    public Persons getPersonsByCustomerId() {
        return personsByCustomerId;
    }

    public void setPersonsByCustomerId(Persons personsByCustomerId) {
        this.personsByCustomerId = personsByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "VERIFIED_BY", referencedColumnName = "PERSON_ID")
    public Persons getPersonsByVerifiedBy() {
        return personsByVerifiedBy;
    }

    public void setPersonsByVerifiedBy(Persons personsByVerifiedBy) {
        this.personsByVerifiedBy = personsByVerifiedBy;
    }
}
