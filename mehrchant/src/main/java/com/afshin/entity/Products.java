package com.afshin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Products {
    private String description;
    private String additionalInfo;
    private Double costPrice;
    private Integer supplierId;
    private String productName;
    private Double listPrice;
    private Integer productId;
    private Integer categoryId;
    private Double minPrice;
    private Double warrantyPeriodMonths;
    private String shippingClassCode;
    private String externalUrl;
    private String attributeCategory;
    private String attribute15;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private String attribute6;
    private String attribute7;
    private String attribute8;
    private String attribute9;
    private String attribute10;
    private String attribute11;
    private String attribute12;
    private String attribute13;
    private String attribute14;

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ADDITIONAL_INFO")
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Basic
    @Column(name = "COST_PRICE")
    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
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
    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "LIST_PRICE")
    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    @Basic
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
    @Column(name = "MIN_PRICE")
    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    @Basic
    @Column(name = "WARRANTY_PERIOD_MONTHS")
    public Double getWarrantyPeriodMonths() {
        return warrantyPeriodMonths;
    }

    public void setWarrantyPeriodMonths(Double warrantyPeriodMonths) {
        this.warrantyPeriodMonths = warrantyPeriodMonths;
    }

    @Basic
    @Column(name = "SHIPPING_CLASS_CODE")
    public String getShippingClassCode() {
        return shippingClassCode;
    }

    public void setShippingClassCode(String shippingClassCode) {
        this.shippingClassCode = shippingClassCode;
    }

    @Basic
    @Column(name = "EXTERNAL_URL")
    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @Basic
    @Column(name = "ATTRIBUTE_CATEGORY")
    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    @Basic
    @Column(name = "ATTRIBUTE15")
    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
    }

    @Basic
    @Column(name = "ATTRIBUTE1")
    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    @Basic
    @Column(name = "ATTRIBUTE2")
    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    @Basic
    @Column(name = "ATTRIBUTE3")
    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    @Basic
    @Column(name = "ATTRIBUTE4")
    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    @Basic
    @Column(name = "ATTRIBUTE5")
    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    @Basic
    @Column(name = "ATTRIBUTE6")
    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }

    @Basic
    @Column(name = "ATTRIBUTE7")
    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }

    @Basic
    @Column(name = "ATTRIBUTE8")
    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }

    @Basic
    @Column(name = "ATTRIBUTE9")
    public String getAttribute9() {
        return attribute9;
    }

    public void setAttribute9(String attribute9) {
        this.attribute9 = attribute9;
    }

    @Basic
    @Column(name = "ATTRIBUTE10")
    public String getAttribute10() {
        return attribute10;
    }

    public void setAttribute10(String attribute10) {
        this.attribute10 = attribute10;
    }

    @Basic
    @Column(name = "ATTRIBUTE11")
    public String getAttribute11() {
        return attribute11;
    }

    public void setAttribute11(String attribute11) {
        this.attribute11 = attribute11;
    }

    @Basic
    @Column(name = "ATTRIBUTE12")
    public String getAttribute12() {
        return attribute12;
    }

    public void setAttribute12(String attribute12) {
        this.attribute12 = attribute12;
    }

    @Basic
    @Column(name = "ATTRIBUTE13")
    public String getAttribute13() {
        return attribute13;
    }

    public void setAttribute13(String attribute13) {
        this.attribute13 = attribute13;
    }

    @Basic
    @Column(name = "ATTRIBUTE14")
    public String getAttribute14() {
        return attribute14;
    }

    public void setAttribute14(String attribute14) {
        this.attribute14 = attribute14;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Products products = (Products) o;

        if (description != null ? !description.equals(products.description) : products.description != null)
            return false;
        if (additionalInfo != null ? !additionalInfo.equals(products.additionalInfo) : products.additionalInfo != null)
            return false;
        if (costPrice != null ? !costPrice.equals(products.costPrice) : products.costPrice != null) return false;
        if (supplierId != null ? !supplierId.equals(products.supplierId) : products.supplierId != null) return false;
        if (productName != null ? !productName.equals(products.productName) : products.productName != null)
            return false;
        if (listPrice != null ? !listPrice.equals(products.listPrice) : products.listPrice != null) return false;
        if (productId != null ? !productId.equals(products.productId) : products.productId != null) return false;
        if (categoryId != null ? !categoryId.equals(products.categoryId) : products.categoryId != null) return false;
        if (minPrice != null ? !minPrice.equals(products.minPrice) : products.minPrice != null) return false;
        if (warrantyPeriodMonths != null ? !warrantyPeriodMonths.equals(products.warrantyPeriodMonths) : products.warrantyPeriodMonths != null)
            return false;
        if (shippingClassCode != null ? !shippingClassCode.equals(products.shippingClassCode) : products.shippingClassCode != null)
            return false;
        if (externalUrl != null ? !externalUrl.equals(products.externalUrl) : products.externalUrl != null)
            return false;
        if (attributeCategory != null ? !attributeCategory.equals(products.attributeCategory) : products.attributeCategory != null)
            return false;
        if (attribute15 != null ? !attribute15.equals(products.attribute15) : products.attribute15 != null)
            return false;
        if (attribute1 != null ? !attribute1.equals(products.attribute1) : products.attribute1 != null) return false;
        if (attribute2 != null ? !attribute2.equals(products.attribute2) : products.attribute2 != null) return false;
        if (attribute3 != null ? !attribute3.equals(products.attribute3) : products.attribute3 != null) return false;
        if (attribute4 != null ? !attribute4.equals(products.attribute4) : products.attribute4 != null) return false;
        if (attribute5 != null ? !attribute5.equals(products.attribute5) : products.attribute5 != null) return false;
        if (attribute6 != null ? !attribute6.equals(products.attribute6) : products.attribute6 != null) return false;
        if (attribute7 != null ? !attribute7.equals(products.attribute7) : products.attribute7 != null) return false;
        if (attribute8 != null ? !attribute8.equals(products.attribute8) : products.attribute8 != null) return false;
        if (attribute9 != null ? !attribute9.equals(products.attribute9) : products.attribute9 != null) return false;
        if (attribute10 != null ? !attribute10.equals(products.attribute10) : products.attribute10 != null)
            return false;
        if (attribute11 != null ? !attribute11.equals(products.attribute11) : products.attribute11 != null)
            return false;
        if (attribute12 != null ? !attribute12.equals(products.attribute12) : products.attribute12 != null)
            return false;
        if (attribute13 != null ? !attribute13.equals(products.attribute13) : products.attribute13 != null)
            return false;
        if (attribute14 != null ? !attribute14.equals(products.attribute14) : products.attribute14 != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (additionalInfo != null ? additionalInfo.hashCode() : 0);
        result = 31 * result + (costPrice != null ? costPrice.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (listPrice != null ? listPrice.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        result = 31 * result + (warrantyPeriodMonths != null ? warrantyPeriodMonths.hashCode() : 0);
        result = 31 * result + (shippingClassCode != null ? shippingClassCode.hashCode() : 0);
        result = 31 * result + (externalUrl != null ? externalUrl.hashCode() : 0);
        result = 31 * result + (attributeCategory != null ? attributeCategory.hashCode() : 0);
        result = 31 * result + (attribute15 != null ? attribute15.hashCode() : 0);
        result = 31 * result + (attribute1 != null ? attribute1.hashCode() : 0);
        result = 31 * result + (attribute2 != null ? attribute2.hashCode() : 0);
        result = 31 * result + (attribute3 != null ? attribute3.hashCode() : 0);
        result = 31 * result + (attribute4 != null ? attribute4.hashCode() : 0);
        result = 31 * result + (attribute5 != null ? attribute5.hashCode() : 0);
        result = 31 * result + (attribute6 != null ? attribute6.hashCode() : 0);
        result = 31 * result + (attribute7 != null ? attribute7.hashCode() : 0);
        result = 31 * result + (attribute8 != null ? attribute8.hashCode() : 0);
        result = 31 * result + (attribute9 != null ? attribute9.hashCode() : 0);
        result = 31 * result + (attribute10 != null ? attribute10.hashCode() : 0);
        result = 31 * result + (attribute11 != null ? attribute11.hashCode() : 0);
        result = 31 * result + (attribute12 != null ? attribute12.hashCode() : 0);
        result = 31 * result + (attribute13 != null ? attribute13.hashCode() : 0);
        result = 31 * result + (attribute14 != null ? attribute14.hashCode() : 0);
        return result;
    }
}
