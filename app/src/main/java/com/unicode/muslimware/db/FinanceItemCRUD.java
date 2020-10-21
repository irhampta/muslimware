package com.unicode.muslimware.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unicode.muslimware.model.FinanceItem;

import java.util.ArrayList;

public class FinanceItemCRUD extends DataBaseHelper{

    public FinanceItemCRUD(Context context){
        super(context);
    }

    public ArrayList<FinanceItem> readAll(){
        Cursor mCursor = null;
        ArrayList<FinanceItem> financeItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            mCursor = db.rawQuery("SELECT * FROM " + Key.FI_TABLE_NAME, null);
            if (mCursor.getCount() > 0) {
                while(mCursor.moveToNext()) {
                    FinanceItem financeItem = new FinanceItem();
                    financeItem.id = mCursor.getInt(mCursor.getColumnIndex(Key.GENERAL_COL_ID));
                    financeItem.dateTime = mCursor.getString(mCursor.getColumnIndex(Key.FI_COL_DATE_TIME));
                    financeItem.type = mCursor.getInt(mCursor.getColumnIndex(Key.FI_COL_TYPE));
                    financeItem.description = mCursor.getString(mCursor.getColumnIndex(Key.FI_COL_DESCRIPTION));
                    financeItem.amount = mCursor.getDouble(mCursor.getColumnIndex(Key.FI_COL_AMOUNT));
                    financeItem.created_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_CREATED_AT));
                    financeItem.update_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_UPDATED_AT));
                    financeItem.delete_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_DELETED_AT));
                    financeItems.add(financeItem);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert mCursor != null;
            if (!mCursor.isClosed()) mCursor.close();
        }
        return financeItems;
    }

    public boolean create(FinanceItem financeItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean add = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.FI_COL_DATE_TIME, financeItem.dateTime);
            values.put(Key.FI_COL_TYPE, financeItem.type);
            values.put(Key.FI_COL_DESCRIPTION,financeItem.description);
            values.put(Key.FI_COL_AMOUNT, financeItem.amount);
            values.put(Key.GENERAL_COL_CREATED_AT, this.getDateTime());
            add = db.insert(Key.FI_TABLE_NAME,null,values) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return add;
    }

    public boolean update(FinanceItem financeItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean update = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.FI_COL_DATE_TIME, financeItem.dateTime);
            values.put(Key.FI_COL_TYPE, financeItem.type);
            values.put(Key.FI_COL_DESCRIPTION,financeItem.description);
            values.put(Key.FI_COL_AMOUNT, financeItem.amount);
            values.put(Key.GENERAL_COL_UPDATED_AT, this.getDateTime());
            update = db.update(Key.FI_TABLE_NAME,values,"id = ?",new String[] {financeItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return update;
    }

    public boolean drop(FinanceItem financeItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean drop = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.GENERAL_COL_DELETED_AT, this.getDateTime());
            drop = db.update(Key.FI_TABLE_NAME,values,"id = ?",new String[] {financeItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return drop;
    }

    public boolean delete(FinanceItem financeItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean delete = false;
        try{

            delete = db.delete(Key.FI_TABLE_NAME,"id = ?",new String[] {financeItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return delete;
    }
}
