//package com.example.semesterapplication;
//
//import androidx.lifecycle.LiveData;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//public class User extends LiveData<FirebaseUser> {
//    public String email;
//    public String password;
//    //private final FirebaseAuth.AuthStateListener listener = firebaseAuth -> setValue(firebaseAuth.getCurrentUser());
//
//    public User()
//    {
//
//    }
//
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    public void writeNewUser(String userId, String email, String password)
//    {
//        User user = new User(email, password);
//        //TODO: my ref
//    }
//}
