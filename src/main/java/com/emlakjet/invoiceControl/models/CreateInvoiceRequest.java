package com.emlakjet.invoiceControl.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class CreateInvoiceRequest {

    @NotNull
    private String firstName;

    private String lastName;

    @Email
    private String email;

    private Float amount;

    private String productName;

    private String billNo;
//Getter ve Setter'lar


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }
}
