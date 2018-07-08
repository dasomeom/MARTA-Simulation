package com.example.cs2340.marta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Simulation extends AppCompatActivity implements View.OnClickListener {


    private static final String KEY1 = "first";
    private static final String KEY2 = "second";

    private Button buttontolist;
    private Button refresh;
    private Button retrieve;
    private TextView textView;
    private TextView textNext;
    private List<busSample> busImport = new ArrayList<>();
    private busSample[] busSaved;
    private PriorityQueue<busSample> buses = new PriorityQueue<>();
    private busSample aBus;
    private String tempString;
    private String tempNext;
    private String main;
    private String sub;
    final DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext(), "test1.db", null, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        buttontolist = (Button) findViewById(R.id.sim_List);
        buttontolist.setOnClickListener(this);
        refresh = (Button) findViewById(R.id.sim_Refresh);
        refresh.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        textView = (TextView)findViewById(R.id.simView);
        textNext = (TextView)findViewById(R.id.simNext);
        textNext.setMovementMethod(new ScrollingMovementMethod());
        textView.setMovementMethod(new ScrollingMovementMethod());

        Log.d("tag", "this is oncreate message" + getIntent().getExtras().getString("MainString"));
        if (savedInstanceState != null) {
            Log.d("tag", "this is inside message");
            tempString = getIntent().getExtras().getString(KEY1);
            sub = getIntent().getExtras().getString(KEY2);
            textView.setText(tempString);
            textNext.setText(sub);
            //Object[] ahabus = (Object[]) savedInstanceState.getSerializable("savedlist");
            //for (int i = 0; i < ahabus.length; i++) {
            //    buses.add((busSample)ahabus[i]);

        } else if(getIntent().getExtras().getSerializable("busList") != null) {
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
            aBus.setNewrider(aBus.getRiders() - aBus.exiting() + aBus.boarding());
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
            tempNext = "Bus #"+ex.getID()+" will arrive to "+ex.getNext().getName()+" in "+difTime+" mins";
            textNext.setText(tempNext);
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

        if (getIntent().getExtras().getString("MainString") != null) {
            String myBoolean = getIntent().getExtras().getString("MainString");
            //String myDouble = getIntent().getExtras().getString("SubString");
            textView = (TextView)findViewById(R.id.simView);
            textView.setMovementMethod(new ScrollingMovementMethod());
            textNext = (TextView)findViewById(R.id.simNext);
            textNext.setMovementMethod(new ScrollingMovementMethod());
            textView.setText(myBoolean);
            //textNext.setText(myDouble);
            //Object[] array = savedInstanceState.getSerializable("savedlist");

        }
        Log.i("@@@@@@@", "onResume execution" + getIntent().getExtras().getString("MainString"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Bundle bundle = new Bundle();
        bundle.putString("MainString", "ahahahahahahaha");
        getIntent().putExtras(bundle);
        Log.i("@@@@@@@", "onPause execution" + getIntent().getExtras().getString("MainString"));
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        //Object[] busSaved = buses.toArray();
        savedInstanceState.putString(KEY1, "lalalalala");
        savedInstanceState.putString(KEY2, "kkuiuuuku");
        //savedInstanceState.putSerializable("savedlist", busSaved);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String myBoolean = savedInstanceState.getString(KEY1);
        String myDouble = savedInstanceState.getString(KEY2);
        //Object[] array = savedInstanceState.getSerializable("savedlist");
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
            tempNext = "Bus #"+ex.getID()+" will arrive to "+ex.getNext().getName()+" in "+difTime+" mins";
            textNext.setText(tempNext);
        }
    }

}
