package com.afshin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class WarehouseStockLevelsPK implements Serializable {
    private Integer productId;
    private Integer warehouseId;

    @Column(name = "PRODUCT_ID")
    @Id
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Column(name = "WAREHOUSE_ID")
    @Id
    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarehouseStockLevelsPK that = (WarehouseStockLevelsPK) o;

        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (warehouseId != null ? !warehouseId.equals(that.warehouseId) : that.warehouseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (warehouseId != null ? warehouseId.hashCode() : 0);
        return result;
    }
}
