package com.example.myapp2p23pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myapp2p23pm01.Configuracion.SQLiteConexion;
import com.example.myapp2p23pm01.Configuracion.Transacciones;
import com.example.myapp2p23pm01.Models.Persona;

import java.util.ArrayList;

public class ActivityCombo extends AppCompatActivity {
    private SQLiteConexion conexion;
    private Spinner cmbPersonas;
    private EditText nombres, apellidos, correo;

    private ArrayList<String> listaPersonas;
    private ArrayList<Persona> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        conexion = new SQLiteConexion(this,Transacciones.NameDataBase, null, 1);
        cmbPersonas = (Spinner) findViewById(R.id.spinner);
        nombres  = (EditText) findViewById(R.id.txtNombre);
        apellidos  = (EditText) findViewById(R.id.txtApellido);
        correo  = (EditText) findViewById(R.id.txtCorreo);

        ObtenerTabla();

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaPersonas);
        cmbPersonas.setAdapter(adapter);

        cmbPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    nombres.setText(lista.get(position).getNombres());
                    apellidos.setText(lista.get(position).getApellidos());
                    correo.setText(lista.get(position).getCorreo());
                }catch (Exception ex){
                    ex.toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void ObtenerTabla() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Persona persona = null;
        lista = new ArrayList<Persona>();
        // Cursor de Base de datos
        Cursor cursor = db.rawQuery(Transacciones.SelectTablePersona, null);

        // Recorrer el cursor
        while (cursor.moveToNext()){
            persona = new Persona();
            //persona.setId(cursor.getInt(0));
            persona.setId(cursor.getInt(0));
            persona.setNombres(cursor.getString(1));
            persona.setApellidos(cursor.getString(2));
            persona.setEdad(cursor.getInt(3));
            persona.setCorreo(cursor.getString(4));

            lista.add(persona);
        }
        cursor.close();

        fillList();

    }
    private void fillList() {
        listaPersonas = new ArrayList<String>();
        for (int i=0;i<lista.size();i++){
            listaPersonas.add(""+lista.get(i).getId().toString() + " - " +lista.get(i).getNombres()+ " - "+lista.get(i).getApellidos());
        }
    }
}