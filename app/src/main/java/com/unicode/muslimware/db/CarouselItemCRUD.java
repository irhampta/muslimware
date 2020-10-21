package com.unicode.muslimware.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unicode.muslimware.model.CarouselItem;

import java.util.ArrayList;

public class CarouselItemCRUD extends DataBaseHelper{

    public CarouselItemCRUD(Context context){
        super(context);
    }

    public ArrayList<CarouselItem> readAll(){
        Cursor mCursor = null;
        ArrayList<CarouselItem> carouselItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            mCursor = db.rawQuery("SELECT * FROM " + Key.CI_TABLE_NAME, null);
            if (mCursor.getCount() > 0) {
                while(mCursor.moveToNext()) {
                    CarouselItem carouselItem = new CarouselItem();
                    carouselItem.id = mCursor.getInt(mCursor.getColumnIndex(Key.GENERAL_COL_ID));
                    carouselItem.path = mCursor.getString(mCursor.getColumnIndex(Key.CI_COL_PATH));
                    carouselItem.isAssets = mCursor.getInt(mCursor.getColumnIndex(Key.CI_COL_IS_ASSETS))==1;
                    carouselItem.credits = mCursor.getString(mCursor.getColumnIndex(Key.CI_COL_CREDITS));
                    carouselItem.isEnable = mCursor.getInt(mCursor.getColumnIndex(Key.CI_COL_IS_ENABLE))==1;
                    carouselItem.created_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_CREATED_AT));
                    carouselItem.update_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_UPDATED_AT));
                    carouselItem.delete_at = mCursor.getString(mCursor.getColumnIndex(Key.GENERAL_COL_DELETED_AT));
                    carouselItems.add(carouselItem);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert mCursor != null;
            if (!mCursor.isClosed()) mCursor.close();
        }
        return carouselItems;
    }

    public boolean create(CarouselItem carouselItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean add = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.CI_COL_PATH, carouselItem.path);
            values.put(Key.CI_COL_IS_ASSETS, carouselItem.isAssets?1:0);
            values.put(Key.CI_COL_CREDITS,carouselItem.credits);
            values.put(Key.CI_COL_IS_ENABLE, carouselItem.isEnable?1:0);
            values.put(Key.GENERAL_COL_CREATED_AT, this.getDateTime());
            add = db.insert(Key.CI_TABLE_NAME,null,values) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return add;
    }

    public boolean update(CarouselItem carouselItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean update = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.CI_COL_PATH, carouselItem.path);
            values.put(Key.CI_COL_IS_ASSETS, carouselItem.isAssets?1:0);
            values.put(Key.CI_COL_CREDITS, carouselItem.credits);
            values.put(Key.CI_COL_IS_ENABLE, carouselItem.isEnable?1:0);
            values.put(Key.GENERAL_COL_UPDATED_AT, this.getDateTime());
            update = db.update(Key.CI_TABLE_NAME,values,"id = ?",new String[] {carouselItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return update;
    }

    public boolean drop(CarouselItem carouselItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean drop = false;
        try{
            ContentValues values = new ContentValues();
            values.put(Key.GENERAL_COL_DELETED_AT, this.getDateTime());
            drop = db.update(Key.CI_TABLE_NAME,values,"id = ?",new String[] {carouselItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return drop;
    }

    public boolean delete(CarouselItem carouselItem){
        SQLiteDatabase db = this.getWritableDatabase();
        boolean delete = false;
        try{

            delete = db.delete(Key.CI_TABLE_NAME,"id = ?",new String[] {carouselItem.id.toString()}) > 0;
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return delete;
    }
}
