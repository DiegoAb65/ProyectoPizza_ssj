package com.example.ProyectoPizza_ssj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.ProyectoPizza_ssj.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Gestion(View view){
        Intent i = new Intent(this, Gestion_act.class);
        startActivity(i);
    }

    public void Listado(View view){
        Intent i = new Intent(this, Listado_act.class);
        startActivity(i);
    }

    public void Armar(View view){
        Intent i = new Intent(this, Arma_pizza_act.class);
        startActivity(i);
    }

    public void Facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://es-la.facebook.com/pizzapizza.cl/"));
        startActivity(i);
    }

    public void Instagram(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.instagram.com/pizzapizzadechile/?hl=es"));
        startActivity(i);
    }

    public void Twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/pizza__pizza"));
        startActivity(i);
    }

    public void Youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/user/PizzaHutChile"));
        startActivity(i);
    }
}