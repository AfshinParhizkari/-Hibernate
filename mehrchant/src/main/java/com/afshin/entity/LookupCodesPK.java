package com.afshin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class LookupCodesPK implements Serializable {
    private String lookupType;
    private String lookupCode;
    private String language;

    @Column(name = "LOOKUP_TYPE")
    @Id
    public String getLookupType() {
        return lookupType;
    }

    public void setLookupType(String lookupType) {
        this.lookupType = lookupType;
    }

    @Column(name = "LOOKUP_CODE")
    @Id
    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    @Column(name = "LANGUAGE")
    @Id
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LookupCodesPK that = (LookupCodesPK) o;

        if (lookupType != null ? !lookupType.equals(that.lookupType) : that.lookupType != null) return false;
        if (lookupCode != null ? !lookupCode.equals(that.lookupCode) : that.lookupCode != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lookupType != null ? lookupType.hashCode() : 0;
        result = 31 * result + (lookupCode != null ? lookupCode.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
