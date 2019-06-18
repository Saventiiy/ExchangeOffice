package com.bignerdranch.android.exchangeoffice.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface InformationDAO {

    @Insert
    void insert(Information information);

    @Query("SELECT name from infromation")
    List<String> getName();

}
