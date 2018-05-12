package com.buster.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jdulay on 5/11/2018.
 */
@Entity
@Table(name = "Publisher")
public class PublisherProfile
{
    @Id
    @GeneratedValue
    @Column(name="id")
    public Long id;

    @Column(name="fullName")
    public String fullName;

    @Column(name="username")
    public String username;

    @Column(name="password")
    public String password;

    @Embedded
    @Column(name="contactInformation")
    public ContactInformation contactInformation;

    @Column(name="rating")
    public double rating;

    public PublisherProfile(String fullName, String username, String password, String email, String address, String mobile){
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        contactInformation = new ContactInformation(email,address,mobile);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
