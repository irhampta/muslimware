package com.unicode.muslimware.db;

import android.database.sqlite.SQLiteDatabase;

public class FinanceItemBluePrint {

    //empty constructor
    FinanceItemBluePrint(){}

    // cereate table running text item if not exist
    public static void createTable(SQLiteDatabase db){
        try {
            db.execSQL("CREATE TABLE "+Key.FI_TABLE_NAME+" (" +
                    Key.GENERAL_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Key.FI_COL_DATE_TIME+" DATETIME DEFAULT CURRENT_TIMESTAMP, " +
                    Key.FI_COL_TYPE+" INTEGER DEFAULT 1, "+
                    Key.FI_COL_DESCRIPTION+" TEXT DEFAULT '', "+
                    Key.FI_COL_AMOUNT+" REAL DEFAULT 0.0, "+
                    Key.GENERAL_COL_CREATED_AT+" DATETIME DEFAULT CURRENT_TIMESTAMP, "+
                    Key.GENERAL_COL_UPDATED_AT+" DATETIME DEFAULT '', "+
                    Key.GENERAL_COL_DELETED_AT+" DATETIME DEFAULT '')"
            );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
