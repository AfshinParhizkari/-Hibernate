package com.afshin.Entity;
/**
 * @Project order
 * @Author Afshin Parhizkari
 * @Date 2020 - 11 - 27
 * @Time 5:59 AM
 * Created by   IntelliJ IDEA
 * Email:       Afshin.Parhizkari@gmail.com
 * Description:
 */

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@JsonFilter("ProductFilter")
public class Product {

    public Product() {}

    @Id
    @Column(name = "productCode")
    private String productCode;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productLine")
    private String productLine;

    @Column(name = "productScale")
    private String productScale;

    @Column(name = "productVendor")
    private String productVendor;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "quantityInStock")
    private Integer quantityInStock;

    @Column(name = "buyPrice")
    private BigDecimal buyPrice;

    @Column(name = "MSRP")
    @JsonView
    private BigDecimal MSRP;

    @ManyToOne
    @JoinColumn(name = "productLine",referencedColumnName = "productLine",insertable = false,updatable = false)
    private Productline productline;

    @OneToMany(mappedBy = "product")
    private List<Orderdetail> orderdetailsList;

    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }
    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }
    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }
    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }
    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }

    public Productline getproductline() {
        return productline;
    }
    public void setproductline(Productline productline) {this.productline = productline;}

    public List<Orderdetail> getOrderdetailsList() {
        return orderdetailsList;
    }
    public void setOrderdetailsList(List<Orderdetail> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", quantityInStock=" + quantityInStock + '\'' +
                ", buyPrice=" + buyPrice + '\'' +
                ", MSRP=" + MSRP + '\'' +
                //"\n, productline=" + productline +
                '}';
    }
    @Transient
    public Set<String> getfilters(){
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("productCode");hash_Set.add("productName");hash_Set.add("productLine");
        hash_Set.add("productScale");hash_Set.add("productVendor");hash_Set.add("productDescription");
        hash_Set.add("quantityInStock");hash_Set.add("buyPrice");hash_Set.add("MSRP");
        return hash_Set;
    }
}
