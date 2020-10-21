package com.unicode.muslimware.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unicode.muslimware.model.RunningTextItem;

import java.util.ArrayList;

public class RunningTextItemCRUD extends DataBaseHelper{

    public RunningTextItemCRUD(Context context){
        super(context);
    }

    public ArrayList<RunningTextItem> readAll(){
        Cursor mCursor = null;
        ArrayList<RunningTextItem> runningTextItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            mCursor = db.rawQuery("SELECT * FROM " + Key.RTI_TABLE_NAME, null);
            if (mCursor.getCount() > 0) {
                while(mCursor.moveToNext()) {
                    RunningTextItem runningTextItem = new RunningTextItem();
                    runningTextItem.id = mCursor.getInt(mCursor.getColumnIndex(Key.GENERAL_COL_ID));
                    runningTextItem.text = mCursor.getString(mCursor.getColumnIndex(Key.RTI_COL_TEXT));
                    runningTextItem.isEnable = mCursor.getInt(mCursor.getColumnIndex(Key.RTI_COL_IS_ENABLE)) == 1;
                    runningTextItem.category = mCursor.getInt(mCursor.getColumnIndex(Key.RTI_COL_CATEGORY));
                    runningTextItem.created_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_CREATED_AT));
                    runningTextItem.update_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_UPDATED_AT));
                    runningTextItem.delete_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_DELETED_AT));
                    runningTextItems.add(runningTextItem);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert mCursor != null;
            if (!mCursor.isClosed()) mCursor.close();
        }
        return runningTextItems;
    }

    public boolean create(RunningTextItem runningTextItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean add = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.RTI_COL_TEXT, runningTextItem.text);
            values.put(Key.RTI_COL_IS_ENABLE, runningTextItem.isEnable?1:0);
            values.put(Key.RTI_COL_CATEGORY,runningTextItem.category);
            values.put(Key.GENERAL_COL_CREATED_AT,this.getDateTime());
            add = db.insert(Key.RTI_TABLE_NAME,null,values) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return add;
    }

    public boolean update(RunningTextItem runningTextItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean update = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.RTI_COL_TEXT, runningTextItem.text);
            values.put(Key.RTI_COL_IS_ENABLE, runningTextItem.isEnable?1:0);
            values.put(Key.RTI_COL_CATEGORY,runningTextItem.category);
            values.put(Key.GENERAL_COL_UPDATED_AT,this.getDateTime());
            update = db.update(Key.RTI_TABLE_NAME,values,"id = ?",new String[] {runningTextItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return update;
    }

    public boolean drop(RunningTextItem runningTextItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean drop = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.GENERAL_COL_DELETED_AT, this.getDateTime());
            drop = db.update(Key.RTI_TABLE_NAME,values,"id = ?",new String[] {runningTextItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return drop;
    }

    public boolean delete(RunningTextItem runningTextItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean delete = false;
        try{

            delete = db.delete(Key.RTI_TABLE_NAME,"id = ?",new String[] {runningTextItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return delete;
    }
}
