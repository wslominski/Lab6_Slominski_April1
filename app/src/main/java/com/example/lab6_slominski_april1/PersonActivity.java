package com.example.lab6_slominski_april1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity {
    private ListView lwPerson;

//    Person personOne = new Person(1, "Wyatt");
//    private ArrayList<Person> mDataSource;

//    public PersonActivity(ListView lwPerson, ArrayList<Person> mDataSource) {
//        this.lwPerson = lwPerson;
//        this.mDataSource = mDataSource;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        lwPerson = findViewById(R.id.lwPerson);

//        ArrayList<Person> personArrayList = new ArrayList<>();
//        personArrayList.add(personOne);
//
//        PersonAdapter adapter = new PersonAdapter(getApplicationContext(), personArrayList);
//        lwPerson.setAdapter(adapter);

        ArrayList<String> i = (ArrayList) this.getIntent().getExtras().get("Persons");
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, i);
        lwPerson.setAdapter(adapter);

    }

}
