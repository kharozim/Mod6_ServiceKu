package com.ozimos.serviceku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartService;
    private Button btnStartIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnStartService = (Button) findViewById(R.id.btn_start_service);
        btnStartIntentService = (Button) findViewById(R.id.btn_start_intent_service);
        btnStartService.setOnClickListener(this);
        btnStartIntentService.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                Intent mStartServiceIntent = new Intent(MainActivity.this,OriginalService.class);
                startService(mStartServiceIntent);
                break;
            case R.id.btn_start_intent_service:
                Intent mozimosstartIntentService = new Intent(MainActivity.this, OzimosIntentService.class);
                mozimosstartIntentService.putExtra(OzimosIntentService.EXTRA_DURASI,3000);
                startService(mozimosstartIntentService);
                break;
        }
    }
}
