package com.afshin.entity;

import javax.persistence.*;

@Entity
@Table(name = "DEMO_OPTIONS", schema = "FusionOrderDemo", catalog = "")
public class DemoOptions {
    private String key1;
    private String value;
    private String javaDataType;
    private String description;

    @Id
    @Column(name = "KEY1")
    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    @Basic
    @Column(name = "VALUE")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "JAVA_DATA_TYPE")
    public String getJavaDataType() {
        return javaDataType;
    }

    public void setJavaDataType(String javaDataType) {
        this.javaDataType = javaDataType;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DemoOptions that = (DemoOptions) o;

        if (key1 != null ? !key1.equals(that.key1) : that.key1 != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (javaDataType != null ? !javaDataType.equals(that.javaDataType) : that.javaDataType != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key1 != null ? key1.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (javaDataType != null ? javaDataType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
