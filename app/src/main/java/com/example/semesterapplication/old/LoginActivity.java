//package com.example.semesterapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Spinner;
//
//public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//
//    private EditText username;
//    private EditText password;
//    private Spinner theme;
//    private Spinner language;
//    private Button signUp;
//    private Button logIn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.login);
//
//        username = findViewById(R.id.username);
//        password = findViewById(R.id.password);
//        theme = (Spinner) findViewById(R.id.themeSpinner);
//        language = (Spinner) findViewById(R.id.languageSpinner);
//        signUp = findViewById(R.id.signUp);
//        logIn = findViewById(R.id.login);
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
//
//
////TODO        signUp.setOnClickListener(new View.OnClickListener() {
////
////                                  }
////        );
//
//
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            //TODO
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//}