package com.buster.models;

import java.util.ArrayList;

/**
 * Created by jdulay on 5/11/2018.
 */
public class PublisherProfile
{
    public PublisherProfile(String _realName, String _penName, String _email, String _address, String _mobileNumber){
        realName = _realName;
        penName = _penName;
        contactInformation = new ContactInformation(_email,_address,_mobileNumber);
        legitimacyRating = 100;
        System.out.println("NEW PUBLISHER WAS ADDED");
        System.out.println("username"+"\t"+penName);
    }
    public String realName;
    public String penName;
    public double legitimacyRating;
    public ContactInformation contactInformation;
    public static ArrayList<Report> reports = new ArrayList<Report>();
    public double rating;
}
