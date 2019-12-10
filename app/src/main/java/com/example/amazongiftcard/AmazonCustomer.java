package com.example.amazongiftcard;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AmazonCustomer {
    String email;
    String password;
    private FirebaseAuth auth;
    void AmazonCustomer(){
            auth = FirebaseAuth.getInstance();
    }
    //Check whether user is signed in or not!
    boolean isUserSignedIn()
    {
        FirebaseUser user = auth.getCurrentUser();
        if(user!=null)
            return true;
        return false;
    }

    void signUp(String email, String password)
    {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Log.d("USERSIGNUP : ", "Sucessfully signed up!");
                }
                else
                {
                    Log.d("USERSIGNUP : ", "Signup error!");
                }
            }
        });
    }

    void signIn(String email, String password)
    {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Log.d("USERSIGNIN : ", "Sucessfully signed in!");
                }
                else
                {
                    Log.d("USERSIGNIN : ", "Signin error!");
                }
            }
        });
    }

    void logOut()
    {
        auth.signOut();
    }

    String getEmail()
    {
        return auth.getCurrentUser().getEmail();
    }
}
