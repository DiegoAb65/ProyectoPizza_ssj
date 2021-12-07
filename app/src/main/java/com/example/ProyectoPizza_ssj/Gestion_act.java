package com.example.ProyectoPizza_ssj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Objetos.Pizzas;

public class Gestion_act extends AppCompatActivity {

    EditText txtNomPizza, txtPrecioPizza, txtLocalPizza;
    Button btnAnadirPizza;

    FirebaseDatabase firebase;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        txtNomPizza = findViewById(R.id.txtNomPizza);
        txtPrecioPizza = findViewById(R.id.txtPrecioPizza);
        txtLocalPizza = findViewById(R.id.txtLocalPizza);
        btnAnadirPizza = findViewById(R.id.btnAnadirPizza);

        InicializarDB();

        btnAnadirPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNomPizza.getText().toString().isEmpty() || txtPrecioPizza.getText().toString().isEmpty() || txtLocalPizza.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "Error, ingrese todos los campos faltantes", Toast.LENGTH_LONG).show();
                }else{
                    Pizzas p = new Pizzas();
                    p.setId(UUID.randomUUID().toString());
                    p.setNombre(txtNomPizza.getText().toString());
                    p.setPrecio(txtPrecioPizza.getText().toString());
                    p.setLocalizacion(txtLocalPizza.getText().toString());
                    //Crea la tabla, en caso de que no exista la crea
                    dbRef.child("Pizzas").child(p.getId()).setValue(p);

                    Toast.makeText(getBaseContext(), "Ha añadido la pizza correctamente", Toast.LENGTH_LONG).show();

                    txtNomPizza.setText("");
                    txtPrecioPizza.setText("");
                    txtLocalPizza.setText("");
                }
            }
        }); //CIERRE DE VIEW ONCLICK LISTENER
    }

    public void InicializarDB(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference();
    }
}