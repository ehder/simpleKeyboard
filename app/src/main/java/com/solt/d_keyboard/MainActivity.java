package com.solt.d_keyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private SimpleIME simpleIME;
    private Vibrator vibrator;
    Button settingbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleIME = new SimpleIME();


        settingbtn = (Button) findViewById(R.id.settingbtn);

        settingbtn.setOnClickListener(v -> {

          Intent i=new Intent(MainActivity.this ,SettingActivity.class);
          startActivity(i);
        });


    }
}
