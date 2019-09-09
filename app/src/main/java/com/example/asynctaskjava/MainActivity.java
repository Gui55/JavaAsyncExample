package com.example.asynctaskjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Async";

    private TextView theText;

    private AnAsyncTask anAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theText = findViewById(R.id.theText);

        anAsyncTask =  new AnAsyncTask(theText);

    }

    public void inicioAsync(View view) {

        anAsyncTask.execute();

    }

    private class AnAsyncTask extends AsyncTask<Void, Void, Void> {

        private TextView txt;

        AnAsyncTask(TextView txt){
            this.txt = txt;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d(TAG, "Antes da tarefa");
            txt.setText("Fazendo Tarefa");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Log.d(TAG, "Faça no background...");

            try{
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
            }

            Log.d(TAG, "Fez no background");

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Log.d(TAG, "Depois da tarefa");
            txt.setText("Finalizado");
        }
    }
}
