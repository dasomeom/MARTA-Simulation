package com.example.cs2340.marta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.util.Queue;

public class routeSample extends Sample {
    private String type = "Route";
    private int ID;
    private int Index;
    private String Name;
    private List<stopSample> stopsamplelist;
    private ArrayList<Integer> stopdata = new ArrayList<>();
    private ArrayList<stopSample> stoplist = new ArrayList<>();

    public ArrayList<stopSample> getStoplist() { return stoplist; }

    public void setStopdata(ArrayList<Integer> stopdata) { this.stopdata = stopdata; }

    public ArrayList<Integer> getStopdata() { return stopdata; }

    private Queue<stopSample> stops = new LinkedList<>();

    public Queue<stopSample> getStops() { return stops; }

    public String getType() { return type; }

    public int getID() { return ID; }

    public void setID(int ID) { this.ID = ID; }

    public int getIndex() { return Index; }

    public void setIndex(int index) { Index = index; }

    public String getName() { return Name; }

    public void setName(String name) { Name = name; }

    public List<stopSample> getStopsamplelist() { return stopsamplelist; }

    public void setStopsamplelist(List<stopSample> stopsamplelist) { this.stopsamplelist = stopsamplelist; }

    @Override
    public String toString() {
            return "Type: " + type + "\n" +
                    "ID: " + ID + "\n" +
                    "Index: " + Index + "\n" +
                    "Name: " + Name + "\n" +
                    stopdata + "\n" +
                    stoplist;

    }
}
