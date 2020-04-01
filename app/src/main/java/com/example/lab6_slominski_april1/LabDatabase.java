package com.example.lab6_slominski_april1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1)

public abstract class LabDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}
