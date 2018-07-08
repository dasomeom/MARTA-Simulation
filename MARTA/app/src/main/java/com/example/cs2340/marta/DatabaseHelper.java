package com.example.cs2340.marta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase rwDB;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS");
        onCreate(db);
    }


    protected void input(String data) {
        rwDB = getWritableDatabase();
        rwDB.execSQL("INSERT INTO TEST_LIST VALUES(null,'" + data + "');");
        rwDB.close();
    }

    protected String getResult() {
        rwDB= getReadableDatabase();
        String result = "";

        Cursor cursor = rwDB.rawQuery("SELECT * FROM TEST_LIST", null);
        rwDB.close();
        while (cursor.moveToNext()) {
            result += cursor.getString(0) + " : " + cursor.getString(1) + " " + "\n";
        }
        return result;
    }

}
