package com.example.trivialpoursuite.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public MySQLiteHelper(Context context){
        super(context,"Trivial.db",null,14);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Questions(_id integer primary key autoincrement,genre text,type text,question text,answer text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("numversion",oldVersion+"==>"+newVersion);
        db.execSQL("drop table if exists Questions");
        onCreate(db);
    }


}
