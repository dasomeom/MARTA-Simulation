package com.example.cs2340.marta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister2;
    private TextView btMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        buttonRegister2 = (Button) findViewById(R.id.btRegister);
        buttonRegister2.setOnClickListener(this);
        btMain = (TextView) findViewById(R.id.backmain);
        btMain.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == buttonRegister2) {
            Intent intLogout = new Intent(this, System.class);
            startActivity(intLogout);
        }

        if (v== btMain) {
            Intent intbtMain = new Intent(this, Main.class);
            startActivity(intbtMain);
        }
    }

}
