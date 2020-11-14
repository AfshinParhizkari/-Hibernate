package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Addresses {
    private Integer addressId;
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String countryId;
    private Integer longitude;
    private Integer latitude;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<AddressUsages> addressUsagesByAddressId;
    private Collection<Orders> ordersByAddressId;
    private Collection<Persons> personsByAddressId;
    private Collection<Warehouses> warehousesByAddressId;

    @Id
    @Column(name = "ADDRESS_ID")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Basic
    @Column(name = "ADDRESS1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "ADDRESS2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "POSTAL_CODE")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "STATE_PROVINCE")
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Basic
    @Column(name = "COUNTRY_ID")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "LONGITUDE")
    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "LATITUDE")
    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
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

        Addresses addresses = (Addresses) o;

        if (addressId != null ? !addressId.equals(addresses.addressId) : addresses.addressId != null) return false;
        if (address1 != null ? !address1.equals(addresses.address1) : addresses.address1 != null) return false;
        if (address2 != null ? !address2.equals(addresses.address2) : addresses.address2 != null) return false;
        if (city != null ? !city.equals(addresses.city) : addresses.city != null) return false;
        if (postalCode != null ? !postalCode.equals(addresses.postalCode) : addresses.postalCode != null) return false;
        if (stateProvince != null ? !stateProvince.equals(addresses.stateProvince) : addresses.stateProvince != null)
            return false;
        if (countryId != null ? !countryId.equals(addresses.countryId) : addresses.countryId != null) return false;
        if (longitude != null ? !longitude.equals(addresses.longitude) : addresses.longitude != null) return false;
        if (latitude != null ? !latitude.equals(addresses.latitude) : addresses.latitude != null) return false;
        if (createdBy != null ? !createdBy.equals(addresses.createdBy) : addresses.createdBy != null) return false;
        if (creationDate != null ? !creationDate.equals(addresses.creationDate) : addresses.creationDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(addresses.lastUpdatedBy) : addresses.lastUpdatedBy != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(addresses.lastUpdateDate) : addresses.lastUpdateDate != null)
            return false;
        if (objectVersionId != null ? !objectVersionId.equals(addresses.objectVersionId) : addresses.objectVersionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = addressId != null ? addressId.hashCode() : 0;
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "addressesByAddressId")
    public Collection<AddressUsages> getAddressUsagesByAddressId() {
        return addressUsagesByAddressId;
    }

    public void setAddressUsagesByAddressId(Collection<AddressUsages> addressUsagesByAddressId) {
        this.addressUsagesByAddressId = addressUsagesByAddressId;
    }

    @OneToMany(mappedBy = "addressesByShipToAddressId")
    public Collection<Orders> getOrdersByAddressId() {
        return ordersByAddressId;
    }

    public void setOrdersByAddressId(Collection<Orders> ordersByAddressId) {
        this.ordersByAddressId = ordersByAddressId;
    }

    @OneToMany(mappedBy = "addressesByPrimaryAddressId")
    public Collection<Persons> getPersonsByAddressId() {
        return personsByAddressId;
    }

    public void setPersonsByAddressId(Collection<Persons> personsByAddressId) {
        this.personsByAddressId = personsByAddressId;
    }

    @OneToMany(mappedBy = "addressesByAddressId")
    public Collection<Warehouses> getWarehousesByAddressId() {
        return warehousesByAddressId;
    }

    public void setWarehousesByAddressId(Collection<Warehouses> warehousesByAddressId) {
        this.warehousesByAddressId = warehousesByAddressId;
    }
}
