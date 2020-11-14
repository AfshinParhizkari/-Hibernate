package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "PRODUCT_IMAGES", schema = "FusionOrderDemo", catalog = "")
public class ProductImages {
    private Integer productImageId;
    private Integer productId;
    private String defaultViewFlag;
    private Integer detailImageId;
    private byte[] image;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private ProductsBase productsBaseByProductId;
    private ProductImages productImagesByDetailImageId;
    private Collection<ProductImages> productImagesByProductImageId;

    @Id
    @Column(name = "PRODUCT_IMAGE_ID")
    public Integer getProductImageId() {
        return productImageId;
    }

    public void setProductImageId(Integer productImageId) {
        this.productImageId = productImageId;
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
    @Column(name = "DEFAULT_VIEW_FLAG")
    public String getDefaultViewFlag() {
        return defaultViewFlag;
    }

    public void setDefaultViewFlag(String defaultViewFlag) {
        this.defaultViewFlag = defaultViewFlag;
    }

    @Basic
    @Column(name = "DETAIL_IMAGE_ID")
    public Integer getDetailImageId() {
        return detailImageId;
    }

    public void setDetailImageId(Integer detailImageId) {
        this.detailImageId = detailImageId;
    }

    @Basic
    @Column(name = "IMAGE")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

        ProductImages that = (ProductImages) o;

        if (productImageId != null ? !productImageId.equals(that.productImageId) : that.productImageId != null)
            return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (defaultViewFlag != null ? !defaultViewFlag.equals(that.defaultViewFlag) : that.defaultViewFlag != null)
            return false;
        if (detailImageId != null ? !detailImageId.equals(that.detailImageId) : that.detailImageId != null)
            return false;
        if (!Arrays.equals(image, that.image)) return false;
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
        int result = productImageId != null ? productImageId.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (defaultViewFlag != null ? defaultViewFlag.hashCode() : 0);
        result = 31 * result + (detailImageId != null ? detailImageId.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", nullable = false)
    public ProductsBase getProductsBaseByProductId() {
        return productsBaseByProductId;
    }

    public void setProductsBaseByProductId(ProductsBase productsBaseByProductId) {
        this.productsBaseByProductId = productsBaseByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "DETAIL_IMAGE_ID", referencedColumnName = "PRODUCT_IMAGE_ID")
    public ProductImages getProductImagesByDetailImageId() {
        return productImagesByDetailImageId;
    }

    public void setProductImagesByDetailImageId(ProductImages productImagesByDetailImageId) {
        this.productImagesByDetailImageId = productImagesByDetailImageId;
    }

    @OneToMany(mappedBy = "productImagesByDetailImageId")
    public Collection<ProductImages> getProductImagesByProductImageId() {
        return productImagesByProductImageId;
    }

    public void setProductImagesByProductImageId(Collection<ProductImages> productImagesByProductImageId) {
        this.productImagesByProductImageId = productImagesByProductImageId;
    }
}
