package com.unicode.muslimware.db;

import android.database.sqlite.SQLiteDatabase;

public class RunningTextItemBluePrint {

    //empty constructor
    RunningTextItemBluePrint(){}

    // cereate table running text item if not exist
    public static void createTable(SQLiteDatabase db){
        try {
            db.execSQL("CREATE TABLE "+Key.RTI_TABLE_NAME+" (" +
                    Key.GENERAL_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Key.RTI_COL_TEXT+" TEXT, " +
                    Key.RTI_COL_IS_ENABLE+" INTEGER DEFAULT 0, "+
                    Key.RTI_COL_CATEGORY+" INTEGER, "+
                    Key.GENERAL_COL_CREATED_AT+" DATETIME DEFAULT CURRENT_TIMESTAMP, "+
                    Key.GENERAL_COL_UPDATED_AT+" DATETIME DEFAULT '', "+
                    Key.GENERAL_COL_DELETED_AT+" DATETIME DEFAULT '')"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
