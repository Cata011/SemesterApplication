package com.example.semesterapplication.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.semesterapplication.R;

import java.util.Locale;


public class SettingsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner theme;
    Spinner language;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        theme = view.findViewById(R.id.themeSpinner);
        language = view.findViewById(R.id.languageSpinner);


        ArrayAdapter<CharSequence> themeAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.themes, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> languageAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.languages, android.R.layout.simple_spinner_dropdown_item);

        themeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        theme.setAdapter(themeAdapter);
        language.setAdapter(languageAdapter);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.languageSpinner:
                String selectedOption = (String) parent.getItemAtPosition(position);
                Locale myLocale = new Locale(selectedOption);
                Resources resources = getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                Configuration configuration = resources.getConfiguration();
                configuration.locale = myLocale;
                resources.updateConfiguration(configuration, displayMetrics);

//                Locale.setDefault(locale);
//                Resources resources = getActivity().getResources();
//                Configuration configuration = resources.getConfiguration();
//                configuration.setLocale(locale);
//                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                break;
            case R.id.themeSpinner: //TODO: wtf?
                String selectedOption1 = (String) parent.getItemAtPosition(position);
                switch (selectedOption1) {
                    case "Light":
                        DrawerLayout myLayout = new DrawerLayout(new ContextThemeWrapper(getActivity(), R.style.Theme_SemesterApplicationLight), null, 0);
                        break;
                    case "Dark":
                        DrawerLayout myLayout1 = new DrawerLayout(new ContextThemeWrapper(getActivity(), R.style.Theme_SemesterApplicationDark), null, 0);
                        break;
                    default:
                }
            default:
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

