package com.example.myapp2p23pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido;
    Button btnMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Datos" + nombre.getText().toString()+" "+ apellido.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}