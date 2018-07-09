package com.example.cs2340.marta;


import java.io.Serializable;
import java.util.List;

class Sample implements Serializable {
    private String type;
    private int ID;

    public Sample() {

    }

    public Sample(String type, int ID) {
        this.type = type;
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "type='" + type + '\'' +
                ", ID=" + ID +
                '}';
    }
}
