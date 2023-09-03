package com.example.loginandregisterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loginandregisterapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binder;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binder.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binder.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binder.registerName.getText().toString();
                String phoneNumber = binder.registerPhoneNumber.getText().toString();
                String confirmPhoneNumber = binder.registerConfirmPhone.getText().toString();
                String address = binder.txtAddress.getText().toString();


                if(userName.equals("") || phoneNumber.equals("") || confirmPhoneNumber.equals("")|| address.equals("")){
                    Toast.makeText(RegisterActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
                }else{
                if(phoneNumber.equals(confirmPhoneNumber)){
                    boolean checkUserEmail = databaseHelper.checkPhone(phoneNumber);

                    if(checkUserEmail == false){
                        boolean insert = databaseHelper.insertData(phoneNumber,userName,address);

                        if(insert == true){
                            Toast.makeText(RegisterActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "User already Exist", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }
                }
            }
        });

        binder.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}