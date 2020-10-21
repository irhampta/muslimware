package com.unicode.muslimware.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.unicode.muslimware.R;
import com.unicode.muslimware.activity.SettingActivity;
import com.unicode.muslimware.db.SettingsCRUD;
import com.unicode.muslimware.model.Settings;
import com.unicode.muslimware.util.Console;

public class FragmentMain1 extends Fragment{
    Settings settings;
    SettingsCRUD settingsCRUD;

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment__main_1, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
       TextView textView = view.findViewById(R.id.textView1);

       settingsCRUD = new SettingsCRUD(getContext());
       settings = settingsCRUD.read();
       textView.setText(settings.profile.firstName);
    }
}
