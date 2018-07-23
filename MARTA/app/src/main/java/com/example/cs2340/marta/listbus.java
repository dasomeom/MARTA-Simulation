package com.example.cs2340.marta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class listbus extends AppCompatActivity implements View.OnClickListener {
    private Button buttontolist;
    private Button refresh;
    private Sample aasample;
    private busSample aaa;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbus);
        buttontolist = (Button) findViewById(R.id.backtolistbus);
        buttontolist.setOnClickListener(this);
        refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(this);
        //Bundle bundle = getIntent().getExtras();
        if(getIntent().getExtras().getSerializable("aaSample") != null) {
            aasample = (Sample) getIntent().getExtras().getSerializable("aaSample");
            aaa = (busSample) aasample;
            textView = (TextView)findViewById(R.id.busdetails);
            textView.setMovementMethod(new ScrollingMovementMethod());
            stopSample thisone = aaa.getTheroute().getStops().remove();
            aaa.getTheroute().getStops().add(thisone);
            aaa.setCurrent(thisone);
            aaa.setNext(aaa.getTheroute().getStops().peek());
            textView.setText(aaa.toString());
        }
        aaa.setRiders(aaa.getNewrider());
        aaa.setInitialTime(aaa.getOverallTime());
    }

    public void onClick(View v) {
        if (v == buttontolist) {
            Intent intLogout = new Intent(this, System.class);
            startActivity(intLogout);
        }
        if (v == refresh) {
            stopSample thisone = aaa.getTheroute().getStops().remove();
            aaa.getTheroute().getStops().add(thisone);
            aaa.setCurrent(thisone);
            aaa.setNext(aaa.getTheroute().getStops().peek());
            aaa.setNewrider(aaa.getRiders() - aaa.exiting() + aaa.boarding());
            textView.setText(aaa.toString());
        }
        aaa.setRiders(aaa.getNewrider());
        aaa.setInitialTime(aaa.getOverallTime());

    }
}
