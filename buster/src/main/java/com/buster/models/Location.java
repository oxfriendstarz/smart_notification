package com.buster.models;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Ramon on 5/12/2018.
 */
@Embeddable
public class Location {

    @NotNull
    public double Latitude = 14.661194;

    @NotNull
    public double Longitude = 121.062024;

    @NotNull
    public String MarkedLocation = "BLDG O, UP Technohub, Commonwealth Avenue, UP Ayala Land Technohub, Quezon City, 1121";

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public String getMarkedLocation() {
        return MarkedLocation;
    }

    public void setMarkedLocation(String markedLocation) {
        MarkedLocation = markedLocation;
    }

    public Location getCurrentLocation(){
        return this;
    }
}
