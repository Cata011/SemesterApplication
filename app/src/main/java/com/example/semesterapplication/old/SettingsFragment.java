package com.example.semesterapplication.old;

import android.content.res.Configuration;
import android.graphics.Region;
import android.os.Bundle;

import com.example.semesterapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class SettingsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner theme;
    Spinner language;
    Button logoff;
    Locale locale;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        theme = view.findViewById(R.id.themeSpinner);
        language = view.findViewById(R.id.languageSpinner);
        logoff = view.findViewById(R.id.logoff);

        ArrayAdapter<CharSequence> themeAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.themes, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> languageAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.languages, android.R.layout.simple_spinner_dropdown_item);

        themeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        theme.setAdapter(themeAdapter);
        language.setAdapter(languageAdapter);

        logoff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: log off the user
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.languageSpinner:
                String selectedOption = (String) parent.getItemAtPosition(position);
                locale = new Locale(selectedOption);
                Locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getActivity().getBaseContext().getResources().updateConfiguration(configuration,
                        getActivity().getBaseContext().getResources().getDisplayMetrics());
                break;
            case R.id.themeSpinner: //TODO: wtf?
                String selectedOption1 = (String) parent.getItemAtPosition(position);
                switch (selectedOption1) {
                    case "Light":
                        break;
                    case "Dark":
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

//public class SettingsFragment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//
//    private Spinner theme;
//    private Spinner language;
//    private Button logoff;
//    private Locale locale;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_settings);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        theme = (Spinner) findViewById(R.id.themeSpinner);
//        language = (Spinner) findViewById(R.id.languageSpinner);
//        logoff = findViewById(R.id.logoff);
//
//        ArrayAdapter<CharSequence> themeAdapter = ArrayAdapter.createFromResource(this, R.array.themes, android.R.layout.simple_spinner_dropdown_item);
//        ArrayAdapter<CharSequence> languageAdapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_dropdown_item);
//
//        themeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        theme.setAdapter(themeAdapter);
//        language.setAdapter(languageAdapter);
//
//        logoff.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                //TODO: log off the user
//            }
//        });
//
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        switch (parent.getId()) {
//            case R.id.languageSpinner:
//                String selectedOption = (String) parent.getItemAtPosition(position);
//                locale = new Locale(selectedOption);
//                Locale.setDefault(locale);
//                Configuration configuration = new Configuration();
//                configuration.locale = locale;
//                getBaseContext().getResources().updateConfiguration(configuration,
//                        getBaseContext().getResources().getDisplayMetrics());
//                break;
//            case R.id.themeSpinner: //TODO: wtf?
//                String selectedOption1 = (String) parent.getItemAtPosition(position);
//                switch (selectedOption1) {
//                    case "Light":
//                        break;
//                    case "Dark":
//                        break;
//                    default:
//                }
//            default:
//        }
//
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//}