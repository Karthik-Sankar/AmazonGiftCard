package com.example.amazongiftcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onStart() {
        super.onStart();

        AmazonCustomer customer = new AmazonCustomer();
        if(!customer.isUserSignedIn())
        {
            Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
            startActivity(intent);
        }
        else
        {
            TextView text = (TextView)findViewById(R.id.textview1);
            text.setText(customer.getEmail());
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
