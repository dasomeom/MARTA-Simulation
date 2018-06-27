package com.example.cs2340.marta;

import java.text.NumberFormat;
import java.util.List;
import java.util.Random;


public class busSample extends Sample {
    Random rand = new Random();
    NumberFormat nf = NumberFormat.getInstance();
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
    private double distance;
    private double time;
    //int randomNum = rand.nextInt((max - min) + 1) + min;
    private int exiting = rand.nextInt(4) + 2;
    private int boarding = rand.nextInt(10 - Riders);



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
        return Riders - exiting + boarding;
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

    public double getDistance() {
        double distanceConversion = 70.0D;
        return Double.valueOf(70.0D * Math.sqrt(Math.pow(current.getLatitude()
                - next.getLatitude(), 2.0D) + Math.pow(current.getLongitude()
                - next.getLongitude(), 2.0D)));
    }
    public double getTime() {
        return Speed * getDistance();
    }

    @Override
    public String toString() {
        if (theroute != null && current != null) {
            return "Type: " + type +  "\n" +
                    "ID: " + ID + "\n" +
                    "Route: " + Route + "\n" +
                    "Current stop: " + current.getName() + "\n" +
                    "Next stop: " + next.getName() + "\n" +
                    "Distance: " + nf.format(getDistance()) + "\n" +
                    "Time to the next stop: " + nf.format(getTime()) + "\n" +
                    "Exiting passangers: " + exiting + "\n" +
                    "Boarding passangers: " + boarding + "\n" +
                    "Riders: " + getRiders() + "\n" +
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
