package com.ozimos.serviceku;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class OzimosIntentService extends IntentService {

    public static String EXTRA_DURASI = "extra_durasi";
    public static final String TAG = "OzimosIntentService";


    public OzimosIntentService(){
        super("OzimosIntentService");

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent()");
        if (intent != null) {
            int durasi = intent.getIntExtra(EXTRA_DURASI, 0);
            try {
                Thread.sleep(durasi);

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "on Destroy bro");
    }

}
