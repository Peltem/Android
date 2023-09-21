package com.nlp.tic_tac_poe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nlp.tic_tac_poe.adapters.StudyAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Study> studies = new ArrayList<Study>();
    ListView spisk3;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spisk3 = findViewById(R.id.spisk3);
        String [] Pari = {"MDK.01", "MDK.02", "MDK.03", "Физ-ра"};
        ListView spiPar = findViewById(R.id.spisk);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Pari);
        spiPar.setAdapter(adapter);
        setInitialData();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment, new StudyListFragment(), "study_list_fragment")
                .commit();

        StudyAdapter studyAdapter = new StudyAdapter(this, R.layout.list_item, studies);

        // устанавливаем адаптер
        spisk3.setAdapter(studyAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Study selectedStudy = (Study) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Пара: " + selectedStudy.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        spisk3.setOnItemClickListener(itemListener);
    }
    private void setInitialData(){

        studies.add(new Study ("MDK.01", 134));
        studies.add(new Study ("MDK.02", 45));
        studies.add(new Study ("MDK.03", 64));

    }

    }

        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());
