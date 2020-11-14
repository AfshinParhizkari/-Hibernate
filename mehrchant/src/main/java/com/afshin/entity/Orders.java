package com.afshin.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Orders {
    private Integer orderId;
    private Date orderDate;
    private Date orderShippedDate;
    private String orderStatusCode;
    private Double orderTotal;
    private Integer customerId;
    private String shipToName;
    private Integer shipToAddressId;
    private String shipToPhoneNumber;
    private Integer shippingOptionId;
    private Integer paymentOptionId;
    private Integer discountId;
    private Integer couponId;
    private String freeShippingFlag;
    private String customerCollectFlag;
    private Integer collectionWarehouseId;
    private String giftwrapFlag;
    private String giftwrapMessage;
    private String createdBy;
    private Date creationDate;
    private String lastUpdatedBy;
    private Date lastUpdateDate;
    private Integer objectVersionId;
    private Collection<CouponUsages> couponUsagesByOrderId;
    private Persons personsByCustomerId;
    private Addresses addressesByShipToAddressId;
    private ShippingOptionsBase shippingOptionsBaseByShippingOptionId;
    private PaymentOptions paymentOptionsByPaymentOptionId;
    private DiscountsBase discountsBaseByDiscountId;
    private DiscountsBase discountsBaseByCouponId;
    private Warehouses warehousesByCollectionWarehouseId;
    private Collection<OrderItems> orderItemsByOrderId;

    @Id
    @Column(name = "ORDER_ID")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "ORDER_DATE")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "ORDER_SHIPPED_DATE")
    public Date getOrderShippedDate() {
        return orderShippedDate;
    }

    public void setOrderShippedDate(Date orderShippedDate) {
        this.orderShippedDate = orderShippedDate;
    }

    @Basic
    @Column(name = "ORDER_STATUS_CODE")
    public String getOrderStatusCode() {
        return orderStatusCode;
    }

    public void setOrderStatusCode(String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    @Basic
    @Column(name = "ORDER_TOTAL")
    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Basic
    @Column(name = "CUSTOMER_ID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "SHIP_TO_NAME")
    public String getShipToName() {
        return shipToName;
    }

    public void setShipToName(String shipToName) {
        this.shipToName = shipToName;
    }

    @Basic
    @Column(name = "SHIP_TO_ADDRESS_ID")
    public Integer getShipToAddressId() {
        return shipToAddressId;
    }

    public void setShipToAddressId(Integer shipToAddressId) {
        this.shipToAddressId = shipToAddressId;
    }

    @Basic
    @Column(name = "SHIP_TO_PHONE_NUMBER")
    public String getShipToPhoneNumber() {
        return shipToPhoneNumber;
    }

    public void setShipToPhoneNumber(String shipToPhoneNumber) {
        this.shipToPhoneNumber = shipToPhoneNumber;
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
    @Column(name = "PAYMENT_OPTION_ID")
    public Integer getPaymentOptionId() {
        return paymentOptionId;
    }

    public void setPaymentOptionId(Integer paymentOptionId) {
        this.paymentOptionId = paymentOptionId;
    }

    @Basic
    @Column(name = "DISCOUNT_ID")
    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    @Basic
    @Column(name = "COUPON_ID")
    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    @Basic
    @Column(name = "FREE_SHIPPING_FLAG")
    public String getFreeShippingFlag() {
        return freeShippingFlag;
    }

    public void setFreeShippingFlag(String freeShippingFlag) {
        this.freeShippingFlag = freeShippingFlag;
    }

    @Basic
    @Column(name = "CUSTOMER_COLLECT_FLAG")
    public String getCustomerCollectFlag() {
        return customerCollectFlag;
    }

    public void setCustomerCollectFlag(String customerCollectFlag) {
        this.customerCollectFlag = customerCollectFlag;
    }

    @Basic
    @Column(name = "COLLECTION_WAREHOUSE_ID")
    public Integer getCollectionWarehouseId() {
        return collectionWarehouseId;
    }

    public void setCollectionWarehouseId(Integer collectionWarehouseId) {
        this.collectionWarehouseId = collectionWarehouseId;
    }

    @Basic
    @Column(name = "GIFTWRAP_FLAG")
    public String getGiftwrapFlag() {
        return giftwrapFlag;
    }

    public void setGiftwrapFlag(String giftwrapFlag) {
        this.giftwrapFlag = giftwrapFlag;
    }

    @Basic
    @Column(name = "GIFTWRAP_MESSAGE")
    public String getGiftwrapMessage() {
        return giftwrapMessage;
    }

    public void setGiftwrapMessage(String giftwrapMessage) {
        this.giftwrapMessage = giftwrapMessage;
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

        Orders orders = (Orders) o;

        if (orderId != null ? !orderId.equals(orders.orderId) : orders.orderId != null) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;
        if (orderShippedDate != null ? !orderShippedDate.equals(orders.orderShippedDate) : orders.orderShippedDate != null)
            return false;
        if (orderStatusCode != null ? !orderStatusCode.equals(orders.orderStatusCode) : orders.orderStatusCode != null)
            return false;
        if (orderTotal != null ? !orderTotal.equals(orders.orderTotal) : orders.orderTotal != null) return false;
        if (customerId != null ? !customerId.equals(orders.customerId) : orders.customerId != null) return false;
        if (shipToName != null ? !shipToName.equals(orders.shipToName) : orders.shipToName != null) return false;
        if (shipToAddressId != null ? !shipToAddressId.equals(orders.shipToAddressId) : orders.shipToAddressId != null)
            return false;
        if (shipToPhoneNumber != null ? !shipToPhoneNumber.equals(orders.shipToPhoneNumber) : orders.shipToPhoneNumber != null)
            return false;
        if (shippingOptionId != null ? !shippingOptionId.equals(orders.shippingOptionId) : orders.shippingOptionId != null)
            return false;
        if (paymentOptionId != null ? !paymentOptionId.equals(orders.paymentOptionId) : orders.paymentOptionId != null)
            return false;
        if (discountId != null ? !discountId.equals(orders.discountId) : orders.discountId != null) return false;
        if (couponId != null ? !couponId.equals(orders.couponId) : orders.couponId != null) return false;
        if (freeShippingFlag != null ? !freeShippingFlag.equals(orders.freeShippingFlag) : orders.freeShippingFlag != null)
            return false;
        if (customerCollectFlag != null ? !customerCollectFlag.equals(orders.customerCollectFlag) : orders.customerCollectFlag != null)
            return false;
        if (collectionWarehouseId != null ? !collectionWarehouseId.equals(orders.collectionWarehouseId) : orders.collectionWarehouseId != null)
            return false;
        if (giftwrapFlag != null ? !giftwrapFlag.equals(orders.giftwrapFlag) : orders.giftwrapFlag != null)
            return false;
        if (giftwrapMessage != null ? !giftwrapMessage.equals(orders.giftwrapMessage) : orders.giftwrapMessage != null)
            return false;
        if (createdBy != null ? !createdBy.equals(orders.createdBy) : orders.createdBy != null) return false;
        if (creationDate != null ? !creationDate.equals(orders.creationDate) : orders.creationDate != null)
            return false;
        if (lastUpdatedBy != null ? !lastUpdatedBy.equals(orders.lastUpdatedBy) : orders.lastUpdatedBy != null)
            return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(orders.lastUpdateDate) : orders.lastUpdateDate != null)
            return false;
        if (objectVersionId != null ? !objectVersionId.equals(orders.objectVersionId) : orders.objectVersionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (orderShippedDate != null ? orderShippedDate.hashCode() : 0);
        result = 31 * result + (orderStatusCode != null ? orderStatusCode.hashCode() : 0);
        result = 31 * result + (orderTotal != null ? orderTotal.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (shipToName != null ? shipToName.hashCode() : 0);
        result = 31 * result + (shipToAddressId != null ? shipToAddressId.hashCode() : 0);
        result = 31 * result + (shipToPhoneNumber != null ? shipToPhoneNumber.hashCode() : 0);
        result = 31 * result + (shippingOptionId != null ? shippingOptionId.hashCode() : 0);
        result = 31 * result + (paymentOptionId != null ? paymentOptionId.hashCode() : 0);
        result = 31 * result + (discountId != null ? discountId.hashCode() : 0);
        result = 31 * result + (couponId != null ? couponId.hashCode() : 0);
        result = 31 * result + (freeShippingFlag != null ? freeShippingFlag.hashCode() : 0);
        result = 31 * result + (customerCollectFlag != null ? customerCollectFlag.hashCode() : 0);
        result = 31 * result + (collectionWarehouseId != null ? collectionWarehouseId.hashCode() : 0);
        result = 31 * result + (giftwrapFlag != null ? giftwrapFlag.hashCode() : 0);
        result = 31 * result + (giftwrapMessage != null ? giftwrapMessage.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (lastUpdatedBy != null ? lastUpdatedBy.hashCode() : 0);
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (objectVersionId != null ? objectVersionId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<CouponUsages> getCouponUsagesByOrderId() {
        return couponUsagesByOrderId;
    }

    public void setCouponUsagesByOrderId(Collection<CouponUsages> couponUsagesByOrderId) {
        this.couponUsagesByOrderId = couponUsagesByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "PERSON_ID", nullable = false)
    public Persons getPersonsByCustomerId() {
        return personsByCustomerId;
    }

    public void setPersonsByCustomerId(Persons personsByCustomerId) {
        this.personsByCustomerId = personsByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "SHIP_TO_ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    public Addresses getAddressesByShipToAddressId() {
        return addressesByShipToAddressId;
    }

    public void setAddressesByShipToAddressId(Addresses addressesByShipToAddressId) {
        this.addressesByShipToAddressId = addressesByShipToAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "SHIPPING_OPTION_ID", referencedColumnName = "SHIPPING_OPTION_ID", nullable = false)
    public ShippingOptionsBase getShippingOptionsBaseByShippingOptionId() {
        return shippingOptionsBaseByShippingOptionId;
    }

    public void setShippingOptionsBaseByShippingOptionId(ShippingOptionsBase shippingOptionsBaseByShippingOptionId) {
        this.shippingOptionsBaseByShippingOptionId = shippingOptionsBaseByShippingOptionId;
    }

    @ManyToOne
    @JoinColumn(name = "PAYMENT_OPTION_ID", referencedColumnName = "PAYMENT_OPTION_ID")
    public PaymentOptions getPaymentOptionsByPaymentOptionId() {
        return paymentOptionsByPaymentOptionId;
    }

    public void setPaymentOptionsByPaymentOptionId(PaymentOptions paymentOptionsByPaymentOptionId) {
        this.paymentOptionsByPaymentOptionId = paymentOptionsByPaymentOptionId;
    }

    @ManyToOne
    @JoinColumn(name = "DISCOUNT_ID", referencedColumnName = "DISCOUNT_ID")
    public DiscountsBase getDiscountsBaseByDiscountId() {
        return discountsBaseByDiscountId;
    }

    public void setDiscountsBaseByDiscountId(DiscountsBase discountsBaseByDiscountId) {
        this.discountsBaseByDiscountId = discountsBaseByDiscountId;
    }

    @ManyToOne
    @JoinColumn(name = "COUPON_ID", referencedColumnName = "DISCOUNT_ID")
    public DiscountsBase getDiscountsBaseByCouponId() {
        return discountsBaseByCouponId;
    }

    public void setDiscountsBaseByCouponId(DiscountsBase discountsBaseByCouponId) {
        this.discountsBaseByCouponId = discountsBaseByCouponId;
    }

    @ManyToOne
    @JoinColumn(name = "COLLECTION_WAREHOUSE_ID", referencedColumnName = "WAREHOUSE_ID")
    public Warehouses getWarehousesByCollectionWarehouseId() {
        return warehousesByCollectionWarehouseId;
    }

    public void setWarehousesByCollectionWarehouseId(Warehouses warehousesByCollectionWarehouseId) {
        this.warehousesByCollectionWarehouseId = warehousesByCollectionWarehouseId;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<OrderItems> getOrderItemsByOrderId() {
        return orderItemsByOrderId;
    }

    public void setOrderItemsByOrderId(Collection<OrderItems> orderItemsByOrderId) {
        this.orderItemsByOrderId = orderItemsByOrderId;
    }
}
