package com.example.jiahui.iiplumi.model;

import com.google.gson.annotations.Expose;

/**
 * Created by JiaHui on 25/7/2015.
 */
public class suppliermodel {
    
    @Expose
    private Integer sSupplierID;
    @Expose
    private String sEmail;
    @Expose
    private String sFullName;
    @Expose
    private String sPassword;
    @Expose
    private String sRegisterDate;

    public Integer getsSupplierID() {
        return sSupplierID;
    }

    public void setsSupplierID(Integer sSupplierID) {
        this.sSupplierID = sSupplierID;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsFullName() {
        return sFullName;
    }

    public void setsFullName(String sFullName) {
        this.sFullName = sFullName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsRegisterDate() {
        return sRegisterDate;
    }

    public void setsRegisterDate(String sRegisterDate) {
        this.sRegisterDate = sRegisterDate;
    }
}
