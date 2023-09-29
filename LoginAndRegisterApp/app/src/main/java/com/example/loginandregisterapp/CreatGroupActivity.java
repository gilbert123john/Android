package com.example.loginandregisterapp;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import com.example.loginandregisterapp.databinding.ActivitySearchUserBinding;
public class CreatGroupActivity extends AppCompatActivity {
    ImageButton addButton;
    ImageButton backButton;
    ActivitySearchUserBinding binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivitySearchUserBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());
        backButton = findViewById(R.id.back_btn);

        backButton.setOnClickListener(v -> {
            onBackPressed();
        });

    }
}
