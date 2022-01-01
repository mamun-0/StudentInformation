package com.example.studentinformation.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentinformation.database.DatabaseHelper;
import com.example.studentinformation.model.Student;

public class DBAdapter {
    private DatabaseHelper databaseHelper;

    public DBAdapter(Context context) {
        this.databaseHelper = new DatabaseHelper(context);
    }
    public void insertIntoDB(Student student){
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME,student.getName());
        contentValues.put(DatabaseHelper.ID,student.getID());
        contentValues.put(DatabaseHelper.MOBILE,student.getNumber());
        contentValues.put(DatabaseHelper.EMAIL,student.getEmail());
        contentValues.put(DatabaseHelper.DISTRICT,student.getDistrict());
        contentValues.put(DatabaseHelper.BLOOD_GROUP,student.getBloodGroup());
        database.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
        database.close();
    }
}
