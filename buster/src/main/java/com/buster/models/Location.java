package com.buster.models;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Created by Ramon on 5/12/2018.
 */
@Embeddable
public class Location {

    @NotNull
    public double latitude = 14.661194;

    @NotNull
    public double longitude = 121.062024;

    @NotNull
    public String markedLocation = "BLDG O, UP Technohub, Commonwealth Avenue, UP Ayala Land Technohub, Quezon City, 1121";

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMarkedLocation() {
        return markedLocation;
    }

    public void setMarkedLocation(String markedLocation) {
        this.markedLocation = markedLocation;
    }

    public Location getCurrentLocation(){
        return this;
    }
}
