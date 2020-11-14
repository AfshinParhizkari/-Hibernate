package com.afshin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "PRODUCT_CATEGORIES", schema = "FusionOrderDemo", catalog = "")
public class ProductCategories {
    private String categoryName;
    private String categoryDescription;
    private Integer categoryId;
    private Integer parentCategoryId;
    private String categoryLockedFlag;
    private byte[] image;

    @Basic
    @Column(name = "CATEGORY_NAME")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "CATEGORY_DESCRIPTION")
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
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
    @Column(name = "IMAGE")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategories that = (ProductCategories) o;

        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;
        if (categoryDescription != null ? !categoryDescription.equals(that.categoryDescription) : that.categoryDescription != null)
            return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (parentCategoryId != null ? !parentCategoryId.equals(that.parentCategoryId) : that.parentCategoryId != null)
            return false;
        if (categoryLockedFlag != null ? !categoryLockedFlag.equals(that.categoryLockedFlag) : that.categoryLockedFlag != null)
            return false;
        if (!Arrays.equals(image, that.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryName != null ? categoryName.hashCode() : 0;
        result = 31 * result + (categoryDescription != null ? categoryDescription.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (parentCategoryId != null ? parentCategoryId.hashCode() : 0);
        result = 31 * result + (categoryLockedFlag != null ? categoryLockedFlag.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
