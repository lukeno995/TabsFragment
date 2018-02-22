package com.example.luca.tabsfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Luca on 15/02/2018.
 */

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void buttonTabs(View view) {
        Intent intent = new Intent(Activity2.this, MainActivity.class);
        intent.putExtra("User",view.getTag().toString());
        startActivity(intent);
        //finish();
    }
}
