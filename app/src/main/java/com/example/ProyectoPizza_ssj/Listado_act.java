package com.example.ProyectoPizza_ssj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Objetos.Pizzas;

public class Listado_act extends AppCompatActivity {

    private ListView lvListaPizzas;
    private ArrayList<Pizzas> listaPizzasArrayList = new ArrayList();

    FirebaseDatabase firebase;
    DatabaseReference dbRef;

    Pizzas pizzasSelec = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lvListaPizzas = findViewById(R.id.lvListaPizzas);

        InicializarDB();

        lvListaPizzas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //RECORRIDO POR POSICION ?
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pizzasSelec = (Pizzas)adapterView.getItemAtPosition(i);
            }
        });

        dbRef.child("Pizzas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) { //Snapshot data base location
                //Da acceso a todos los elementos secundarios inmediatos de esta instantánea.
                for(DataSnapshot op : snapshot.getChildren()){//for recorrido
                    Pizzas p = op.getValue(Pizzas.class);
                    listaPizzasArrayList.add(p);//anadir al objeto p
                    ArrayAdapter adapterListaPizzas = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaPizzasArrayList);
                    lvListaPizzas.setAdapter(adapterListaPizzas);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void InicializarDB(){
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference();
    }

    public void EliminarPizza(View view){
        if(pizzasSelec == null){
            Toast.makeText(getBaseContext(), "Error, seleccione primero la pizza para eliminar", Toast.LENGTH_LONG).show();
        }else{
            Pizzas p = new Pizzas();
            p.setId(pizzasSelec.getId());
            pizzasSelec = null;
            dbRef.child("Pizzas").child(p.getId()).removeValue();

            Toast.makeText(getBaseContext(), "Ha sido eliminado correctamente", Toast.LENGTH_LONG).show();
            listaPizzasArrayList.clear();
            lvListaPizzas.setAdapter(null);
        }
    }
}