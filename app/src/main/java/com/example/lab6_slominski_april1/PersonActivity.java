package com.example.lab6_slominski_april1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PersonActivity extends AppCompatActivity {
    ListView lwPerson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        lwPerson = findViewById(R.id.lwPerson);

        ArrayList<String> i = (ArrayList) this.getIntent().getExtras().get("Persons");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, i);

        lwPerson.setAdapter(adapter);

    }

    class SubmitPerson extends AsyncTask<Person, Void, Void> {
        private LabDatabase database;

        public SubmitPerson(LabDatabase database) {
            this.database = database;
        }

        @Override
        protected Void doInBackground(Person... people) {
            database.personDao().insertPerson(people[0]);
            return null;
        }
    }

//    class RetrievePerson extends AsyncTask<Person, Void, Void> {
//        private LabDatabase database;
//
//        public RetrievePerson(LabDatabase database) {
//            this.database = database;
//        }
//
//        @Override
//        protected Void doInBackground(Person... people) {
//            ArrayList<String> personNames = new ArrayList<>();
//            for (Person person: persons) {
//                personNames.add(person.getName());
//            }
//            Intent i = Intent(context)
//
//            database.personDao().getAllPersons();
//            return null;
//        }
//    }
}
