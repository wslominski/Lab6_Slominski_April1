package com.example.lab6_slominski_april1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bSumbit, bRetrieve;
    EditText etInputName;
    String storeName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bSumbit = findViewById(R.id.bSubmit);
        bRetrieve = findViewById(R.id.bRetrieve);
        etInputName = findViewById(R.id.etInputName);


        bSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeName();

            }
        });

        bRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new RetrievePerson().execute();
            }
        });

    }
    public void storeName() {
        storeName = etInputName.getText().toString();
        Toast.makeText(this, etInputName.getText(), Toast.LENGTH_SHORT).show();
//        new SubmitPerson().execute();
    }




}
