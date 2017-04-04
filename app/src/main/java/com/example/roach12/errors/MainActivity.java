package com.example.roach12.errors;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHellp dbHelper;
    SQLiteDatabase database;

    String gg;
    Button ba;
    ArrayList<String> str = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("Main","activity");
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler(new File(this.getApplicationContext().getExternalFilesDir(null),"exceptions.log"), getApplicationContext()));
        setContentView(R.layout.activity_main);
        ba = (Button) findViewById(R.id.button);
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHellp(getApplicationContext());
                database = dbHelper.getReadableDatabase();
                Cursor cursor = database.query(dbHelper.TABLE_TREAKS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    Log.e("error", "true");
                    int keyX = cursor.getColumnIndex(DBHellp.KEY_TRACK_ID);
                    do {
                        JSONObject messageH = new JSONObject();
                        try {
                            messageH.put("x", cursor.getString(keyX));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.e("ERROR", "Error: "+ cursor.getString(keyX));
                    }
                    while (cursor.moveToNext());
                }
                else{
                    Log.e("error", "false");
                }
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                //ba.setText(str.get(1));
            }
        });
    }
}
