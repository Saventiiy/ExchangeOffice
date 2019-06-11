package com.bignerdranch.android.exchangeoffice.Persistence;

import android.os.AsyncTask;
import android.util.Log;


public class InsertAsyncTask extends AsyncTask<Information, Void, Void> {

    private InformationDao mInformationDao;

    public InsertAsyncTask(InformationDao informationDao){
        mInformationDao = informationDao;
    }

    @Override
    protected Void doInBackground(Information... informations) {

        Log.d("InserAsyncTask", "Ebanyi Rot");

        mInformationDao.insert(informations);

        return null;
    }
}
