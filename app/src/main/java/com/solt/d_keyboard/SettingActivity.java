package com.solt.d_keyboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {


    Switch vibrate;
    Switch sound;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);

        vibrate = findViewById(R.id.vibratesw);
        vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vibrate.isChecked()){
                    Toast.makeText(getApplicationContext(),"vibrate is on ",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"vibrate is off ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
