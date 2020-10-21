package com.unicode.muslimware.db;


public class Key {
    // empty cunstractor
    Key(){}
        // general colmn name
        public static final String GENERAL_COL_ID= "id";
        public static final String GENERAL_COL_CREATED_AT= "created_at";
        public static final String GENERAL_COL_UPDATED_AT= "updated_at";
        public static final String GENERAL_COL_DELETED_AT= "delete_at";


        // table name and colmn name settings table
        public static final String SETTINGS_TABLE_NAME = "settings";
        public static final String SETTINGS_COL_PROFILE = "profile";
        public static final String SETTINGS_COL_RUNNING_TEXT = "running_text";
        public static final String SETTINGS_COL_CAROUSEL = "carousel";
        public static final String SETTINGS_COL_FINANCE = "finance";
        public static final String SETTINGS_COL_DISPLAY = "display";
        public static final String SETTINGS_COL_SOUND = "sound";
        public static final String SETTINGS_COL_ALARM = "alarm";
        public static final String SETTINGS_COL_SECURITY = "security";
        public static final String SETTINGS_COL_DATE_AND_TIME = "date_and_time";

        // table name and colmn name RTI (running texts item) table related to RunningText
        public static final String RTI_TABLE_NAME = "running_text_item";
        public static final String RTI_COL_TEXT = "text";
        public static final String RTI_COL_CATEGORY = "category";
        public static final String RTI_COL_IS_ENABLE = "is_enable";


        // table name and colmn name CI (carousel item) table related to Carousel
        public static final String CI_TABLE_NAME = "carousel_item";
        public static final String CI_COL_PATH = "path";
        public static final String CI_COL_IS_ASSETS = "is_assets";
        public static final String CI_COL_CREDITS = "credits";
        public static final String CI_COL_IS_ENABLE = "is_enable";

        // table name and colmn name FI (Finance Item) table related to Finance
        public static final String FI_TABLE_NAME = "finance_item";
        public static final String FI_COL_DATE_TIME = "date_time";
        public static final String FI_COL_TYPE = "type";
        public static final String FI_COL_DESCRIPTION = "description";
        public static final String FI_COL_AMOUNT = "amount";

}
