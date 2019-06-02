package com.bignerdranch.android.exchangeoffice;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;



public class MainScreenFragment extends Fragment {

    private EditText mPhoneEditText;
    private Button mNextButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.main_screen_fragment, container, false);


        mPhoneEditText = v.findViewById(R.id.main_screen_phone_number);

        mNextButton = v.findViewById(R.id.main_screen_next_button);
        mNextButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v){

                if(mPhoneEditText.getText().toString().matches("[+0-9]\\d{12}")){
                    Intent intent = new Intent(getContext(), ExchangeOfficeActitvity.class);
                    startActivity(intent);

                    mPhoneEditText.getText().clear();
                }
                else{
                    Toast.makeText(getContext(), "Incorrect phone number", Toast.LENGTH_SHORT).show();
                }

            }
        } );

        return v;
    }



}
