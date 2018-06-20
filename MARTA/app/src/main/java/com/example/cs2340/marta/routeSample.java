package com.example.cs2340.marta;

public class routeSample extends Sample {
    private String type = "Route";
    private int ID;
    private int Index;
    private String Name;
    private int Stop0;
    private int Stop1;
    private int Stop2;
    private int Stop3;
    private int Stop4;
    private int Stop5;
    private int Stop6;
    private int Stop7;
    private int Stop8;
    private int Stop9;

    public String getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getStop0() {
        return Stop0;
    }

    public void setStop0(int stop0) {
        Stop0 = stop0;
    }

    public int getStop1() {
        return Stop1;
    }

    public void setStop1(int stop1) {
        Stop1 = stop1;
    }

    public int getStop2() {
        return Stop2;
    }

    public void setStop2(int stop2) {
        Stop2 = stop2;
    }

    public int getStop3() {
        return Stop3;
    }

    public void setStop3(int stop3) {
        Stop3 = stop3;
    }

    public int getStop4() {
        return Stop4;
    }

    public void setStop4(int stop4) {
        Stop4 = stop4;
    }

    public int getStop5() {
        return Stop5;
    }

    public void setStop5(int stop5) {
        Stop5 = stop5;
    }

    public int getStop6() {
        return Stop6;
    }

    public void setStop6(int stop6) {
        Stop6 = stop6;
    }

    public int getStop7() {
        return Stop7;
    }

    public void setStop7(int stop7) {
        Stop7 = stop7;
    }

    public int getStop8() {
        return Stop8;
    }

    public void setStop8(int stop8) {
        Stop8 = stop8;
    }

    public int getStop9() {
        return Stop9;
    }

    public void setStop9(int stop9) {
        Stop9 = stop9;
    }

    @Override
    public String toString() {
        return "Type = " + type + "\n" +
                "ID = " + ID + "\n" +
                "Index = " + Index + "\n" +
                "Name = " + Name + "\n" +
                "Stop0 = " + Stop0 + "\n" +
                "Stop1 = " + Stop1 + "\n" +
                "Stop2 = " + Stop2 + "\n" +
                "Stop3 = " + Stop3 + "\n" +
                "Stop4 = " + Stop4 + "\n" +
                "Stop5 = " + Stop5 + "\n" +
                "Stop6 = " + Stop6 + "\n" +
                "Stop7 = " + Stop7 + "\n" +
                "Stop8 = " + Stop8 + "\n" +
                "Stop9 = " + Stop9 + "\n";
    }
}
