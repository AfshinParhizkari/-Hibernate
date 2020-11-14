package com.afshin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER_TRANSLATIONS_SEQ", schema = "FusionOrderDemo", catalog = "")
public class MemberTranslationsSeq {
    private Long nextNotCachedValue;
    private Long minimumValue;
    private Long maximumValue;
    private Long startValue;
    private Long increment;
    private Long cacheSize;
    private Byte cycleOption;
    private Long cycleCount;

    @Basic
    @Column(name = "next_not_cached_value")
    public Long getNextNotCachedValue() {
        return nextNotCachedValue;
    }

    public void setNextNotCachedValue(Long nextNotCachedValue) {
        this.nextNotCachedValue = nextNotCachedValue;
    }

    @Basic
    @Column(name = "minimum_value")
    public Long getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(Long minimumValue) {
        this.minimumValue = minimumValue;
    }

    @Basic
    @Column(name = "maximum_value")
    public Long getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(Long maximumValue) {
        this.maximumValue = maximumValue;
    }

    @Basic
    @Column(name = "start_value")
    public Long getStartValue() {
        return startValue;
    }

    public void setStartValue(Long startValue) {
        this.startValue = startValue;
    }

    @Basic
    @Column(name = "increment")
    public Long getIncrement() {
        return increment;
    }

    public void setIncrement(Long increment) {
        this.increment = increment;
    }

    @Basic
    @Column(name = "cache_size")
    public Long getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(Long cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Basic
    @Column(name = "cycle_option")
    public Byte getCycleOption() {
        return cycleOption;
    }

    public void setCycleOption(Byte cycleOption) {
        this.cycleOption = cycleOption;
    }

    @Basic
    @Column(name = "cycle_count")
    public Long getCycleCount() {
        return cycleCount;
    }

    public void setCycleCount(Long cycleCount) {
        this.cycleCount = cycleCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberTranslationsSeq that = (MemberTranslationsSeq) o;

        if (nextNotCachedValue != null ? !nextNotCachedValue.equals(that.nextNotCachedValue) : that.nextNotCachedValue != null)
            return false;
        if (minimumValue != null ? !minimumValue.equals(that.minimumValue) : that.minimumValue != null) return false;
        if (maximumValue != null ? !maximumValue.equals(that.maximumValue) : that.maximumValue != null) return false;
        if (startValue != null ? !startValue.equals(that.startValue) : that.startValue != null) return false;
        if (increment != null ? !increment.equals(that.increment) : that.increment != null) return false;
        if (cacheSize != null ? !cacheSize.equals(that.cacheSize) : that.cacheSize != null) return false;
        if (cycleOption != null ? !cycleOption.equals(that.cycleOption) : that.cycleOption != null) return false;
        if (cycleCount != null ? !cycleCount.equals(that.cycleCount) : that.cycleCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nextNotCachedValue != null ? nextNotCachedValue.hashCode() : 0;
        result = 31 * result + (minimumValue != null ? minimumValue.hashCode() : 0);
        result = 31 * result + (maximumValue != null ? maximumValue.hashCode() : 0);
        result = 31 * result + (startValue != null ? startValue.hashCode() : 0);
        result = 31 * result + (increment != null ? increment.hashCode() : 0);
        result = 31 * result + (cacheSize != null ? cacheSize.hashCode() : 0);
        result = 31 * result + (cycleOption != null ? cycleOption.hashCode() : 0);
        result = 31 * result + (cycleCount != null ? cycleCount.hashCode() : 0);
        return result;
    }
}
