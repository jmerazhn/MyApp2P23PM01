package com.example.myapp2p23pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMenu extends AppCompatActivity {


    private Button btnCrear, btnList, btnCombo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCrear = (Button) findViewById(R.id.btnCrear);
        btnList = (Button) findViewById(R.id.btnList);
        btnCombo = (Button) findViewById(R.id.btnCombo);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityCrear.class);
                startActivity(intent);
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(intent);
            }
        });

        btnCombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityCombo.class);
                startActivity(intent);
            }
        });
    }
}