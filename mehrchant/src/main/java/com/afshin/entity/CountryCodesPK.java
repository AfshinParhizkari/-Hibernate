package com.afshin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CountryCodesPK implements Serializable {
    private String isoCountryCode;
    private String language;

    @Column(name = "ISO_COUNTRY_CODE")
    @Id
    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public void setIsoCountryCode(String isoCountryCode) {
        this.isoCountryCode = isoCountryCode;
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

        CountryCodesPK that = (CountryCodesPK) o;

        if (isoCountryCode != null ? !isoCountryCode.equals(that.isoCountryCode) : that.isoCountryCode != null)
            return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = isoCountryCode != null ? isoCountryCode.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }
}
