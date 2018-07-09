package com.example.cs2340.marta;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class busSample extends Sample implements Comparable<busSample> {
    Random rand = new Random();
    //private String type = "Bus";
    //private int ID;
    private int Route;
    private int Location;
    private int Riders;
    private int Capacity;
    private int Speed;
    private routeSample theroute;
    private stopSample current;
    private stopSample next;
    private double distance;
    private int time;
    private int tempexit;
    private int tempboard;
    private int newrider;
    private int initialTime;
    private int overallTime;

    public busSample() {

    }
    public busSample(String type, int ID, Random rand, int route, int location, int riders, int capacity, int speed, routeSample theroute, stopSample current, stopSample next, double distance, int time, int tempexit, int tempboard, int newrider, int initialTime, int overallTime) {
        super(type, ID);
        this.rand = rand;
        Route = route;
        Location = location;
        Riders = riders;
        Capacity = capacity;
        Speed = speed;
        this.theroute = theroute;
        this.current = current;
        this.next = next;
        this.distance = distance;
        this.time = time;
        this.tempexit = tempexit;
        this.tempboard = tempboard;
        this.newrider = newrider;
        this.initialTime = initialTime;
        this.overallTime = overallTime;
    }

    //int randomNum = rand.nextInt((max - min) + 1) + min;

    //public int getID() { return ID; }

    //public void setID(int ID) { this.ID = ID; }

    public int getRoute() { return Route; }

    public void setRoute(int route) { Route = route; }

    public int getLocation() { return Location; }

    public void setLocation(int location) { Location = location; }

    public int getRiders() { return Riders; }

    public void setRiders(int riders) { Riders = riders; }

    public int exiting() {
        tempexit = rand.nextInt(4) + 2;
        if (tempexit >= Riders) {
            tempexit = Riders;
        }
        return tempexit;
    }

    public int boarding() {
        int available = Capacity - (Riders - tempexit);
        tempboard = rand.nextInt(11);
        if (tempboard > available) {
            tempboard = available;
        }
        return tempboard;
    }

    public int getNewrider() { return newrider; }

    public void setNewrider(int newrider) { this.newrider = newrider; }

    public int getCapacity() { return Capacity; }

    public void setCapacity(int capacity) { Capacity = capacity; }

    public int getSpeed() { return Speed; }

    public void setSpeed(int speed) { Speed = speed; }

    public routeSample getTheroute() { return theroute; }

    public void setTheroute(routeSample theroute) { this.theroute = theroute; }

    public stopSample getCurrent() { return current; }

    public void setCurrent(stopSample current) { this.current = current; }

    public stopSample getNext() { return next; }

    public void setNext(stopSample next) { this.next = next; }

    public int getInitialTime() { return initialTime; }

    public void setInitialTime(int initialTime) { this.initialTime = initialTime; }

    public int getOverallTime() { return this.initialTime + this.getTime(); }

    public void setOverallTime(int overallTime) { this.overallTime = overallTime; }

    public double getDistance() {
        final double distanceConversion = 70.0D;
        return (double) Math.round(Double.valueOf(distanceConversion * Math.sqrt(Math.pow(current.getLatitude()
                - next.getLatitude(), 2.0D) + Math.pow(current.getLongitude()
                - next.getLongitude(), 2.0D)))*1000)/1000.000;
    }
    public int getTime() { return (1 + (((int) getDistance() * 60) / Speed)); }

    public int compareTo(busSample compareBus) {
        if (getOverallTime() == compareBus.getOverallTime()) {
            if (this.getID() > compareBus.getID()) {
                return 1;
            } else if (this.getID() < compareBus.getID()) {
                return -1;
            }
        } else if (getOverallTime() > compareBus.getOverallTime()) {
            return 1;
        } else if (getOverallTime() < compareBus.getOverallTime()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        if (theroute != null && current != null) {
            return  "Overall Operation: " + getOverallTime() + " mins" + "\n" +
                    this.getType()  +" #" + this.getID() + " on Route " + Route + "\n" +
                    "Current stop: " + current.getName() + "\n" +
                    "Next stop: " + next.getName() + "\n" +
                    "Distance: " + getDistance() + " miles" + "\n" +
                    "Time to the next stop: " + getTime() + " mins" + "\n" +
                    "Previous rider: " + Riders + "\n" +
                    "Exiting: " + tempexit + " Boarding: " + tempboard + "\n" +
                    "Riders: " + newrider + "\n" +
                    "Capacity: " + Capacity + "\n" +
                    "Speed: " + Speed + " mph";
        } else {
            return "You got null result ~~~~ >_<";
        }

    }
}
