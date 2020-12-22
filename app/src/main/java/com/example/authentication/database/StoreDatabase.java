package com.example.authentication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StoreDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "lesson.db";
    public static final int DATABASE_VERSION = 4;

    public static final String TABLE_USERS = "users";

    public static final String COLUMN_USER_NAME = "user_name";
    public static final String COLUMN_USER_EMAIL = "user_mail";
    public static final String COLUMN_USER_CITY = "user_city";
    public static final String COLUMN_USER_PHONE = "user_phone";
    public static final String COLUMN_USER_PASSWORD = "user_password";


    Context context;

    public StoreDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_USER_NAME + "TEXT, " +
                COLUMN_USER_EMAIL + "TEXT, " +
                COLUMN_USER_CITY + "TEXT, " +
                COLUMN_USER_PHONE + "INTEGER, " +
                COLUMN_USER_PASSWORD + "TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        onCreate(db);
    }


}
