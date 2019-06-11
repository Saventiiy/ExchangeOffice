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
import com.bignerdranch.android.exchangeoffice.Parser.Parser;
//import com.bignerdranch.android.exchangeoffice.Persistence.DataDao;
//import com.bignerdranch.android.exchangeoffice.Persistence.DataRepository;
//import com.bignerdranch.android.exchangeoffice.Parser.Parser;
import com.bignerdranch.android.exchangeoffice.Persistence.Information;
import com.bignerdranch.android.exchangeoffice.Persistence.InformationDao;
import com.bignerdranch.android.exchangeoffice.Persistence.Rate;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import com.bignerdranch.android.exchangeoffice.Persistence.InformationRepository;

public class ExchangeOfficeFragment extends Fragment {

    private String mCurrency[] = {"usd", "eur", "byn", "ru"};
    private Spinner mInputSpinner;
    private Spinner mOutputSpinner;
    public EditText mParse;

    private Data[] mData;

    private InformationRepository mInformationRepository;
    private Information mInformation1;
    private Information mInformation2;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.exchange_office_fragment, container, false);

        Parser p = new Parser();

        try {
            p.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);


        }
        catch (Exception e){
        }

        information();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, mCurrency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);








        mParse = v.findViewById(R.id.parse);
        //mParse.setText();


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






public void information(){

    mInformationRepository = new InformationRepository(this.getContext());

    try{
        mInformation1.setId(1);
        mInformation1.setAbbreviation("d");
        mInformation1.setDate("23");
        mInformation1.setName("asd");
        mInformation1.setQuantity(2);
        mInformation1.setRate(4.5);

        mInformation2.setAbbreviation("d");
        mInformation2.setDate("23");
        mInformation2.setName("asd");
        mInformation2.setQuantity(2);
        mInformation2.setRate(4.5);
    }
    catch (Exception e){

    }

    mInformationRepository.insertInforamtion(mInformation1);
    //mInformationRepository.insertInforamtion(mInformation2);
    List<Rate> arr = mInformationRepository.getRate();
    //mParse.setText(arr.get(0).toString());
}






















//public class Parser extends AsyncTask<Void, Data, Void> {
//
//    private String link = "http://www.nbrb.by/API/ExRates/Rates?Periodicity=0";
////    private DataDao mDataDao;
////    private DataRepository mDataRepository;
//
//
////    public Parser(DataDao dao){
////        mDataDao = dao;
////    }
//
//    @Override
//    protected Void doInBackground(Void... voids) {
//        URL url = null;
//        try {
//            url = new URL(link);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        InputStreamReader reader = null;
//        try {
//            reader = new InputStreamReader(url.openStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        //mDataDao.insert(new Gson().fromJson(reader, Data[].class));
//        publishProgress(new Gson().fromJson(reader, Data[].class));
//        return null;
//    }
//
//
//    @Override
//    protected void onProgressUpdate(Data... values) {
//        super.onProgressUpdate(values);
//
//        mParse.setText(values[0].toString());
//
//    }
//
//    }
}















//    public List<String> retrieveData(){
//        List<String> abb = new ArrayList<>();
//        abb.addAll(mDataRepository.getAbbreviation().size());
//        return abb;
//    }

//
//    public static class Parser extends AsyncTask<Void, Void, Void> {
//
//        private String link = "http://www.nbrb.by/API/ExRates/Rates?Periodicity=0";
//        private DataDao mDataDao;
//        private DataDao mDataRepository;
//
//        public Parser(DataDao dao){
//            mDataDao = dao;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            URL url = null;
//            try {
//                url = new URL(link);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            InputStreamReader reader = null;
//            try {
//                reader = new InputStreamReader(url.openStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            //publishProgress(new Gson().fromJson(reader, Data[].class));
//            //return new Gson().fromJson(reader, Data[].class);
//            mDataDao.insert(new Gson().fromJson(reader, Data[].class));
//            publishProgress();
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... voids) {
//           // super.onProgressUpdate(voids);
//            List<Double> abb = new ArrayList<>();
//            abb.addAll(mDataRepository.getRate());
//            new ExchangeOfficeFragment().mParse.setText(abb.get(0).toString());
//            //mParse.setText(values[0].toString());
//
//        }
//
//
//
//
//    }

//}
