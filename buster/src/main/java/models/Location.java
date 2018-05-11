package models;

/**
 * Created by jdulay on 5/12/2018.
 */
public class Location {
    public double Latitude = 14.661194;
    public double Longitude = 121.062024;
    public String MarkedLocation = "BLDG O, UP Technohub, Commonwealth Avenue, UP Ayala Land Technohub, Quezon City, 1121";
    public Location(){

    }

    public Location getCurrentLocation(){
        return this;
    }
}
