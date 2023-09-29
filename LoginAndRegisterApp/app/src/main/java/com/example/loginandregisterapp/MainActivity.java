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
        email = intent.getStringExtra("userName");
        String[] name = email.split("@");
        welcomeText.setText("Welcome "+name[0].toUpperCase().toString());

        binder.SearchGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), SearchUserActivity.class);
                //intent.putExtra("userName", userName);
                startActivity(intent);
            }
        });
        binder.addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Add Group", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), CreatGroupActivity.class);
                startActivity(intent);
            }
        });
    }

}