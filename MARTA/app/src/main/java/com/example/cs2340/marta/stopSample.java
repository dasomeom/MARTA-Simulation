package com.example.cs2340.marta;

public class stopSample extends Sample {
    private String type = "STOP";
    private int ID;
    private String Name;
    private int Riders;
    private double Latitude;
    private double Longitude;



    public String getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRiders() {
        return Riders;
    }

    public void setRiders(int riders) {
        Riders = riders;
    }

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


    @Override
    public String toString() {
        return "Type: " + type + "\n" +
                "ID: " + ID + "\n" +
                "Name: " + Name + "\n" +
                "Riders: " + Riders + "\n" +
                "Latitude: " + Latitude + "\n" +
                "Longitude: " + Longitude;
    }
}
