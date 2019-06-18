package com.bignerdranch.android.exchangeoffice.DB;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import android.content.Context;
import android.support.annotation.NonNull;


@Database(entities = {Information.class}, version = 1)
public abstract class InformationDatabase extends RoomDatabase {

    public abstract InformationDAO informationDAO();

    public static final String DATABASE_NAME = "information_db";

    private static volatile InformationDatabase INSTANCE;


    static InformationDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (InformationDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            InformationDatabase.class, DATABASE_NAME).addCallback(sRoomDatabaseCallBack).allowMainThreadQueries().build();
                }
            }
        }

        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallBack = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);

            new PopulateDbAsync(INSTANCE).execute();
        }
    };

}
