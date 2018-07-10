package com.example.cs2340.marta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class list extends AppCompatActivity implements View.OnClickListener {

    private Button buttontolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        buttontolist = (Button) findViewById(R.id.backtolist);
        buttontolist.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        if(getIntent().getExtras().getSerializable("aaSample") != null) {
            Sample aasample = (Sample) getIntent().getExtras().getSerializable("aaSample");
            TextView textView = (TextView)findViewById(R.id.details);
            textView.setMovementMethod(new ScrollingMovementMethod());
            if (aasample.getType().equals("Bus")) {
                busSample aaa = (busSample) aasample;
                stopSample thisone = aaa.getTheroute().getStops().remove();
                aaa.getTheroute().getStops().add(thisone);
                aaa.setCurrent(thisone);
                aaa.setNext(aaa.getTheroute().getStops().peek());
                textView.setText(aaa.toString());
            } else {
                textView.setText(aasample.toString());
            }

        }

    }
    public void onClick(View v) {
        if (v == buttontolist) {
            Intent intLogout = new Intent(this, System.class);
            startActivity(intLogout);
        }
    }
}
