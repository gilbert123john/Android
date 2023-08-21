package com.example.loginandregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginandregisterapp.databinding.ActivityMainBinding;
import com.example.loginandregisterapp.databinding.ActivityRegisterBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binder;
    TextView welcomeText;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());
        //setContentView(R.layout.activity_main);
        welcomeText = findViewById(R.id.welcomeText1);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        String[] name = email.split("@");
        welcomeText.setText("Welcome "+name[0].toUpperCase().toString());

        binder.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Logout "+name[0].toUpperCase(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        binder.changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangeNewPassword.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}