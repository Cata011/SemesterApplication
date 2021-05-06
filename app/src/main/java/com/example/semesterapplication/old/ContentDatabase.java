package com.example.semesterapplication.old;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class ContentDatabase extends RoomDatabase {
    private static ContentDatabase instance;
    public abstract ContentDAO contentDAO();

    public static synchronized ContentDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ContentDatabase.class, "content_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
