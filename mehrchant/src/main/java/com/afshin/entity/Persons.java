package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Persons {
    private Integer personId;
    private String principalName;
    private String title;
    private String firstName;
    private String lastName;
    private String personTypeCode;
    private Integer supplierId;
    private String provisionedFlag;
    private Integer primaryAddressId;
    private Date registeredDate;
    private Integer membershipId;
    private String email;
    private String confirmedEmail;
    private String phoneInt;
    private String mobilePhoneInt;
    private Double creditLimit;
    private Date dateOfBirth;
    private String maritalStatusCode;
    private String gender;
    private Integer childrenUnder18;
    private Integer approximateIncome;
    private String contactMethodCode;
    private String contactableFlag;
    private String contactByAffilliatesFlag;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<AddressUsages> addressUsagesByPersonId;
    private Collection<CouponUsages> couponUsagesByPersonId;
    private CustomerIdentifications customerIdentificationsByPersonId;
    private Collection<CustomerIdentifications> customerIdentificationsByPersonId_0;
    private Collection<CustomerInterests> customerInterestsByPersonId;
    private Collection<Orders> ordersByPersonId;
    private Collection<PaymentOptions> paymentOptionsByPersonId;
    private Suppliers suppliersBySupplierId;
    private Addresses addressesByPrimaryAddressId;
    private MembershipsBase membershipsBaseByMembershipId;

    @Id
    @Column(name = "PERSON_ID")
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "PRINCIPAL_NAME")
    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "PERSON_TYPE_CODE")
    public String getPersonTypeCode() {
        return personTypeCode;
    }

    public void setPersonTypeCode(String personTypeCode) {
        this.personTypeCode = personTypeCode;
    }

    @Basic
    @Column(name = "SUPPLIER_ID")
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "PROVISIONED_FLAG")
    public String getProvisionedFlag() {
        return provisionedFlag;
    }

    public void setProvisionedFlag(String provisionedFlag) {
        this.provisionedFlag = provisionedFlag;
    }

    @Basic
    @Column(name = "PRIMARY_ADDRESS_ID")
    public Integer getPrimaryAddressId() {
        return primaryAddressId;
    }

    public void setPrimaryAddressId(Integer primaryAddressId) {
        this.primaryAddressId = primaryAddressId;
    }

    @Basic
    @Column(name = "REGISTERED_DATE")
    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
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
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "CONFIRMED_EMAIL")
    public String getConfirmedEmail() {
        return confirmedEmail;
    }

    public void setConfirmedEmail(String confirmedEmail) {
        this.confirmedEmail = confirmedEmail;
    }

    @Basic
    @Column(name = "PHONE_INT")
    public String getPhoneInt() {
        return phoneInt;
    }

    public void setPhoneInt(String phoneInt) {
        this.phoneInt = phoneInt;
    }

    @Basic
    @Column(name = "MOBILE_PHONE_INT")
    public String getMobilePhoneInt() {
        return mobilePhoneInt;
    }

    public void setMobilePhoneInt(String mobilePhoneInt) {
        this.mobilePhoneInt = mobilePhoneInt;
    }

    @Basic
    @Column(name = "CREDIT_LIMIT")
    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Basic
    @Column(name = "DATE_OF_BIRTH")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "MARITAL_STATUS_CODE")
    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    @Basic
    @Column(name = "GENDER")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "CHILDREN_UNDER_18")
    public Integer getChildrenUnder18() {
        return childrenUnder18;
    }

    public void setChildrenUnder18(Integer childrenUnder18) {
        this.childrenUnder18 = childrenUnder18;
    }

    @Basic
    @Column(name = "APPROXIMATE_INCOME")
    public Integer getApproximateIncome() {
        return approximateIncome;
    }

    public void setApproximateIncome(Integer approximateIncome) {
        this.approximateIncome = approximateIncome;
    }

    @Basic
    @Column(name = "CONTACT_METHOD_CODE")
    public String getContactMethodCode() {
        return contactMethodCode;
    }

    public void setContactMethodCode(String contactMethodCode) {
        this.contactMethodCode = contactMethodCode;
    }

    @Basic
    @Column(name = "CONTACTABLE_FLAG")
    public String getContactableFlag() {
        return contactableFlag;
    }

    public void setContactableFlag(String contactableFlag) {
        this.contactableFlag = contactableFlag;
    }

    @Basic
    @Column(name = "CONTACT_BY_AFFILLIATES_FLAG")
    public String getContactByAffilliatesFlag() {
        return contactByAffilliatesFlag;
    }

    public void setContactByAffilliatesFlag(String contactByAffilliatesFlag) {
        this.contactByAffilliatesFlag = contactByAffilliatesFlag;
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

        Persons persons = (Persons) o;

        if (personId != null ? !personId.equals(persons.personId) : persons.personId != null) return false;
        if (principalName != null ? !principalName.equals(persons.principalName) : persons.principalName != null)
            return false;
        if (title != null ? !title.equals(persons.title) : persons.title != null) return false;
        if (firstName != null ? !firstName.equals(persons.firstName) : persons.firstName != null) return false;
        if (lastName != null ? !lastName.equals(persons.lastName) : persons.lastName != null) return false;
        if (personTypeCode != null ? !personTypeCode.equals(persons.personTypeCode) : persons.personTypeCode != null)
            return false;
        if (supplierId != null ? !supplierId.equals(persons.supplierId) : persons.supplierId != null) return false;
        if (provisionedFlag != null ? !provisionedFlag.equals(persons.provisionedFlag) : persons.provisionedFlag != null)
            return false;
        if (primaryAddressId != null ? !primaryAddressId.equals(persons.primaryAddressId) : persons.primaryAddressId != null)
            return false;
        if (registeredDate != null ? !registeredDate.equals(persons.registeredDate) : persons.registeredDate != null)
            return false;
        if (membershipId != null ? !membershipId.equals(persons.membershipId) : persons.membershipId != null)
            return false;
        if (email != null ? !email.equals(persons.email) : persons.email != null) return false;
        if (confirmedEmail != null ? !confirmedEmail.equals(persons.confirmedEmail) : persons.confirmedEmail != null)
            return false;
        if (phoneInt != null ? !phoneInt.equals(persons.phoneInt) : persons.phoneInt != null) return false;
        if (mobilePhoneInt != null ? !mobilePhoneInt.equals(persons.mobilePhoneInt) : persons.mobilePhoneInt != null)
            return false;
        if (creditLimit != null ? !creditLimit.equals(persons.creditLimit) : persons.creditLimit != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(persons.dateOfBirth) : persons.dateOfBirth != null) return false;
        if (maritalStatusCode != null ? !maritalStatusCode.equals(persons.maritalStatusCode) : persons.maritalStatusCode != null)
            return false;
        if (gender != null ? !gender.equals(persons.gender) : persons.gender != null) return false;
        if (childrenUnder18 != null ? !childrenUnder18.equals(persons.childrenUnder18) : persons.childrenUnder18 != null)
            return false;
        if (approximateIncome != null ? !approximateIncome.equals(persons.approximateIncome) : persons.approximateIncome != null)
            return false;
        if (contactMethodCode != null ? !contactMethodCode.equals(persons.contactMethodCode) : persons.contactMethodCode != null)
            return false;
        if (contactableFlag != null ? !contactableFlag.equals(persons.contactableFlag) : persons.contactableFlag != null)
            return false;
        if (contactByAffilliatesFlag != null ? !contactByAffilliatesFlag.equals(persons.contactByAffilliatesFlag) : persons.contactByAffilliatesFlag != null)
            return false;
        if (createdBy != null ? !createdBy.equals(persons.createdBy) : persons.createdBy != null) return false;
        if (creationDate != null ? !creationDate.equals(persons.creationDate) : persons.creationDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(persons.lastUpdatedBy) : persons.lastUpdatedBy != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(persons.lastUpdateDate) : persons.lastUpdateDate != null)
            return false;
        if (objectVersionId != null ? !objectVersionId.equals(persons.objectVersionId) : persons.objectVersionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (principalName != null ? principalName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (personTypeCode != null ? personTypeCode.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (provisionedFlag != null ? provisionedFlag.hashCode() : 0);
        result = 31 * result + (primaryAddressId != null ? primaryAddressId.hashCode() : 0);
        result = 31 * result + (registeredDate != null ? registeredDate.hashCode() : 0);
        result = 31 * result + (membershipId != null ? membershipId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (confirmedEmail != null ? confirmedEmail.hashCode() : 0);
        result = 31 * result + (phoneInt != null ? phoneInt.hashCode() : 0);
        result = 31 * result + (mobilePhoneInt != null ? mobilePhoneInt.hashCode() : 0);
        result = 31 * result + (creditLimit != null ? creditLimit.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (maritalStatusCode != null ? maritalStatusCode.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (childrenUnder18 != null ? childrenUnder18.hashCode() : 0);
        result = 31 * result + (approximateIncome != null ? approximateIncome.hashCode() : 0);
        result = 31 * result + (contactMethodCode != null ? contactMethodCode.hashCode() : 0);
        result = 31 * result + (contactableFlag != null ? contactableFlag.hashCode() : 0);
        result = 31 * result + (contactByAffilliatesFlag != null ? contactByAffilliatesFlag.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personsByAssociatedOwnerId")
    public Collection<AddressUsages> getAddressUsagesByPersonId() {
        return addressUsagesByPersonId;
    }

    public void setAddressUsagesByPersonId(Collection<AddressUsages> addressUsagesByPersonId) {
        this.addressUsagesByPersonId = addressUsagesByPersonId;
    }

    @OneToMany(mappedBy = "personsByCustomerId")
    public Collection<CouponUsages> getCouponUsagesByPersonId() {
        return couponUsagesByPersonId;
    }

    public void setCouponUsagesByPersonId(Collection<CouponUsages> couponUsagesByPersonId) {
        this.couponUsagesByPersonId = couponUsagesByPersonId;
    }

    @OneToOne(mappedBy = "personsByCustomerId")
    public CustomerIdentifications getCustomerIdentificationsByPersonId() {
        return customerIdentificationsByPersonId;
    }

    public void setCustomerIdentificationsByPersonId(CustomerIdentifications customerIdentificationsByPersonId) {
        this.customerIdentificationsByPersonId = customerIdentificationsByPersonId;
    }

    @OneToMany(mappedBy = "personsByVerifiedBy")
    public Collection<CustomerIdentifications> getCustomerIdentificationsByPersonId_0() {
        return customerIdentificationsByPersonId_0;
    }

    public void setCustomerIdentificationsByPersonId_0(Collection<CustomerIdentifications> customerIdentificationsByPersonId_0) {
        this.customerIdentificationsByPersonId_0 = customerIdentificationsByPersonId_0;
    }

    @OneToMany(mappedBy = "personsByCustomerId")
    public Collection<CustomerInterests> getCustomerInterestsByPersonId() {
        return customerInterestsByPersonId;
    }

    public void setCustomerInterestsByPersonId(Collection<CustomerInterests> customerInterestsByPersonId) {
        this.customerInterestsByPersonId = customerInterestsByPersonId;
    }

    @OneToMany(mappedBy = "personsByCustomerId")
    public Collection<Orders> getOrdersByPersonId() {
        return ordersByPersonId;
    }

    public void setOrdersByPersonId(Collection<Orders> ordersByPersonId) {
        this.ordersByPersonId = ordersByPersonId;
    }

    @OneToMany(mappedBy = "personsByCustomerId")
    public Collection<PaymentOptions> getPaymentOptionsByPersonId() {
        return paymentOptionsByPersonId;
    }

    public void setPaymentOptionsByPersonId(Collection<PaymentOptions> paymentOptionsByPersonId) {
        this.paymentOptionsByPersonId = paymentOptionsByPersonId;
    }

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "SUPPLIER_ID")
    public Suppliers getSuppliersBySupplierId() {
        return suppliersBySupplierId;
    }

    public void setSuppliersBySupplierId(Suppliers suppliersBySupplierId) {
        this.suppliersBySupplierId = suppliersBySupplierId;
    }

    @ManyToOne
    @JoinColumn(name = "PRIMARY_ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    public Addresses getAddressesByPrimaryAddressId() {
        return addressesByPrimaryAddressId;
    }

    public void setAddressesByPrimaryAddressId(Addresses addressesByPrimaryAddressId) {
        this.addressesByPrimaryAddressId = addressesByPrimaryAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "MEMBERSHIP_ID", referencedColumnName = "MEMBERSHIP_ID")
    public MembershipsBase getMembershipsBaseByMembershipId() {
        return membershipsBaseByMembershipId;
    }

    public void setMembershipsBaseByMembershipId(MembershipsBase membershipsBaseByMembershipId) {
        this.membershipsBaseByMembershipId = membershipsBaseByMembershipId;
    }
}
