package com.nlp.tic_tac_poe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private ActivityMainBinding binding;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button test= findViewById(R.id.test_act);
        test.setOnClickListener((view)->{
            EditText fio = findViewById(R.id.fio);
            EditText age = findViewById(R.id.age);
            EditText pol = findViewById(R.id.pol);
            Intent intent = new Intent(getApplicationContext(), TestActivity.class);
            intent.putExtra("FIO", fio.getText().toString());
            intent.putExtra("AGE", age.getText().toString());
            intent.putExtra("POL", pol.getText().toString());
            startActivity(intent);
        });
        String [] Pari = {"MDK.01", "MDK.02", "MDK.03", "Физ-ра"};
        ListView spiPar = findViewById(R.id.spisk);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Pari);
        spiPar.setAdapter(adapter);
    }
        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());

}

