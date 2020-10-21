package com.unicode.muslimware.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.unicode.muslimware.model.Alarm;
import com.unicode.muslimware.model.DateAndTime;
import com.unicode.muslimware.model.Display;
import com.unicode.muslimware.model.Profile;
import com.unicode.muslimware.model.Security;
import com.unicode.muslimware.model.Settings;
import com.unicode.muslimware.model.Sound;

public class SettingsCRUD extends DataBaseHelper {

    public SettingsCRUD(Context context){
        super(context);
    }

    public Settings read(){
        Gson gson = new Gson();
        Settings settings = new Settings();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor mCursor = db.rawQuery("SELECT * FROM " + Key.SETTINGS_TABLE_NAME + " ORDER BY " + Key.GENERAL_COL_ID + " DESC LIMIT 1", null);
            mCursor.moveToFirst();
            settings.profile = gson.fromJson(mCursor.getString(mCursor.getColumnIndex(Key.SETTINGS_COL_PROFILE)), Profile.class);
            settings.display = gson.fromJson(mCursor.getString(mCursor.getColumnIndex(Key.SETTINGS_COL_DISPLAY)), Display.class);
            settings.sound = gson.fromJson(mCursor.getString(mCursor.getColumnIndex(Key.SETTINGS_COL_SOUND)), Sound.class);
            settings.alarm = gson.fromJson(mCursor.getString(mCursor.getColumnIndex(Key.SETTINGS_COL_ALARM)), Alarm.class);
            settings.security = gson.fromJson(mCursor.getString(mCursor.getColumnIndex(Key.SETTINGS_COL_SECURITY)), Security.class);
            settings.dateAndTime = gson.fromJson(mCursor.getString(mCursor.getColumnIndex(Key.SETTINGS_COL_DATE_AND_TIME)), DateAndTime.class);
            mCursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return settings;
    }

    public boolean update(Settings settings){
        Gson gson = new Gson();
        SQLiteDatabase db = this.getWritableDatabase();
        boolean update = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.SETTINGS_COL_PROFILE, gson.toJson(settings.profile));
            values.put(Key.SETTINGS_COL_DISPLAY, gson.toJson(settings.display));
            values.put(Key.SETTINGS_COL_SOUND, gson.toJson(settings.sound));
            values.put(Key.SETTINGS_COL_ALARM, gson.toJson(settings.alarm));
            values.put(Key.SETTINGS_COL_SECURITY, gson.toJson(settings.security));
            values.put(Key.SETTINGS_COL_DATE_AND_TIME, gson.toJson(settings.dateAndTime));
            update = db.update(Key.SETTINGS_TABLE_NAME,values, Key.GENERAL_COL_ID+"=1",null) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return update;
    }
}
