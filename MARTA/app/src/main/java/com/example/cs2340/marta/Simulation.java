package com.example.cs2340.marta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Simulation extends AppCompatActivity implements View.OnClickListener {



    private Button buttontolist, refresh, restart;
    private TextView textView;
    private TextView textNext;
    private List<busSample> busImport = new ArrayList<>();
    private List<busSample> busretrieve;
    private PriorityQueue<busSample> buses = new PriorityQueue<>();
    private PriorityQueue<busSample> resumeBuses = new PriorityQueue<>();
    private PriorityQueue<busSample> newBuses = new PriorityQueue<>();
    private String newBus;
    private String nextBus;
    private String tempString;
    private String tempNext;
    private boolean newStart = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        buttontolist = (Button) findViewById(R.id.sim_List);
        buttontolist.setOnClickListener(this);
        restart = (Button) findViewById(R.id.sim_restart);
        restart.setOnClickListener(this);
        refresh = (Button) findViewById(R.id.sim_Refresh);
        refresh.setOnClickListener(this);
        textView = (TextView)findViewById(R.id.simView);
        textNext = (TextView)findViewById(R.id.simNext);
        textNext.setMovementMethod(new ScrollingMovementMethod());
        textView.setMovementMethod(new ScrollingMovementMethod());

        Log.d("tag", "this is oncreate message");
        if(getIntent().getExtras().getSerializable("busList") != null) {
            busImport = (ArrayList<busSample>) getIntent().getExtras().getSerializable("busList");

            for (busSample bus : busImport) {
                stopSample thisone = bus.getTheroute().getStops().remove();
                bus.getTheroute().getStops().add(thisone);
                bus.setCurrent(thisone);
                bus.setNext(bus.getTheroute().getStops().peek());
                bus.setInitialTime(0);
                buses.add(bus);
            }
            busSample aBus = buses.remove();
            aBus.setNewrider(0 - aBus.exiting() + aBus.boarding());
            tempString = aBus.toString();
            textView.setText(tempString);
            aBus.setRiders(aBus.getNewrider());
            aBus.setInitialTime(aBus.getOverallTime());
            stopSample newOne = aBus.getTheroute().getStops().remove();
            aBus.getTheroute().getStops().add(newOne);
            aBus.setCurrent(newOne);
            aBus.setNext(aBus.getTheroute().getStops().peek());
            buses.add(aBus);
            busSample ex = buses.peek();
            int difTime = ex.getOverallTime() - aBus.getInitialTime();
            tempNext = "Bus #"+ex.getID()+" will arrive to "+ex.getCurrent().getName()+" in "+difTime+" mins";
            textNext.setText(tempNext);
            newBus = tempString;
            nextBus = tempNext;
            if (newBuses == null) {
                newBuses = buses;
                newStart = true;
            }
            if (resumeBuses != null) {
                buses = resumeBuses;
            }
        }

    }
    @Override
    protected void onStart() {
        super.onStart();  // Always call the superclass method first

        Log.i("@@@@@@@", "onStart execution");
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences pref = getSharedPreferences("my_shared_preferences", MODE_PRIVATE);
        String tempS = pref.getString("key1", "");
        String tempN = pref.getString("key2", "");
        Gson gson = new Gson();
        String json = pref.getString("key3", null);
        Type type = new TypeToken<List<busSample>>(){}.getType();
        busretrieve = gson.fromJson(json, type);
        if (busretrieve == null) {
            busretrieve = new ArrayList<>();
        }
        for (busSample bus : busretrieve) {
            resumeBuses.add(bus);
        }
        textView.setText(tempS);
        textNext.setText(tempN);

        Log.i("@@@@@@@", "onResume execution");
    }

    @Override
    protected void onPause() {
        super.onPause();
        List<busSample> busretrieve= new ArrayList<busSample>();
        while (!buses.isEmpty()) {
            busretrieve.add(buses.remove());
        }
        SharedPreferences pref=getSharedPreferences("my_shared_preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("key1",tempString);
        editor.putString("key2",tempNext);
        Gson gson = new Gson();
        String json = gson.toJson(busretrieve);
        editor.putString("key3", json);
        editor.apply();




        Log.i("@@@@@@@", "onPause execution");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("@@@@@@@", "onStop execution");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("@@@@@@@", "onDestroy execution");
    }




    public void onClick(View v) {
        if (v == buttontolist) {
            Intent intLogout = new Intent(this, System.class);
            startActivity(intLogout);
        }
        if (v == refresh) {
            busSample aBus = buses.remove();
            aBus.setNewrider(aBus.getRiders() - aBus.exiting() + aBus.boarding());
            tempString = aBus.toString();
            textView.setText(tempString);
            aBus.setInitialTime(aBus.getOverallTime());
            stopSample newOne = aBus.getTheroute().getStops().remove();
            aBus.getTheroute().getStops().add(newOne);
            aBus.setCurrent(newOne);
            aBus.setNext(aBus.getTheroute().getStops().peek());
            aBus.setRiders(aBus.getNewrider());
            buses.add(aBus);
            busSample ex = buses.peek();
            int difTime = ex.getOverallTime() - aBus.getInitialTime();
            tempNext = "Bus #" + ex.getID() + " will arrive to " + ex.getCurrent().getName() + " in " + difTime + " mins";
            textNext.setText(tempNext);

        }
        if (v == restart) {
            buses = new PriorityQueue<>();
            busImport = (ArrayList<busSample>) getIntent().getExtras().getSerializable("busList");
            for (busSample bus : busImport) {
                stopSample thisone = bus.getTheroute().getStops().remove();
                bus.getTheroute().getStops().add(thisone);
                bus.setCurrent(thisone);
                bus.setNext(bus.getTheroute().getStops().peek());
                bus.setInitialTime(0);
                buses.add(bus);
            }


        }
    }

}
