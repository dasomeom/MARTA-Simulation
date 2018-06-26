package com.example.cs2340.marta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        Bundle recdData = getIntent().getExtras();
        String myVal = recdData.getString("Sample");
        TextView textView = (TextView)findViewById(R.id.details);
        textView.setText(myVal);

    }






    public void onClick(View v) {
        if (v == buttontolist) {
            Intent intLogout = new Intent(this, System.class);
            startActivity(intLogout);
        }
    }
}
