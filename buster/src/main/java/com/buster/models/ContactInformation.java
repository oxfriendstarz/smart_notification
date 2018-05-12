package com.buster.models;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by jdulay on 5/11/2018.
 */
@Embeddable
public class ContactInformation
{
    @NotNull
    public String email;

    @NotNull
    public String address;

    @NotNull
    public String mobileNumber;

    public ContactInformation(String _email, String _address, String _mobileNumber){
        email = _email;
        address = _address;
        mobileNumber = _mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}