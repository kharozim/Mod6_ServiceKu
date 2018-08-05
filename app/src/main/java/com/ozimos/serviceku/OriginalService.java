package com.ozimos.serviceku;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

public class OriginalService extends Service {


    public static final String ORIGINAL_SERVICE = "Original Service";


    public OriginalService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(ORIGINAL_SERVICE, "OriginalService dijalankan");
        ProcessAsync mprocessAsync = new ProcessAsync();
        mprocessAsync.execute();
        return START_STICKY;
    }

    private class ProcessAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(ORIGINAL_SERVICE, "StopService");
            stopSelf();
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(ORIGINAL_SERVICE, "ON DESTROY");
    }

}
