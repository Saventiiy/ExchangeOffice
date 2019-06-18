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
import com.bignerdranch.android.exchangeoffice.DB.Information;
import com.bignerdranch.android.exchangeoffice.DB.InformationRepository;
import com.bignerdranch.android.exchangeoffice.Parser.Data;
import com.bignerdranch.android.exchangeoffice.Parser.Parser;

import java.util.List;

public class ExchangeOfficeFragment extends Fragment {

    private String mCurrency[] = {"usd", "eur", "byn", "ru"};
    private Spinner mInputSpinner;
    private Spinner mOutputSpinner;
    public EditText mParse;
    public Data[] data;

    private InformationRepository mInformationRepository;
    private Information mInformation;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.exchange_office_fragment, container, false);
        mParse = v.findViewById(R.id.parse);

        mInformationRepository = new InformationRepository(this.getContext());

        List<String> names = mInformationRepository.getName();
        Toast.makeText(getContext(), names.get(24), Toast.LENGTH_SHORT).show();

//        try {
//            data = new Parser().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR).get();
//
//
//            for(int i = 0; i != data.length; ++i){
//                mInformation = new Information(data[i].getDate(),
//                                               data[i].getCur_Abbreviation(),
//                                               data[i].getCur_Scale(),
//                                               data[i].getCur_Name(),
//                                               data[i].getCur_OfficialRate());
//
//                mInformationRepository.insert(mInformation);
//
//
//            }
//
//
//
//
//            //showData(data);
//
//        }
//        catch (Exception e) {
//        }
//

//
//        Information information = new Information("123124", "hui", 3, "asdf", 3.43);
//        mInformationRepository.insert(information);






        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, mCurrency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);




        mInputSpinner = v.findViewById(R.id.exchange_office_input_currency_spinner);
        mInputSpinner.setAdapter(adapter);
        mInputSpinner.setPrompt("Title");
        mInputSpinner.setSelection(0);

        mInputSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();
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
               // Toast.makeText(getContext(), "Position " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        return v;
    }


    public void showData(Data... data) {
        mParse.setText(data[24].toString());
    }


}