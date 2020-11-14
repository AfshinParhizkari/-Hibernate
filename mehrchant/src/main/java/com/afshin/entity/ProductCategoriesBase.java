package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "PRODUCT_CATEGORIES_BASE", schema = "FusionOrderDemo", catalog = "")
public class ProductCategoriesBase {
    private Integer categoryId;
    private Integer parentCategoryId;
    private String categoryLockedFlag;
    private Integer representativeProductId;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<CategoryTranslations> categoryTranslationsByCategoryId;
    private Collection<CustomerInterests> customerInterestsByCategoryId;
    private Collection<ProductsBase> productsBasesByCategoryId;
    private ProductCategoriesBase productCategoriesBaseByParentCategoryId;
    private Collection<ProductCategoriesBase> productCategoriesBasesByCategoryId;
    private ProductsBase productsBaseByRepresentativeProductId;

    @Id
    @Column(name = "CATEGORY_ID")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "PARENT_CATEGORY_ID")
    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    @Basic
    @Column(name = "CATEGORY_LOCKED_FLAG")
    public String getCategoryLockedFlag() {
        return categoryLockedFlag;
    }

    public void setCategoryLockedFlag(String categoryLockedFlag) {
        this.categoryLockedFlag = categoryLockedFlag;
    }

    @Basic
    @Column(name = "REPRESENTATIVE_PRODUCT_ID")
    public Integer getRepresentativeProductId() {
        return representativeProductId;
    }

    public void setRepresentativeProductId(Integer representativeProductId) {
        this.representativeProductId = representativeProductId;
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

        ProductCategoriesBase that = (ProductCategoriesBase) o;

        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (parentCategoryId != null ? !parentCategoryId.equals(that.parentCategoryId) : that.parentCategoryId != null)
            return false;
        if (categoryLockedFlag != null ? !categoryLockedFlag.equals(that.categoryLockedFlag) : that.categoryLockedFlag != null)
            return false;
        if (representativeProductId != null ? !representativeProductId.equals(that.representativeProductId) : that.representativeProductId != null)
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
        int result = categoryId != null ? categoryId.hashCode() : 0;
        result = 31 * result + (parentCategoryId != null ? parentCategoryId.hashCode() : 0);
        result = 31 * result + (categoryLockedFlag != null ? categoryLockedFlag.hashCode() : 0);
        result = 31 * result + (representativeProductId != null ? representativeProductId.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productCategoriesBaseByCategoryId")
    public Collection<CategoryTranslations> getCategoryTranslationsByCategoryId() {
        return categoryTranslationsByCategoryId;
    }

    public void setCategoryTranslationsByCategoryId(Collection<CategoryTranslations> categoryTranslationsByCategoryId) {
        this.categoryTranslationsByCategoryId = categoryTranslationsByCategoryId;
    }

    @OneToMany(mappedBy = "productCategoriesBaseByCategoryId")
    public Collection<CustomerInterests> getCustomerInterestsByCategoryId() {
        return customerInterestsByCategoryId;
    }

    public void setCustomerInterestsByCategoryId(Collection<CustomerInterests> customerInterestsByCategoryId) {
        this.customerInterestsByCategoryId = customerInterestsByCategoryId;
    }

    @OneToMany(mappedBy = "productCategoriesBaseByCategoryId")
    public Collection<ProductsBase> getProductsBasesByCategoryId() {
        return productsBasesByCategoryId;
    }

    public void setProductsBasesByCategoryId(Collection<ProductsBase> productsBasesByCategoryId) {
        this.productsBasesByCategoryId = productsBasesByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "PARENT_CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    public ProductCategoriesBase getProductCategoriesBaseByParentCategoryId() {
        return productCategoriesBaseByParentCategoryId;
    }

    public void setProductCategoriesBaseByParentCategoryId(ProductCategoriesBase productCategoriesBaseByParentCategoryId) {
        this.productCategoriesBaseByParentCategoryId = productCategoriesBaseByParentCategoryId;
    }

    @OneToMany(mappedBy = "productCategoriesBaseByParentCategoryId")
    public Collection<ProductCategoriesBase> getProductCategoriesBasesByCategoryId() {
        return productCategoriesBasesByCategoryId;
    }

    public void setProductCategoriesBasesByCategoryId(Collection<ProductCategoriesBase> productCategoriesBasesByCategoryId) {
        this.productCategoriesBasesByCategoryId = productCategoriesBasesByCategoryId;
    }

    @ManyToOne
    @JoinColumn(name = "REPRESENTATIVE_PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    public ProductsBase getProductsBaseByRepresentativeProductId() {
        return productsBaseByRepresentativeProductId;
    }

    public void setProductsBaseByRepresentativeProductId(ProductsBase productsBaseByRepresentativeProductId) {
        this.productsBaseByRepresentativeProductId = productsBaseByRepresentativeProductId;
    }
}
