package com.bignerdranch.android.exchangeoffice.Persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface InformationDao {
    @Insert
    void insert(Information... information);

    @Query("SELECT abbreviation FROM information")
    List<String> getAbbreviation();

    @Query("SELECT quantity FROM information")
    List<Integer> getQuantity();

    @Query("SELECT name FROM information")
    List<String> getName();

    @Query("SELECT rate FROM information")
    List<Double> getRate();

}