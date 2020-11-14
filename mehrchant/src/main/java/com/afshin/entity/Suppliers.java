package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Suppliers {
    private Integer supplierId;
    private String supplierName;
    private String supplierStatus;
    private String phoneNumber;
    private String email;
    private String uiSkin;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<Persons> personsBySupplierId;
    private Collection<ProductsBase> productsBasesBySupplierId;

    @Id
    @Column(name = "SUPPLIER_ID")
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "SUPPLIER_NAME")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "SUPPLIER_STATUS")
    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    @Basic
    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    @Column(name = "UI_SKIN")
    public String getUiSkin() {
        return uiSkin;
    }

    public void setUiSkin(String uiSkin) {
        this.uiSkin = uiSkin;
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

        Suppliers suppliers = (Suppliers) o;

        if (supplierId != null ? !supplierId.equals(suppliers.supplierId) : suppliers.supplierId != null) return false;
        if (supplierName != null ? !supplierName.equals(suppliers.supplierName) : suppliers.supplierName != null)
            return false;
        if (supplierStatus != null ? !supplierStatus.equals(suppliers.supplierStatus) : suppliers.supplierStatus != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(suppliers.phoneNumber) : suppliers.phoneNumber != null)
            return false;
        if (email != null ? !email.equals(suppliers.email) : suppliers.email != null) return false;
        if (uiSkin != null ? !uiSkin.equals(suppliers.uiSkin) : suppliers.uiSkin != null) return false;
        if (createdBy != null ? !createdBy.equals(suppliers.createdBy) : suppliers.createdBy != null) return false;
        if (creationDate != null ? !creationDate.equals(suppliers.creationDate) : suppliers.creationDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(suppliers.lastUpdatedBy) : suppliers.lastUpdatedBy != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(suppliers.lastUpdateDate) : suppliers.lastUpdateDate != null)
            return false;
        if (objectVersionId != null ? !objectVersionId.equals(suppliers.objectVersionId) : suppliers.objectVersionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = supplierId != null ? supplierId.hashCode() : 0;
        result = 31 * result + (supplierName != null ? supplierName.hashCode() : 0);
        result = 31 * result + (supplierStatus != null ? supplierStatus.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (uiSkin != null ? uiSkin.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "suppliersBySupplierId")
    public Collection<Persons> getPersonsBySupplierId() {
        return personsBySupplierId;
    }

    public void setPersonsBySupplierId(Collection<Persons> personsBySupplierId) {
        this.personsBySupplierId = personsBySupplierId;
    }

    @OneToMany(mappedBy = "suppliersBySupplierId")
    public Collection<ProductsBase> getProductsBasesBySupplierId() {
        return productsBasesBySupplierId;
    }

    public void setProductsBasesBySupplierId(Collection<ProductsBase> productsBasesBySupplierId) {
        this.productsBasesBySupplierId = productsBasesBySupplierId;
    }
}
