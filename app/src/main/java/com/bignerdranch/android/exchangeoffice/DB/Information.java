package com.bignerdranch.android.exchangeoffice.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "infromation")
public class Information {

    @PrimaryKey(autoGenerate = true)
    private int dataId;

    private String date;
    private String abbreveation;
    private int quantity;
    private String name;
    private double rate;

    public Information(String date, String abbreveation, int quantity, String name, double rate){
        this.date = date;
        this.abbreveation = abbreveation;
        this.quantity = quantity;
        this.name = name;
        this.rate = rate;
    }


    public int getDataId(){
        return this.dataId;
    }

    public void setDataId(int dataId){
        this.dataId = dataId;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getAbbreveation(){
        return this.abbreveation;
    }

    public void setAbbreveation(String abbreveation){
        this.abbreveation = abbreveation;
    }


    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }


    public double getRate(){
        return this.rate;
    }

    public void setRate(double rate){
        this.rate = rate;
    }



}
