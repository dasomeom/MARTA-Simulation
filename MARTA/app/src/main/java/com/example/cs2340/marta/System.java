package com.example.cs2340.marta;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class System extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogout;
    private Button buttonSimulation;
    private SampleAdapter adapter;
    private ListView lv;
    private List<Sample> samples = new ArrayList<>();
    private List<busSample> buslist = new ArrayList<>();
    private List<routeSample> routelist = new ArrayList<>();
    private List<stopSample> stoplist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        buttonLogout= (Button) findViewById(R.id.mslogout);
        buttonLogout.setOnClickListener(this);
        buttonSimulation= (Button) findViewById(R.id.simulation);
        buttonSimulation.setOnClickListener(this);


        readBusData();
        readRouteData();
        readStopData();
        for (routeSample route : routelist) {
            route.setStopsamplelist(stoplist);
            for (int i = 0; i < route.getStopdata().size(); i++) {
                for (stopSample astop : stoplist) {
                    if (route.getStopdata().get(i) == astop.getID()) {
                        route.getStoplist().add(astop);
                        route.getStops().add(astop); }
                }
            }
        }
        for (busSample bus : buslist) {
            for (routeSample aroute : routelist) {
                if (aroute.getID() == bus.getRoute()) {
                    bus.setTheroute(aroute);
                }
            }
        }
        lv = (ListView)findViewById(R.id.listview);

        adapter = new SampleAdapter(this, R.layout.tvlayout, samples);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sample aasample = samples.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("aaSample", (Serializable) aasample);
                if (aasample.getType().equals("bus")) {
                    Intent intlista = new Intent (view.getContext(), listbus.class);
                    intlista.putExtras(bundle);
                    startActivity(intlista);
                } else {
                    Intent intlist = new Intent(view.getContext(), list.class);
                    intlist.putExtras(bundle);
                    startActivity(intlist);
                }
            }
        });
    }



    public void onClick(View v) {
        if (v == buttonLogout) {
            Intent intLogout = new Intent(this, Main.class);
            startActivity(intLogout);
        }
        if (v == buttonSimulation) {
            Bundle bundleBus = new Bundle();
            bundleBus.putSerializable("busList", (Serializable) buslist);
            Intent intSimulation = new Intent(this, Simulation.class);
            intSimulation.putExtras(bundleBus);
            startActivity(intSimulation);
        }
    }





    private void readBusData() {

        InputStream is = getResources().openRawResource(R.raw.busdata);
        // Reads text from character-input stream, buffering characters for efficient reading
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        // Initialization
        String line = "";

        // Initialization
        try {
            // Step over headers
            reader.readLine();

            // If buffer is not empty
            while ((line = reader.readLine()) != null) {
                Log.d("System ","Line: " + line);
                // use comma as separator columns of CSV
                String[] tokens = line.split(",");
                // Read the data
                busSample sample = new busSample();

                // Setters
                sample.setType(tokens[0]);
                sample.setID(Integer.parseInt(tokens[1]));
                sample.setRoute(Integer.parseInt(tokens[2]));
                sample.setLocation(Integer.parseInt(tokens[3]));
                sample.setRiders(Integer.parseInt(tokens[4]));
                sample.setCapacity(Integer.parseInt(tokens[5]));
                sample.setSpeed(Integer.parseInt(tokens[6]));

                // Adding object to a class
                samples.add(sample);
                buslist.add(sample);
            }
        } catch (IOException e) {
            // Logs error with priority level
            Log.wtf("System", "Error reading data file on line" + line, e);

            // Prints throwable details
            e.printStackTrace();
        }
    }

    private void readRouteData() {
        InputStream is = getResources().openRawResource(R.raw.routedata);
        // Reads text from character-input stream, buffering characters for efficient reading
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        // Initialization
        String line = "";

        // Initialization
        try {
            // Step over headers
            reader.readLine();

            // If buffer is not empty
            while ((line = reader.readLine()) != null) {
                // use comma as separator columns of CSV
                String[] tokens = line.split(",");
                // Read the data
                routeSample sample = new routeSample();

                // Setters
                sample.setType(tokens[0]);
                sample.setID(Integer.parseInt(tokens[1]));
                sample.setIndex(Integer.parseInt(tokens[2]));
                sample.setName(tokens[3]);
                sample.getStopdata().add(Integer.parseInt(tokens[4]));
                sample.getStopdata().add(Integer.parseInt(tokens[5]));
                sample.getStopdata().add(Integer.parseInt(tokens[6]));
                sample.getStopdata().add(Integer.parseInt(tokens[7]));
                sample.getStopdata().add(Integer.parseInt(tokens[8]));
                sample.getStopdata().add(Integer.parseInt(tokens[9]));
                sample.getStopdata().add(Integer.parseInt(tokens[10]));
                sample.getStopdata().add(Integer.parseInt(tokens[11]));
                sample.getStopdata().add(Integer.parseInt(tokens[12]));
                sample.getStopdata().add(Integer.parseInt(tokens[13]));
                samples.add(sample);
                routelist.add(sample);
            }
        } catch (IOException e) {
            // Logs error with priority level
            Log.wtf("System", "Error reading data file on line" + line, e);

            // Prints throwable details
            e.printStackTrace();
        }

    }

    private void readStopData() {

        InputStream is = getResources().openRawResource(R.raw.stopdata);

        // Reads text from character-input stream, buffering characters for efficient reading
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        // Initialization
        String line = "";

        // Initialization
        try {
            // Step over headers
            reader.readLine();

            // If buffer is not empty
            while ((line = reader.readLine()) != null) {
                // use comma as separator columns of CSV
                String[] tokens = line.split(",");
                // Read the data
                stopSample sample = new stopSample();

                // Setters
                sample.setType(tokens[0]);
                sample.setID(Integer.parseInt(tokens[1]));
                sample.setName((tokens[2]));
                sample.setRiders(Integer.parseInt(tokens[3]));
                sample.setLatitude(Double.parseDouble(tokens[4]));
                sample.setLongitude(Double.parseDouble(tokens[5]));
                // Adding object to a class
                samples.add(sample);
                stoplist.add(sample);
            }


        } catch (IOException e) {
            // Logs error with priority level
            Log.wtf("System", "Error reading data file on line" + line, e);

            // Prints throwable details
            e.printStackTrace();
        }

    }





}



