package com.afshin;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "productlines")
public class Productline {
    public Productline() {
    }

    public Productline(String productLine, String textDescription) {
        this.productLine = productLine;
        this.textDescription = textDescription;
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

    @Override
    public String toString() {
        return "Productline{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
