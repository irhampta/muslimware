package com.unicode.muslimware.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.unicode.muslimware.R;
import com.unicode.muslimware.db.CarouselItemCRUD;
import com.unicode.muslimware.db.RunningTextItemCRUD;
import com.unicode.muslimware.db.SettingsCRUD;
import com.unicode.muslimware.model.CarouselItem;
import com.unicode.muslimware.model.RunningTextItem;
import com.unicode.muslimware.model.Settings;
import com.unicode.muslimware.util.Console;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    Settings settings;
    SettingsCRUD settingsCRUD = new SettingsCRUD(SettingActivity.this);

    ArrayList<RunningTextItem> runningTextItems;
    RunningTextItemCRUD runningTextItemCRUD = new RunningTextItemCRUD(SettingActivity.this);

    ArrayList<CarouselItem> carouselItems;
    CarouselItemCRUD carouselItemCRUD = new CarouselItemCRUD(SettingActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);



    }

    @Override
    protected void onStart() {
        super.onStart();

//        boolean create = runningTextItemCRUD.create(new RunningTextItem());
//        if (create) {
//            System.out.println("rti success created");
//        } else {
//            System.out.println("rti failed created");
//        }

//        runningTextItems = runningTextItemCRUD.readAll();
//
//        Console.json(runningTextItems);
//
//        boolean creates = carouselItemCRUD.create(new CarouselItem());
//        if (creates) {
//            System.out.println("ci success created");
//        } else {
//            System.out.println("ci failed created");
//        }
//        carouselItems = carouselItemCRUD.readAll();
//
//        Console.json(carouselItems);


    }
}