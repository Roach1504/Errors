package com.example.roach12.errors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    Button ba;
    ArrayList<String> str = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Main2","activity 2");
        setContentView(R.layout.activity_main);
        ba = (Button) findViewById(R.id.button);
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ba.setText(str.get(1));
            }
        });
    }
}
