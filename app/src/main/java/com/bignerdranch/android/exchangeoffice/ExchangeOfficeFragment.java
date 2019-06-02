package com.bignerdranch.android.exchangeoffice;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.EditText;

import android.support.v4.app.Fragment;
import com.bignerdranch.android.exchangeoffice.Parser.Data;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ExchangeOfficeFragment extends Fragment {

    private String mCurrency[] = {"usd", "eur", "byn", "ru"};
    private Spinner mInputSpinner;
    private Spinner mOutputSpinner;
    private EditText mParse;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.exchange_office_fragment, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, mCurrency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);


        mParse = v.findViewById(R.id.parse);
        new Parse().execute();



        mInputSpinner = v.findViewById(R.id.exchange_office_input_currency_spinner);
        mInputSpinner.setAdapter(adapter);
        mInputSpinner.setPrompt("Title");
        mInputSpinner.setSelection(0);

        mInputSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getContext(),"Position " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0){

            }
        });

        mOutputSpinner = v.findViewById(R.id.exchange_office_output_currency_spinner);
        mOutputSpinner.setAdapter(adapter);
        mOutputSpinner.setPrompt("Title");
        mOutputSpinner.setSelection(0);

        mOutputSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0){

            }
        });

        return v;
    }

    class Parse extends AsyncTask<Void, Data, Void> {
        private  String link = "http://www.nbrb.by/API/ExRates/Rates?Periodicity=0";

        @Override
        protected Void doInBackground(Void... voids) {
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

            publishProgress(new Gson().fromJson(reader, Data[].class));
            //return new Gson().fromJson(reader, Data[].class);
            return null;
        }

        @Override
        protected void onProgressUpdate(Data... values) {
            super.onProgressUpdate(values);

            mParse.setText(values[0].toString());

        }




    }

}
