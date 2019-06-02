package com.bignerdranch.android.exchangeoffice.Parser;

public class Data {

    private int Cur_ID;
    private String Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;
    private String Cur_Name;
    private double Cur_OfficialRate;


    public Data(int Cur_ID, String Date, String Cur_Abbreviation, int Cur_Scale, String Cur_Name, double Cur_OfficialRate){
        this.Cur_ID = Cur_ID;
        this.Date = Date;
        this.Cur_Abbreviation = Cur_Abbreviation;
        this.Cur_Scale = Cur_Scale;
        this.Cur_Name = Cur_Name;
        this.Cur_OfficialRate = Cur_OfficialRate;
    }

    public int getCur_ID(){
        return Cur_ID;
    }

    public void setCur_ID(int Cur_ID){
        this.Cur_ID = Cur_ID;
    }

    public String getDate(){
        return Date;
    }

    public void setDate(String Date){
        this.Date = Date;
    }

    public String getCur_Abbreviation(){
        return Cur_Abbreviation;
    }

    public void setCur_Abbreviation(String Cur_Abbreviation){
        this.Cur_Abbreviation = Cur_Abbreviation;
    }

    public int getCur_Scale(){
        return Cur_Scale;
    }

    public void setCur_Scale(int Cur_Scale){
        this.Cur_Scale = Cur_Scale;
    }

    public String getCur_Name(){
        return Cur_Name;
    }

    public void setCur_Name(String Cur_Name){
        this.Cur_Name = Cur_Name;
    }

    public double getCur_OfficialRate(){
        return Cur_OfficialRate;
    }

    public void setCur_OfficialRate(double Cur_OfficialRate){
        this.Cur_OfficialRate = Cur_OfficialRate;
    }

    @Override
    public String toString(){
        return  Cur_ID + " " + Date + " " + Cur_Abbreviation + " " + Cur_Scale + " " + Cur_Name + " " + Cur_OfficialRate;
    }



}
