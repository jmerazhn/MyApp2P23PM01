package com.example.myapp2p23pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapp2p23pm01.Configuracion.SQLiteConexion;
import com.example.myapp2p23pm01.Configuracion.Transacciones;
import com.example.myapp2p23pm01.Models.Persona;

import java.util.ArrayList;
import java.util.List;

public class ActivityList extends AppCompatActivity {

    private SQLiteConexion conexion;
    private ListView listPersona;
    ArrayList<Persona> lista;
    ArrayList<String> ArregloPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);


        listPersona = (ListView) findViewById(R.id.listPersona);
        ObtenerTabla();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ArregloPersonas);

        listPersona.setAdapter(adapter);

        listPersona.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), "Ha seleccionado: "+selectedItem, Toast.LENGTH_LONG).show();
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
        ArregloPersonas = new ArrayList<String>();
        for (int i=0;i<lista.size();i++){
            ArregloPersonas.add(""+lista.get(i).getId().toString() + " - " +lista.get(i).getNombres()+ " - "+lista.get(i).getApellidos());
        }
    }
}