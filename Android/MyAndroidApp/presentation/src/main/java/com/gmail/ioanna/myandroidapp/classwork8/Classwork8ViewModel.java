package com.gmail.ioanna.myandroidapp.classwork8;


import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.dz2.Dz2Activity;

public class Classwork8ViewModel implements BaseViewModel {


    public Activity activity;

    public ObservableField<String> helloText = new ObservableField<>("Hello");

    public Classwork8ViewModel(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void onSuperButtonClick(){
        Log.e("AAA", "Click");
        Intent intent = new Intent(activity, Dz2Activity.class);
        activity.startActivity(intent);

        //Classwork8Activity.show(activity);
    }

    public class MyAsyncTask extends AsyncTask<Void, Integer, Void>{

        @Override
        protected void onPreExecute() {//выполняется в UI потоке до метода doInBackground()
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //выполняется в UI потоке
            //этот мтеод необходимо вызывать самотсоятельно из doInBackground()
        }

        @Override
        protected Void doInBackground(Void... voids) {//тут все выполняется в отдельном потоке, затем передает данные в метод onPostExecute()

            publishProgress(20);//вызывает метод onProgressUpdate()

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {//выполнение в UI потоке, входное значение передается из метода doInBackground()
            super.onPostExecute(aVoid);
        }
    }
}
