package com.bignerdranch.android.exchangeoffice.Persistence;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.ColumnInfo;

@Entity(tableName = "information")
public class Information {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "abbreviation")
    private String abbreviation;

    @ColumnInfo(name = "quantity")
    private int quantity;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "rate")
    private double rate;


    Information(int id, String date, String abbreviation, int quantity, String name, double rate){

        this.id = id;
        this.date = date;
        this.abbreviation = abbreviation;
        this.quantity = quantity;
        this.name = name;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String v) {
        this.date = date;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
