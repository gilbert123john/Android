package com.example.simpleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onNext(View v){
        Intent obj;
        obj= new Intent("act.sec");//allocating memory for that object (it will go and check act.sec name in the manifest file)
        startActivity(obj);
    }
}