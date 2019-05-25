package com.bignerdranch.android.exchangeoffice;

import android.support.v4.app.Fragment;


public class ExchangeOfficeActitvity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new ExchangeOfficeFragment();
    }
}
