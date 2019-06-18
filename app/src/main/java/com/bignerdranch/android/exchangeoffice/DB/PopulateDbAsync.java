package com.bignerdranch.android.exchangeoffice.DB;

import android.os.AsyncTask;
import com.bignerdranch.android.exchangeoffice.Parser.Data;
import com.bignerdranch.android.exchangeoffice.Parser.Parser;

import java.util.concurrent.ExecutionException;

public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final InformationDAO mDao;
    private Information mInformation;

    PopulateDbAsync(InformationDatabase db){
        mDao = db.informationDAO();
    }


    @Override
    protected Void doInBackground(final Void... params){



        try{
            Data[] data = new Parser().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR).get();

            for(int i = 0; i != data.length; ++i){
                mInformation = new Information(data[i].getDate(),
                                               data[i].getCur_Abbreviation(),
                                               data[i].getCur_Scale(),
                                               data[i].getCur_Name(),
                                               data[i].getCur_OfficialRate());

                mDao.insert(mInformation);
            }
        }
        catch (Exception e){

        }
        //Information information = new Information("123124", "hui", 3, "qwert", 3.43);
       // mDao.insert(information);
        return null;
    }
}
