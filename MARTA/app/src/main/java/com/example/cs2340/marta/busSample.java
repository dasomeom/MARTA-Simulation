package com.example.cs2340.marta;

public class busSample extends Sample {
    private String type = "Bus";
    private int ID;
    private int Route;
    private int Location;
    private int Riders;
    private int Capacity;
    private int Speed;

    public String getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRoute() {
        return Route;
    }

    public void setRoute(int route) {
        Route = route;
    }

    public int getLocation() {
        return Location;
    }

    public void setLocation(int location) {
        Location = location;
    }

    public int getRiders() {
        return Riders;
    }

    public void setRiders(int riders) {
        Riders = riders;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }


    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", ID=" + ID +
                ", Route=" + Route +
                ", Location=" + Location +
                ", Riders=" + Riders +
                ", Capacity=" + Capacity +
                ", Speed=" + Speed +
                '}';
    }
}
