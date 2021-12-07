package com.example.ProyectoPizza_ssj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Calcular_Pizzas;

public class Arma_pizza_act extends AppCompatActivity {
    private Spinner spnPizza, spnIngre;
    private TextView tvTotalSuma;
    private Calcular_Pizzas calcularPizzas = new Calcular_Pizzas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arma_pizza);

        spnPizza = findViewById(R.id.spnPizza);
        spnIngre = findViewById(R.id.spnIngre);
        tvTotalSuma = findViewById(R.id.tvTotalSuma);

        ArrayAdapter adapterPizzas = new ArrayAdapter(this, android.R.layout.simple_list_item_1, calcularPizzas.getTipos());
        ArrayAdapter adapterIngre = new ArrayAdapter(this, android.R.layout.simple_list_item_1, calcularPizzas.getIngr());

        spnPizza.setAdapter(adapterPizzas);
        spnIngre.setAdapter(adapterIngre);
    }

    public void CalcularEntrega(View view){
        String pizzaSelec = spnPizza.getSelectedItem().toString();
        String ingreSelec = spnIngre.getSelectedItem().toString();
        //Convertir a String
        String resultado = "$" + String.valueOf(calcularPizzas.SumaPizzaIngre(pizzaSelec, ingreSelec));
        tvTotalSuma.setText(resultado);
    }
}