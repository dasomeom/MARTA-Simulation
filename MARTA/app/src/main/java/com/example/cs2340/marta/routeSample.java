package com.example.cs2340.marta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.util.Queue;

public class routeSample extends Sample {
    private int Index;
    private String Name;
    private List<stopSample> stopsamplelist;
    private ArrayList<Integer> stopdata = new ArrayList<>();
    private ArrayList<stopSample> stoplist = new ArrayList<>();
    private Queue<stopSample> stops = new LinkedList<>();


    public routeSample() {
    }

    public routeSample(String type, int ID, int index, String name, List<stopSample> stopsamplelist, ArrayList<Integer> stopdata, ArrayList<stopSample> stoplist, Queue<stopSample> stops) {
        super(type, ID);
        Index = index;
        Name = name;
        this.stopsamplelist = stopsamplelist;
        this.stopdata = stopdata;
        this.stoplist = stoplist;
        this.stops = stops;
    }

    public ArrayList<stopSample> getStoplist() { return stoplist; }

    public void setStopdata(ArrayList<Integer> stopdata) { this.stopdata = stopdata; }

    public ArrayList<Integer> getStopdata() { return stopdata; }

    public Queue<stopSample> getStops() { return stops; }


    public int getIndex() { return Index; }

    public void setIndex(int index) { Index = index; }

    public String getName() { return Name; }

    public void setName(String name) { Name = name; }

    public List<stopSample> getStopsamplelist() { return stopsamplelist; }

    public void setStopsamplelist(List<stopSample> stopsamplelist) { this.stopsamplelist = stopsamplelist; }

    @Override
    public String toString() {
            return this.getType()  +" #" + this.getID() + "\n" +
                    "Index: " + Index + "\n" +
                    "Name: " + Name + "\n" +
                    stopdata + "\n" +
                    stoplist;

    }
}
