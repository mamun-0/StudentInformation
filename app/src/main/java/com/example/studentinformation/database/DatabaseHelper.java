package com.example.studentinformation.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "students_info.db";

    //DATABASE COMMAND
    public final static String TABLE_NAME = "students_info_table";
    public final static String ROW_ID = "id";
    public final static String NAME = "stdn_name";
    public final static String ID = "stdn_id";
    public final static String MOBILE = "stdn_mobile";
    public final static String EMAIL = "stdn_email";
    public final static String DISTRICT = "stdn_district";
    public final static String BLOOD_GROUP = "stdn_blood_group";
    private final static String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+ " ("
            +ROW_ID+" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, "
            +NAME+ " TEXT, "
            +ID+ " TEXT, "
            +MOBILE+" TEXT, "
            +EMAIL+" TEXT, "
            +DISTRICT+" TEXT, "
            +BLOOD_GROUP+" TEXT"+")";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
