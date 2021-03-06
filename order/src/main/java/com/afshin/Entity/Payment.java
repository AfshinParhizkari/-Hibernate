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
import com.afshin.General.GregorianDate;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "payments")
@IdClass(PaymentPK.class)
@JsonFilter("PaymentFilter")
public class Payment {
    public Payment() {
    }

    @Id
    @Column(name = "customerNumber")
    private Integer customerNumber;

    @Id
    @Column(name = "checkNumber")
    private String checkNumber;

    @Column(name = "paymentDate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date paymentDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "customerNumber",insertable = false,updatable = false)
    private Customer customer;

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "customerNumber=" + customerNumber +
                ", checkNumber='" + checkNumber + '\'' +
                ", paymentDate=" + paymentDate +
                //", Miladi_paymentDate=" + GregorianDate.miladiStr(paymentDate) +
                //", Shamsi_paymentDate=" + GregorianDate.shamsiStr(GregorianDate.miladi2shamsi(paymentDate)) +
                ", amount=" + amount +
                ", customer=" + customer +
                '}';
    }

}
