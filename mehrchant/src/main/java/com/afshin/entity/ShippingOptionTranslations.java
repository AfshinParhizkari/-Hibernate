package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "SHIPPING_OPTION_TRANSLATIONS", schema = "FusionOrderDemo", catalog = "")
public class ShippingOptionTranslations {
    private Integer shippingTranslationsId;
    private Integer shippingOptionId;
    private String shippingMethod;
    private String language;
    private String sourceLang;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private ShippingOptionsBase shippingOptionsBaseByShippingOptionId;

    @Id
    @Column(name = "SHIPPING_TRANSLATIONS_ID")
    public Integer getShippingTranslationsId() {
        return shippingTranslationsId;
    }

    public void setShippingTranslationsId(Integer shippingTranslationsId) {
        this.shippingTranslationsId = shippingTranslationsId;
    }

    @Basic
    @Column(name = "SHIPPING_OPTION_ID")
    public Integer getShippingOptionId() {
        return shippingOptionId;
    }

    public void setShippingOptionId(Integer shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    @Basic
    @Column(name = "SHIPPING_METHOD")
    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @Basic
    @Column(name = "LANGUAGE")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "SOURCE_LANG")
    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
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

        ShippingOptionTranslations that = (ShippingOptionTranslations) o;

        if (shippingTranslationsId != null ? !shippingTranslationsId.equals(that.shippingTranslationsId) : that.shippingTranslationsId != null)
            return false;
        if (shippingOptionId != null ? !shippingOptionId.equals(that.shippingOptionId) : that.shippingOptionId != null)
            return false;
        if (shippingMethod != null ? !shippingMethod.equals(that.shippingMethod) : that.shippingMethod != null)
            return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (sourceLang != null ? !sourceLang.equals(that.sourceLang) : that.sourceLang != null) return false;
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
        int result = shippingTranslationsId != null ? shippingTranslationsId.hashCode() : 0;
        result = 31 * result + (shippingOptionId != null ? shippingOptionId.hashCode() : 0);
        result = 31 * result + (shippingMethod != null ? shippingMethod.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (sourceLang != null ? sourceLang.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "SHIPPING_OPTION_ID", referencedColumnName = "SHIPPING_OPTION_ID", nullable = false)
    public ShippingOptionsBase getShippingOptionsBaseByShippingOptionId() {
        return shippingOptionsBaseByShippingOptionId;
    }

    public void setShippingOptionsBaseByShippingOptionId(ShippingOptionsBase shippingOptionsBaseByShippingOptionId) {
        this.shippingOptionsBaseByShippingOptionId = shippingOptionsBaseByShippingOptionId;
    }
}
