package com.buster.models;

import javax.persistence.Entity;

/**
 * Created by jdulay on 5/11/2018.
 */

public class SubscriberProfile
{
    public SubscriberProfile(String _realName, String _penName, String _email, String _address, String _mobileNumber){
        realName = _realName;
        penName = _penName;
        contactInformation = new ContactInformation(_email,_address,_mobileNumber);
        legitimacyRating = 100;
        System.out.println("NEW SUBSCRIBER WAS ADDED");
    }

    public String realName;
    public String penName;
    public double legitimacyRating;
    public ContactInformation contactInformation;
}
