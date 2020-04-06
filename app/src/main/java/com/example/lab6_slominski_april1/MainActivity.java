package com.example.lab6_slominski_april1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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
    LabDatabase labDatabase;


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
                SubmitTask.execute();

            }
        });

        bRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveName();
                RetrieveTask.execute();
//                new RetrievePerson().execute();
            }
        });

        labDatabase = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME).build();

    }
    public void storeName() {
        Toast.makeText(this, etInputName.getText(), Toast.LENGTH_SHORT).show();
//               storeName = etInputName.getText().toString();
//               new SubmitPerson().execute();
    }

    public void retrieveName() {
        Toast.makeText(this, etInputName.getText(), Toast.LENGTH_SHORT).show();
    }

    class SubmitTask extends AsyncTask<String,Void,Void>{
        private ArrayAdapter<String> adapter;

        @Override
        protected Void doInBackground(String... strings) {
            labDatabase.personDao().insertPerson(person);
            return null;
        }
    }

    class RetrieveTask extends AsyncTask<Void, Void, LabDatabase> {

        @Override
        protected LabDatabase doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(LabDatabase database) {
            super.onPostExecute(database);
            ArrayList<String> personNames = new ArrayList<>();
            for (Person p: persons) {
                personNames.add(p.getName());
            }
            Intent i = new Intent(context, PersonActivity.class);
            i.putExtra("Persons", personNames);
            getApplicationContext().startActivity(i);
        }
    }




}
