package com.bignerdranch.android.exchangeoffice.Parser;

import android.os.AsyncTask;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Parser extends AsyncTask<Void, Data[], Data[]> {

    private String link = "http://www.nbrb.by/API/ExRates/Rates?Periodicity=0";

    @Override
    protected Data[] doInBackground(Void... voids) {
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(reader, Data[].class);
    }

    @Override
    protected void onPostExecute(Data... data){
    }




//
//    @Override
//    protected void onProgressUpdate(Data... values) {
//        super.onProgressUpdate(values);
//
//
//    }




}