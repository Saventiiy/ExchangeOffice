package com.bignerdranch.android.exchangeoffice.Persistence;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
//import com.bignerdranch.android.exchangeoffice.Parser.Parser;




public class InformationRepository {

    private InformationDatabase mInformationDatabase;

    public InformationRepository(Context context){
        mInformationDatabase = InformationDatabase.getInstance(context);
    }

    public void insertInformation(Information information){
        new InsertAsyncTask(mInformationDatabase.getInformationDao()).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, information);
    }

    public List<Double> getRate(){
        return mInformationDatabase.getInformationDao().getRate();
    }
}
