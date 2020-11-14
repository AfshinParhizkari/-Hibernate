package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "PRODUCTS_BASE", schema = "FusionOrderDemo", catalog = "")
public class ProductsBase {
    private Integer productId;
    private Integer supplierId;
    private Integer parentCategoryId;
    private Integer categoryId;
    private String productName;
    private String productStatus;
    private Double costPrice;
    private Double listPrice;
    private Double minPrice;
    private Double warrantyPeriodMonths;
    private String shippingClassCode;
    private String externalUrl;
    private String attributeCategory;
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
    private String attribute15;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<OrderItems> orderItemsByProductId;
    private Suppliers suppliersBySupplierId;
    private ProductCategoriesBase productCategoriesBaseByCategoryId;
    private Collection<ProductCategoriesBase> productCategoriesBasesByProductId;
    private Collection<ProductImages> productImagesByProductId;
    private Collection<ProductTranslations> productTranslationsByProductId;
    private Collection<WarehouseStockLevels> warehouseStockLevelsByProductId;

    @Id
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
    @Column(name = "PARENT_CATEGORY_ID")
    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
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
    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "PRODUCT_STATUS")
    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
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
    @Column(name = "LIST_PRICE")
    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
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

    @Basic
    @Column(name = "ATTRIBUTE15")
    public String getAttribute15() {
        return attribute15;
    }

    public void setAttribute15(String attribute15) {
        this.attribute15 = attribute15;
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

        ProductsBase that = (ProductsBase) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (supplierId != null ? !supplierId.equals(that.supplierId) : that.supplierId != null) return false;
        if (parentCategoryId != null ? !parentCategoryId.equals(that.parentCategoryId) : that.parentCategoryId != null)
            return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productStatus != null ? !productStatus.equals(that.productStatus) : that.productStatus != null)
            return false;
        if (costPrice != null ? !costPrice.equals(that.costPrice) : that.costPrice != null) return false;
        if (listPrice != null ? !listPrice.equals(that.listPrice) : that.listPrice != null) return false;
        if (minPrice != null ? !minPrice.equals(that.minPrice) : that.minPrice != null) return false;
        if (warrantyPeriodMonths != null ? !warrantyPeriodMonths.equals(that.warrantyPeriodMonths) : that.warrantyPeriodMonths != null)
            return false;
        if (shippingClassCode != null ? !shippingClassCode.equals(that.shippingClassCode) : that.shippingClassCode != null)
            return false;
        if (externalUrl != null ? !externalUrl.equals(that.externalUrl) : that.externalUrl != null) return false;
        if (attributeCategory != null ? !attributeCategory.equals(that.attributeCategory) : that.attributeCategory != null)
            return false;
        if (attribute1 != null ? !attribute1.equals(that.attribute1) : that.attribute1 != null) return false;
        if (attribute2 != null ? !attribute2.equals(that.attribute2) : that.attribute2 != null) return false;
        if (attribute3 != null ? !attribute3.equals(that.attribute3) : that.attribute3 != null) return false;
        if (attribute4 != null ? !attribute4.equals(that.attribute4) : that.attribute4 != null) return false;
        if (attribute5 != null ? !attribute5.equals(that.attribute5) : that.attribute5 != null) return false;
        if (attribute6 != null ? !attribute6.equals(that.attribute6) : that.attribute6 != null) return false;
        if (attribute7 != null ? !attribute7.equals(that.attribute7) : that.attribute7 != null) return false;
        if (attribute8 != null ? !attribute8.equals(that.attribute8) : that.attribute8 != null) return false;
        if (attribute9 != null ? !attribute9.equals(that.attribute9) : that.attribute9 != null) return false;
        if (attribute10 != null ? !attribute10.equals(that.attribute10) : that.attribute10 != null) return false;
        if (attribute11 != null ? !attribute11.equals(that.attribute11) : that.attribute11 != null) return false;
        if (attribute12 != null ? !attribute12.equals(that.attribute12) : that.attribute12 != null) return false;
        if (attribute13 != null ? !attribute13.equals(that.attribute13) : that.attribute13 != null) return false;
        if (attribute14 != null ? !attribute14.equals(that.attribute14) : that.attribute14 != null) return false;
        if (attribute15 != null ? !attribute15.equals(that.attribute15) : that.attribute15 != null) return false;
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
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (parentCategoryId != null ? parentCategoryId.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productStatus != null ? productStatus.hashCode() : 0);
        result = 31 * result + (costPrice != null ? costPrice.hashCode() : 0);
        result = 31 * result + (listPrice != null ? listPrice.hashCode() : 0);
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        result = 31 * result + (warrantyPeriodMonths != null ? warrantyPeriodMonths.hashCode() : 0);
        result = 31 * result + (shippingClassCode != null ? shippingClassCode.hashCode() : 0);
        result = 31 * result + (externalUrl != null ? externalUrl.hashCode() : 0);
        result = 31 * result + (attributeCategory != null ? attributeCategory.hashCode() : 0);
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
        result = 31 * result + (attribute15 != null ? attribute15.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productsBaseByProductId")
    public Collection<OrderItems> getOrderItemsByProductId() {
        return orderItemsByProductId;
    }

    public void setOrderItemsByProductId(Collection<OrderItems> orderItemsByProductId) {
        this.orderItemsByProductId = orderItemsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "SUPPLIER_ID", nullable = false)
    public Suppliers getSuppliersBySupplierId() {
        return suppliersBySupplierId;
    }

    public void setSuppliersBySupplierId(Suppliers suppliersBySupplierId) {
        this.suppliersBySupplierId = suppliersBySupplierId;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    public ProductCategoriesBase getProductCategoriesBaseByCategoryId() {
        return productCategoriesBaseByCategoryId;
    }

    public void setProductCategoriesBaseByCategoryId(ProductCategoriesBase productCategoriesBaseByCategoryId) {
        this.productCategoriesBaseByCategoryId = productCategoriesBaseByCategoryId;
    }

    @OneToMany(mappedBy = "productsBaseByRepresentativeProductId")
    public Collection<ProductCategoriesBase> getProductCategoriesBasesByProductId() {
        return productCategoriesBasesByProductId;
    }

    public void setProductCategoriesBasesByProductId(Collection<ProductCategoriesBase> productCategoriesBasesByProductId) {
        this.productCategoriesBasesByProductId = productCategoriesBasesByProductId;
    }

    @OneToMany(mappedBy = "productsBaseByProductId")
    public Collection<ProductImages> getProductImagesByProductId() {
        return productImagesByProductId;
    }

    public void setProductImagesByProductId(Collection<ProductImages> productImagesByProductId) {
        this.productImagesByProductId = productImagesByProductId;
    }

    @OneToMany(mappedBy = "productsBaseByProductId")
    public Collection<ProductTranslations> getProductTranslationsByProductId() {
        return productTranslationsByProductId;
    }

    public void setProductTranslationsByProductId(Collection<ProductTranslations> productTranslationsByProductId) {
        this.productTranslationsByProductId = productTranslationsByProductId;
    }

    @OneToMany(mappedBy = "productsBaseByProductId")
    public Collection<WarehouseStockLevels> getWarehouseStockLevelsByProductId() {
        return warehouseStockLevelsByProductId;
    }

    public void setWarehouseStockLevelsByProductId(Collection<WarehouseStockLevels> warehouseStockLevelsByProductId) {
        this.warehouseStockLevelsByProductId = warehouseStockLevelsByProductId;
    }
}
