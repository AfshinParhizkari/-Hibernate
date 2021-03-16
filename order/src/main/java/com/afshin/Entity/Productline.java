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

import javax.persistence.*;
import javax.xml.bind.DatatypeConverter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "productlines")
@JsonFilter("ProductlineFilter")
public class Productline {
    public Productline() {
    }
    @Id
    @Column(name = "productLine")
    private String productLine;

    @Column(name = "textDescription")
    private String textDescription;

    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Column(name = "image")
    private byte[] image;

    @Transient
    private String photo;

    @OneToMany(mappedBy = "productline")
    private List<Product> products;

    public String getProductLine() {
        return productLine;
    }
    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }
    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }
    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPhoto() {return DatatypeConverter.printBase64Binary(image);}

    @Override
    public String toString() {
        return "Productline{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                '}';
    }
    @Transient
    public Set<String> getfilters(){
        Set<String> hash_Set = new HashSet<String>();
        hash_Set.add("productLine");hash_Set.add("textDescription");hash_Set.add("htmlDescription");
        hash_Set.add("image");
        return hash_Set;
    }
}
