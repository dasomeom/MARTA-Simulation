package com.example.cs2340.marta;


import java.io.Serializable;
import java.util.List;

class Sample implements Serializable {
    private String type;
    private int ID;
    private int Route;
    private int Location;
    private int Riders;
    private int Capacity;
    private int Speed;
    private int Index;
    private String Name;
    private double Latitude;
    private double Longitude;
    private List<routeSample> routesamplelist;
    private routeSample theroute;
    private stopSample current;
    private stopSample next;

    public List<routeSample> getRoutesamplelist() { return routesamplelist; }

    public routeSample getTheroute() { return theroute; }

    public void setTheroute(routeSample theroute) { this.theroute = theroute; }

    public stopSample getCurrent() { return current; }

    public void setCurrent(stopSample current) { this.current = current; }

    public stopSample getNext() { return next; }

    public void setNext(stopSample next) { this.next = next; }

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

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
}
