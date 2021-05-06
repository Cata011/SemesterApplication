package com.example.semesterapplication.old;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.semesterapplication.R;

public class EditProfileFragment extends Fragment
{
    EditText name;
    EditText phone;
    EditText email;
    Button cancel;
    Button save;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        name = view.findViewById(R.id.editTextName);
        phone = view.findViewById(R.id.editTextPhone);
        email = view.findViewById(R.id.email);
        cancel = view.findViewById(R.id.cancel_edit);
        save = view.findViewById(R.id.save_edit);

        //TODO: populate the fields with account details

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: go to content fragment
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: save details and go to previous fragment
            }
        });

        return view;
    }
}

//public class EditProfileFragment extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_edit_profile);
//    }
//}