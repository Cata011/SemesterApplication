//package com.example.semesterapplication;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.lifecycle.ViewModelProvider;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import com.firebase.ui.auth.AuthUI;
//
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class SignIn_Activity extends AppCompatActivity {
//
//    private static final int RC_SIGN_IN = 50;
//    private SignInViewModel viewModel;
//    Button signIn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_in_);
//
////        GoogleSignInOptions gso =
////                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
////                        .requestIdToken(R.string.).requestEmail().build();
//
//        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
//        viewModel.getCurrentUser().observe(this, user -> {
//            if (user != null)
//                startActivity(new Intent(this, MainActivity.class));
//            finish();
//        });
//        signIn = findViewById(R.id.button_sign_in); //TODO: check
//        signIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signIn(v);
//            }
//        });
//    }
//
//    public void signIn(View v) {
////        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
////
////        if (firebaseUser != null) {
////            Toast.makeText(this, "Welcome" + firebaseUser.getDisplayName(), Toast.LENGTH_SHORT).show();
////
////        } else startLoginActivity();
//
//        List<AuthUI.IdpConfig> providers = Arrays.asList(
//                new AuthUI.IdpConfig.EmailBuilder().build(),
//                new AuthUI.IdpConfig.GoogleBuilder().build()
//        );
//
//        Intent signInIntent = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build();
//
//        startActivityForResult(signInIntent, RC_SIGN_IN);
//    }
//
////    public void singOut(View v) {
////        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
////            @Override
////            public void onComplete(@NonNull Task<Void> task) {
////                startLoginActivity();
////            }
////        });
//    }
