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

import com.bignerdranch.android.exchangeoffice.Persistence.Information;

import java.util.List;


import com.bignerdranch.android.exchangeoffice.Persistence.InformationRepository;

public class ExchangeOfficeFragment extends Fragment {

    private String mCurrency[] = {"usd", "eur", "byn", "ru"};
    private Spinner mInputSpinner;
    private Spinner mOutputSpinner;
    public EditText mParse;

    //private Data[] mData;

    private InformationRepository mInformationRepository;
    private Information mInformation1;
    private Information mInformation2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.exchange_office_fragment, container, false);

        try {
            new Parser().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
        } catch (Exception e) {
        }

        information();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, mCurrency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);


        mParse = v.findViewById(R.id.parse);


        mInputSpinner = v.findViewById(R.id.exchange_office_input_currency_spinner);
        mInputSpinner.setAdapter(adapter);
        mInputSpinner.setPrompt("Title");
        mInputSpinner.setSelection(0);

        mInputSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        mOutputSpinner = v.findViewById(R.id.exchange_office_output_currency_spinner);
        mOutputSpinner.setAdapter(adapter);
        mOutputSpinner.setPrompt("Title");
        mOutputSpinner.setSelection(0);

        mOutputSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        return v;
    }


    public void data(Data[] data) {
        //mInformation1.setRate(data[0].ge);
    }


    public void information() {

        mInformationRepository = new InformationRepository(this.getContext());
        List<Double> arr = mInformationRepository.getRate();

        try {
            mInformation1.setAbbreviation("d");
            mInformation1.setDate("23");
            mInformation1.setName("asd");
            mInformation1.setQuantity(2);
            mInformation1.setRate(8.0);

            mInformation2.setAbbreviation("d");
            mInformation2.setDate("23");
            mInformation2.setName("asd");
            mInformation2.setQuantity(2);
            mInformation2.setRate(3.12);
        } catch (Exception e) {

        }

        mInformationRepository.insertInformation(mInformation1);
        mInformationRepository.insertInformation(mInformation2);
    }


}