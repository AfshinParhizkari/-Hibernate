package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "PAYMENT_OPTIONS", schema = "FusionOrderDemo", catalog = "")
public class PaymentOptions {
    private Integer paymentOptionId;
    private Integer customerId;
    private String paymentTypeCode;
    private Integer billingAddressId;
    private Integer accountNumber;
    private String cardTypeCode;
    private Date expireDate;
    private Integer checkDigits;
    private String routingIdentifier;
    private String institutionName;
    private Date validFromDate;
    private Date validToDate;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<Orders> ordersByPaymentOptionId;
    private Persons personsByCustomerId;

    @Id
    @Column(name = "PAYMENT_OPTION_ID")
    public Integer getPaymentOptionId() {
        return paymentOptionId;
    }

    public void setPaymentOptionId(Integer paymentOptionId) {
        this.paymentOptionId = paymentOptionId;
    }

    @Basic
    @Column(name = "CUSTOMER_ID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "PAYMENT_TYPE_CODE")
    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    @Basic
    @Column(name = "BILLING_ADDRESS_ID")
    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Basic
    @Column(name = "ACCOUNT_NUMBER")
    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "CARD_TYPE_CODE")
    public String getCardTypeCode() {
        return cardTypeCode;
    }

    public void setCardTypeCode(String cardTypeCode) {
        this.cardTypeCode = cardTypeCode;
    }

    @Basic
    @Column(name = "EXPIRE_DATE")
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Basic
    @Column(name = "CHECK_DIGITS")
    public Integer getCheckDigits() {
        return checkDigits;
    }

    public void setCheckDigits(Integer checkDigits) {
        this.checkDigits = checkDigits;
    }

    @Basic
    @Column(name = "ROUTING_IDENTIFIER")
    public String getRoutingIdentifier() {
        return routingIdentifier;
    }

    public void setRoutingIdentifier(String routingIdentifier) {
        this.routingIdentifier = routingIdentifier;
    }

    @Basic
    @Column(name = "INSTITUTION_NAME")
    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
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

        PaymentOptions that = (PaymentOptions) o;

        if (paymentOptionId != null ? !paymentOptionId.equals(that.paymentOptionId) : that.paymentOptionId != null)
            return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (paymentTypeCode != null ? !paymentTypeCode.equals(that.paymentTypeCode) : that.paymentTypeCode != null)
            return false;
        if (billingAddressId != null ? !billingAddressId.equals(that.billingAddressId) : that.billingAddressId != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (cardTypeCode != null ? !cardTypeCode.equals(that.cardTypeCode) : that.cardTypeCode != null) return false;
        if (expireDate != null ? !expireDate.equals(that.expireDate) : that.expireDate != null) return false;
        if (checkDigits != null ? !checkDigits.equals(that.checkDigits) : that.checkDigits != null) return false;
        if (routingIdentifier != null ? !routingIdentifier.equals(that.routingIdentifier) : that.routingIdentifier != null)
            return false;
        if (institutionName != null ? !institutionName.equals(that.institutionName) : that.institutionName != null)
            return false;
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
        int result = paymentOptionId != null ? paymentOptionId.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (paymentTypeCode != null ? paymentTypeCode.hashCode() : 0);
        result = 31 * result + (billingAddressId != null ? billingAddressId.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (cardTypeCode != null ? cardTypeCode.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (checkDigits != null ? checkDigits.hashCode() : 0);
        result = 31 * result + (routingIdentifier != null ? routingIdentifier.hashCode() : 0);
        result = 31 * result + (institutionName != null ? institutionName.hashCode() : 0);
        result = 31 * result + (validFromDate != null ? validFromDate.hashCode() : 0);
        result = 31 * result + (validToDate != null ? validToDate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "paymentOptionsByPaymentOptionId")
    public Collection<Orders> getOrdersByPaymentOptionId() {
        return ordersByPaymentOptionId;
    }

    public void setOrdersByPaymentOptionId(Collection<Orders> ordersByPaymentOptionId) {
        this.ordersByPaymentOptionId = ordersByPaymentOptionId;
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "PERSON_ID", nullable = false)
    public Persons getPersonsByCustomerId() {
        return personsByCustomerId;
    }

    public void setPersonsByCustomerId(Persons personsByCustomerId) {
        this.personsByCustomerId = personsByCustomerId;
    }
}
