package com.example.cs2340.marta;

import java.util.List;

public class busSample extends Sample {
    private String type = "Bus";
    private int ID;
    private int Route;
    private int Location;
    private int Riders;
    private int Capacity;
    private int Speed;
    private List<routeSample> routesamplelist;
    private routeSample theroute;
    private stopSample current;
    private stopSample next;



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

    public List<routeSample> getRoutesamplelist() { return routesamplelist; }

    public void setRoutesamplelist(List<routeSample> routesamplelist) { this.routesamplelist = routesamplelist; }

    public routeSample getTheroute() { return theroute; }

    public void setTheroute(routeSample theroute) { this.theroute = theroute; }

    public stopSample getCurrent() { return current; }

    public void setCurrent(stopSample current) { this.current = current; }

    public stopSample getNext() { return next; }

    public void setNext(stopSample next) { this.next = next; }

    @Override
    public String toString() {
        if (theroute != null) {
            return  theroute.toString()+ "\n"+
                    "Type: " + type +  "\n" +
                    "ID: " + ID + "\n" +
                    "Route: " + Route + "\n" +
                    "Current stop: " + current + "\n" +
                    //"Next stop: " + next + "\n" +
                    "Riders: " + Riders + "\n" +
                    "Capacity: " + Capacity + "\n" +
                    "Speed: " + Speed;
        } else {
            return "Type: " + type +  "\n" +
                    "ID: " + ID + "\n" +
                    "Route: " + Route + "\n" +
                    "Current stop: " + current + "\n" +
                    //"Next stop: " + next + "\n" +
                    "Riders: " + Riders + "\n" +
                    "Capacity: " + Capacity + "\n" +
                    "Speed: " + Speed;
        }

    }
}
