package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "CUSTOMER_INTERESTS", schema = "FusionOrderDemo", catalog = "")
public class CustomerInterests {
    private Integer customerId;
    private Integer customerInterestsId;
    private Integer categoryId;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Persons personsByCustomerId;
    private ProductCategoriesBase productCategoriesBaseByCategoryId;

    @Basic
    @Column(name = "CUSTOMER_ID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Id
    @Column(name = "CUSTOMER_INTERESTS_ID")
    public Integer getCustomerInterestsId() {
        return customerInterestsId;
    }

    public void setCustomerInterestsId(Integer customerInterestsId) {
        this.customerInterestsId = customerInterestsId;
    }

    @Basic
    @Column(name = "CATEGORY_ID")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

        CustomerInterests that = (CustomerInterests) o;

        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (customerInterestsId != null ? !customerInterestsId.equals(that.customerInterestsId) : that.customerInterestsId != null)
            return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
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
        result = 31 * result + (customerInterestsId != null ? customerInterestsId.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "PERSON_ID", nullable = false)
    public Persons getPersonsByCustomerId() {
        return personsByCustomerId;
    }

    public void setPersonsByCustomerId(Persons personsByCustomerId) {
        this.personsByCustomerId = personsByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false)
    public ProductCategoriesBase getProductCategoriesBaseByCategoryId() {
        return productCategoriesBaseByCategoryId;
    }

    public void setProductCategoriesBaseByCategoryId(ProductCategoriesBase productCategoriesBaseByCategoryId) {
        this.productCategoriesBaseByCategoryId = productCategoriesBaseByCategoryId;
    }
}
