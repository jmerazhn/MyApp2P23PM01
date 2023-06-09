package com.example.myapp2p23pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp2p23pm01.Configuracion.SQLiteConexion;
import com.example.myapp2p23pm01.Configuracion.Transacciones;

public class ActivityCrear extends AppCompatActivity {

    TextView nombres, apellidos, edad, correo;
    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        nombres = findViewById(R.id.nombres);
        apellidos = findViewById(R.id.apellidos);
        edad = findViewById(R.id.edad);
        correo = findViewById(R.id.correo);

        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPerson();
            }
        });

    }

    private void AddPerson() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores= new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());

        try {
            Long result = db.insert(Transacciones.TablaPersonas, Transacciones.id, valores);
            if(result!=-1){
                Toast.makeText(getApplicationContext(),"Registro insertado: "+result.toString(),Toast.LENGTH_LONG).show();
            }

        }catch (SQLException ex){
            Toast.makeText(getApplicationContext(),"Ocurrio un error: "+ex.getMessage(),Toast.LENGTH_LONG).show();
        }

        db.close();
        CleanScreen();

    }

    private void CleanScreen() {
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");

    }
}