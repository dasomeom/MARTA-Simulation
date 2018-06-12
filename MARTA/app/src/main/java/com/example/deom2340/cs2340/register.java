package com.example.deom2340.cs2340;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class register extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        buttonRegister2 = (Button) findViewById(R.id.btRegister);
        buttonRegister2.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == buttonRegister2) {
            Intent intLogout = new Intent(this, MainSystem.class);
            startActivity(intLogout);
        }
    }

}
