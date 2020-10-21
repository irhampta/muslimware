package com.unicode.muslimware.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.unicode.muslimware.model.Alarm;
import com.unicode.muslimware.model.Carousel;
import com.unicode.muslimware.model.DateAndTime;
import com.unicode.muslimware.model.Display;
import com.unicode.muslimware.model.Finance;
import com.unicode.muslimware.model.Profile;
import com.unicode.muslimware.model.RunningText;
import com.unicode.muslimware.model.Security;
import com.unicode.muslimware.model.Sound;

public class SettingsBluePrint {
    static Gson gson = new Gson();

    //empty constructor
    SettingsBluePrint(){}

    // cereate table settings if not exist
    public static void createTable(SQLiteDatabase db){
        try {
            db.execSQL("CREATE TABLE "+Key.SETTINGS_TABLE_NAME+" (" +
                    Key.GENERAL_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Key.SETTINGS_COL_PROFILE+" TEXT, " +
                    Key.SETTINGS_COL_RUNNING_TEXT+" TEXT, " +
                    Key.SETTINGS_COL_CAROUSEL+" TEXT, " +
                    Key.SETTINGS_COL_FINANCE+" TEXT, " +
                    Key.SETTINGS_COL_DISPLAY+" TEXT, " +
                    Key.SETTINGS_COL_SOUND+" TEXT, " +
                    Key.SETTINGS_COL_ALARM+" TEXT, " +
                    Key.SETTINGS_COL_SECURITY+" TEXT, " +
                    Key.SETTINGS_COL_DATE_AND_TIME+" TEXT)"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // insert default value to settings table at row index 1
    public static void insertDefaultValue(SQLiteDatabase db){
        try{
            ContentValues values = new ContentValues();
            values.put(Key.SETTINGS_COL_PROFILE, gson.toJson(new Profile()));
            values.put(Key.SETTINGS_COL_RUNNING_TEXT, gson.toJson(new RunningText()));
            values.put(Key.SETTINGS_COL_CAROUSEL, gson.toJson(new Carousel()));
            values.put(Key.SETTINGS_COL_FINANCE, gson.toJson(new Finance()));
            values.put(Key.SETTINGS_COL_DISPLAY, gson.toJson(new Display()));
            values.put(Key.SETTINGS_COL_SOUND, gson.toJson(new Sound()));
            values.put(Key.SETTINGS_COL_ALARM, gson.toJson(new Alarm()));
            values.put(Key.SETTINGS_COL_SECURITY, gson.toJson(new Security()));
            values.put(Key.SETTINGS_COL_DATE_AND_TIME, gson.toJson(new DateAndTime()));
            db.beginTransaction();
            db.insert(Key.SETTINGS_TABLE_NAME,null,values);
            db.setTransactionSuccessful();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            db.endTransaction();
        }


    }

}
