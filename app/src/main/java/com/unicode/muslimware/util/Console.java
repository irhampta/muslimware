package com.unicode.muslimware.util;

import android.util.Log;

import com.google.gson.Gson;

public class Console {
    public static void json(Object object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        Log.d("Object", json);
    }
}
