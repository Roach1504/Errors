package com.example.roach12.errors;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHellp  extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "treakDb";

    public static final String TABLE_TREAKS = "treaks";

    public static final String KEY_TRACK_ID = "track_id";





    public DBHellp(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TREAKS + "("
                + KEY_TRACK_ID + " text" +");");

    }
    String[] dat;
    String s = "select sysdate from dual";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_TREAKS);
//        db.execSQL("drop table if exists " + TABLE_paint);
        onCreate(db);
        db.rawQuery(s, dat);
    }

}
