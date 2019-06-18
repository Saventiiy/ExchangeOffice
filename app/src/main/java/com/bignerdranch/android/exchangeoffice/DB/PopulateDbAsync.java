package com.bignerdranch.android.exchangeoffice.DB;

import android.os.AsyncTask;

public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final InformationDAO mDao;

    PopulateDbAsync(InformationDatabase db){
        mDao = db.informationDAO();
    }


    @Override
    protected Void doInBackground(final Void... params){
        Information information = new Information("123124", "hui", 3, "e3adf", 3.43);
        mDao.insert(information);

        return null;
    }
}
