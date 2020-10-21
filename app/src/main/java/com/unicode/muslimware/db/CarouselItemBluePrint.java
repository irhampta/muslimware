package com.unicode.muslimware.db;

import android.database.sqlite.SQLiteDatabase;

public class CarouselItemBluePrint {

    //empty constructor
    CarouselItemBluePrint(){}

    // cereate table running text item if not exist
    public static void createTable(SQLiteDatabase db){
        try {
            db.execSQL("CREATE TABLE "+Key.CI_TABLE_NAME+" (" +
                    Key.GENERAL_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Key.CI_COL_PATH+" TEXT DEFAULT '', " +
                    Key.CI_COL_IS_ASSETS+" INTEGER DEFAULT 0, "+
                    Key.CI_COL_CREDITS+" TEXT DEFAULT '', "+
                    Key.CI_COL_IS_ENABLE+" INTEGER DEFAULT 0, "+
                    Key.GENERAL_COL_CREATED_AT+" DATETIME DEFAULT CURRENT_TIMESTAMP, "+
                    Key.GENERAL_COL_UPDATED_AT+" DATETIME DEFAULT '', "+
                    Key.GENERAL_COL_DELETED_AT+" DATETIME DEFAULT '')"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
