package com.example.cs2340.marta;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class System extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogout;
    private SampleAdapter adapter;
    private ListView lv;
    private List<Sample> lsam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);
        buttonLogout= (Button) findViewById(R.id.mslogout);
        buttonLogout.setOnClickListener(this);
        readBusData();
        readRouteData();
        readStopData();

        lv = (ListView)findViewById(R.id.listview);

        adapter = new SampleAdapter(this, R.layout.tvlayout, samples);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intlist = new Intent (view.getContext(), list.class);
                intlist.putExtra("Sample", samples.get(position).toString());
                startActivity(intlist);
            }
        });

    }


    public void onClick(View v) {
        if (v == buttonLogout) {
            Intent intLogout = new Intent(this, Main.class);
            startActivity(intLogout);
        }
    }


    private List<Sample> samples = new ArrayList<>();
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
                sample.setID(Integer.parseInt(tokens[0]));
                sample.setRoute(Integer.parseInt(tokens[1]));
                sample.setLocation(Integer.parseInt(tokens[2]));
                sample.setRiders(Integer.parseInt(tokens[3]));
                sample.setCapacity(Integer.parseInt(tokens[4]));
                sample.setSpeed(Integer.parseInt(tokens[5]));

                // Adding object to a class
                samples.add(sample);

                // Log the object
                Log.d("System", "Just created: " + sample);
            }

        } catch (IOException e) {

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
                Log.d("System ","Line: " + line);
                // use comma as separator columns of CSV
                String[] tokens = line.split(",");
                // Read the data
                routeSample sample = new routeSample();

                // Setters
                sample.setID(Integer.parseInt(tokens[0]));
                sample.setIndex(Integer.parseInt(tokens[1]));
                sample.setName(tokens[2]);
                sample.setStop0(Integer.parseInt(tokens[3]));
                sample.setStop1(Integer.parseInt(tokens[4]));
                sample.setStop2(Integer.parseInt(tokens[5]));
                sample.setStop3(Integer.parseInt(tokens[6]));
                sample.setStop4(Integer.parseInt(tokens[7]));
                sample.setStop5(Integer.parseInt(tokens[8]));
                sample.setStop6(Integer.parseInt(tokens[9]));
                sample.setStop7(Integer.parseInt(tokens[10]));
                sample.setStop8(Integer.parseInt(tokens[11]));
                sample.setStop9(Integer.parseInt(tokens[12]));


                // Adding object to a class
                samples.add(sample);

                // Log the object
                Log.d("System", "Just created: " + sample);
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
                Log.d("System ","Line: " + line);
                // use comma as separator columns of CSV
                String[] tokens = line.split(",");
                // Read the data
                stopSample sample = new stopSample();

                // Setters
                sample.setID(Integer.parseInt(tokens[0]));
                sample.setName((tokens[1]));
                sample.setRiders(Integer.parseInt(tokens[2]));
                sample.setLatitude(Double.parseDouble(tokens[3]));
                sample.setLongitude(Double.parseDouble(tokens[4]));
                // Adding object to a class
                samples.add(sample);

                // Log the object
                Log.d("System", "Just created: " + sample);
            }

        } catch (IOException e) {
            // Logs error with priority level
            Log.wtf("System", "Error reading data file on line" + line, e);

            // Prints throwable details
            e.printStackTrace();
        }

    }
}
