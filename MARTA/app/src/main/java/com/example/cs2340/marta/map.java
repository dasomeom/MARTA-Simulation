package com.example.cs2340.marta;

import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;

public class map extends AppCompatActivity implements View.OnClickListener {

    private Button buttontolist, refresh, restart;
    private float width;
    private float height;

    private ImageView b7;
    private ImageView b11;
    private ImageView b18;
    private ImageView Stop0;
    private ImageView Stop1;
    private ImageView Stop2;
    private ImageView Stop3;
    private ImageView Stop4;
    private ImageView Stop5;
    private ImageView Stop6;
    private ImageView Stop7;
    private ImageView Stop8;
    private ImageView Stop9;
    private ImageView Stop10;
    private float up;
    private float down;
    private float right;
    private float left;
    private List<busSample> busMap = new ArrayList<>();
    private List<stopSample> stopMap = new ArrayList<>();
    private List<ImageView> stops = new ArrayList<>();
    private List<ImageView> busss = new ArrayList<>();
    private Map<ImageView, stopSample> stopList = new HashMap<>();
    private PriorityQueue<busSample> buses = new PriorityQueue<>();
    private Handler handler = new Handler();
    private Timer timer = new Timer();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        buttontolist = (Button) findViewById(R.id.mapTolist);
        buttontolist.setOnClickListener(this);
        refresh = (Button) findViewById(R.id.mapNext);
        refresh.setOnClickListener(this);
        restart = (Button) findViewById(R.id.mapRestart);
        restart.setOnClickListener(this);
        b7 = (ImageView) findViewById(R.id.blueBus);
        b11 = (ImageView) findViewById(R.id.redBus);
        b18 = (ImageView) findViewById(R.id.greenBus);
        Stop0 = (ImageView) findViewById(R.id.stop0);
        Stop1 = (ImageView) findViewById(R.id.stop1);
        Stop2 = (ImageView) findViewById(R.id.stop2);
        Stop3 = (ImageView) findViewById(R.id.stop3);
        Stop4 = (ImageView) findViewById(R.id.stop4);
        Stop5 = (ImageView) findViewById(R.id.stop5);
        Stop6 = (ImageView) findViewById(R.id.stop6);
        Stop7 = (ImageView) findViewById(R.id.stop7);
        Stop8 = (ImageView) findViewById(R.id.stop8);
        Stop9 = (ImageView) findViewById(R.id.stop9);
        Stop10 = (ImageView) findViewById(R.id.stop10);
        stops.add(Stop0);
        stops.add(Stop1);
        stops.add(Stop2);
        stops.add(Stop3);
        stops.add(Stop4);
        stops.add(Stop5);
        stops.add(Stop6);
        stops.add(Stop7);
        stops.add(Stop8);
        stops.add(Stop9);
        stops.add(Stop10);
        busss.add(b7);
        busss.add(b11);
        busss.add(b18);



        //get screen size
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        width = (float) size.x;
        height = (float) size.y;
        Log.d("log", "ahhhh" + (getIntent().getExtras().getSerializable("busList") != null));
        if (getIntent().getExtras().getSerializable("busList") != null
                && getIntent().getExtras().getSerializable("stopList") != null) {
            busMap = (ArrayList<busSample>) getIntent().getExtras().getSerializable("busList");
            stopMap = (ArrayList<stopSample>) getIntent().getExtras().getSerializable("stopList");
            for (int i = 0; i < stopMap.size(); i++) {
                stops.get(i).setX((float) (((stopMap.get(i).getLatitude() - 0.5) / .2) * width));
                stops.get(i).setY((float) (((stopMap.get(i).getLongitude() - 0.5) / .25) * height));
                stopList.put(stops.get(i), stopMap.get(i));
            }

            for (busSample bus : busMap) {
                stopSample thisone = bus.getTheroute().getStops().remove();
                bus.getTheroute().getStops().add(thisone);
                bus.setCurrent(thisone);
                bus.setNext(bus.getTheroute().getStops().peek());
                bus.setInitialTime(0);
                buses.add(bus);
            }
            busSample aBus = buses.remove();
            aBus.setNewrider(0 - aBus.exiting() + aBus.boarding());
            if (aBus.getID() == 7) {
                b7.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width) - 50);
                b7.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            } else if (aBus.getID() == 11) {
                b11.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width) + 50);
                b11.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            } else {
                b18.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width));
                b18.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            }
            aBus.setRiders(aBus.getNewrider());
            aBus.setInitialTime(aBus.getOverallTime());
            stopSample newOne = aBus.getTheroute().getStops().remove();
            aBus.getTheroute().getStops().add(newOne);
            aBus.setCurrent(newOne);
            aBus.setNext(aBus.getTheroute().getStops().peek());
            buses.add(aBus);
            busSample ex = buses.peek();
            //int difTime = ex.getOverallTime() - aBus.getInitialTime();
        }
    }






    public void onClick(View v) {
        if (v == buttontolist) {
            Intent intLogout = new Intent(this, System.class);
            startActivity(intLogout);
        }
        if (v == refresh) {
            busSample aBus = buses.remove();
            aBus.setNewrider(aBus.getRiders() - aBus.exiting() + aBus.boarding());
            if (aBus.getID() == 7) {
                b7.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width) - 50);
                b7.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            } else if (aBus.getID() == 11) {
                b11.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width) + 50);
                b11.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            } else {
                b18.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width));
                b18.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            }
            aBus.setInitialTime(aBus.getOverallTime());
            stopSample newOne = aBus.getTheroute().getStops().remove();
            aBus.getTheroute().getStops().add(newOne);
            aBus.setCurrent(newOne);
            aBus.setNext(aBus.getTheroute().getStops().peek());
            aBus.setRiders(aBus.getNewrider());
            buses.add(aBus);
            busSample ex = buses.peek();
            int difTime = ex.getOverallTime() - aBus.getInitialTime();

        }
        if (v == restart) {
            buses = new PriorityQueue<>();
            busMap = (ArrayList<busSample>) getIntent().getExtras().getSerializable("busList");
            for (busSample bus : busMap) {
                stopSample thisone = bus.getTheroute().getStops().remove();
                bus.getTheroute().getStops().add(thisone);
                bus.setCurrent(thisone);
                bus.setNext(bus.getTheroute().getStops().peek());
                bus.setInitialTime(0);
                buses.add(bus);
            }
            busSample aBus = buses.remove();
            aBus.setNewrider(0 - aBus.exiting() + aBus.boarding());
            if (aBus.getID() == 7) {
                b7.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width) - 50);
                b7.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            } else if (aBus.getID() == 11) {
                b11.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width) + 50);
                b11.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            } else {
                b18.setX((float) (((aBus.getCurrent().getLatitude() - 0.5) / .2) * width));
                b18.setY((float) (((aBus.getCurrent().getLongitude() - 0.5) / .25) * height) + 50);
            }
            aBus.setRiders(aBus.getNewrider());
            aBus.setInitialTime(aBus.getOverallTime());
            stopSample newOne = aBus.getTheroute().getStops().remove();
            aBus.getTheroute().getStops().add(newOne);
            aBus.setCurrent(newOne);
            aBus.setNext(aBus.getTheroute().getStops().peek());
            buses.add(aBus);
            busSample ex = buses.peek();
        }
    }
}
