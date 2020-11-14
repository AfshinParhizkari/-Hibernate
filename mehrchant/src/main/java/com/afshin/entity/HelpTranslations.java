package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "HELP_TRANSLATIONS", schema = "FusionOrderDemo", catalog = "")
public class HelpTranslations {
    private Integer helpTranslationsId;
    private Integer helpId;
    private String helpUsage;
    private String helpText;
    private String language;
    private String sourceLanguage;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;

    @Id
    @Column(name = "HELP_TRANSLATIONS_ID")
    public Integer getHelpTranslationsId() {
        return helpTranslationsId;
    }

    public void setHelpTranslationsId(Integer helpTranslationsId) {
        this.helpTranslationsId = helpTranslationsId;
    }

    @Basic
    @Column(name = "HELP_ID")
    public Integer getHelpId() {
        return helpId;
    }

    public void setHelpId(Integer helpId) {
        this.helpId = helpId;
    }

    @Basic
    @Column(name = "HELP_USAGE")
    public String getHelpUsage() {
        return helpUsage;
    }

    public void setHelpUsage(String helpUsage) {
        this.helpUsage = helpUsage;
    }

    @Basic
    @Column(name = "HELP_TEXT")
    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
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
    @Column(name = "SOURCE_LANGUAGE")
    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
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

        HelpTranslations that = (HelpTranslations) o;

        if (helpTranslationsId != null ? !helpTranslationsId.equals(that.helpTranslationsId) : that.helpTranslationsId != null)
            return false;
        if (helpId != null ? !helpId.equals(that.helpId) : that.helpId != null) return false;
        if (helpUsage != null ? !helpUsage.equals(that.helpUsage) : that.helpUsage != null) return false;
        if (helpText != null ? !helpText.equals(that.helpText) : that.helpText != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (sourceLanguage != null ? !sourceLanguage.equals(that.sourceLanguage) : that.sourceLanguage != null)
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
        int result = helpTranslationsId != null ? helpTranslationsId.hashCode() : 0;
        result = 31 * result + (helpId != null ? helpId.hashCode() : 0);
        result = 31 * result + (helpUsage != null ? helpUsage.hashCode() : 0);
        result = 31 * result + (helpText != null ? helpText.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (sourceLanguage != null ? sourceLanguage.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }
}
