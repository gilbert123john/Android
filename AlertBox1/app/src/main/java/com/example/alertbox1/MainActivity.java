package com.example.alertbox1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onAlert(View v){
        AlertDialog.Builder obj = new AlertDialog.Builder(this);
        obj.setMessage(" Are you sure");
        obj.setCancelable(true);
        obj.show();
    }
}