package com.bignerdranch.android.exchangeoffice.Persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import android.content.Context;



@Database(entities = {Information.class}, version = 3)
public abstract class InformationDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "information_db";

    private static InformationDatabase instance;

    static InformationDatabase getInstance(final Context context){
        if(instance == null){
            instance =
                    Room.databaseBuilder(context.getApplicationContext(), InformationDatabase.class, DATABASE_NAME)
                            .allowMainThreadQueries().fallbackToDestructiveMigration().build(); //.allowMainThreadQueries()
        }

        return instance;
    }

    public abstract InformationDao getInformationDao();

}
