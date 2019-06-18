package com.bignerdranch.android.exchangeoffice.DB;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class InformationRepository {

    private InformationDAO mInformationDAO;


    public InformationRepository(Context context){
        InformationDatabase db = InformationDatabase.getDatabase(context);
        mInformationDAO = db.informationDAO();
    }

//    public void insert(Information information){
//        new InsertAsyncTask(mInformationDAO).execute(information);
//    }


    public List<String> getName(){
        return mInformationDAO.getName();
    }




//    private static class InsertAsyncTask extends AsyncTask<Information, Void, Void>{
//
//
//        private InformationDAO mAsyncTaskDAO;
//
//        InsertAsyncTask(InformationDAO dao){
//            mAsyncTaskDAO = dao;
//        }
//
//
//        @Override
//        protected Void doInBackground(final Information... params){
//            mAsyncTaskDAO.insert(params[0]);
//            return null;
//        }
//    }


}
