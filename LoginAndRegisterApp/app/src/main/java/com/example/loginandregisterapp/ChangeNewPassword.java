package com.example.loginandregisterapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandregisterapp.databinding.ActivityChangepasswordBinding;
import com.example.loginandregisterapp.databinding.ActivityMainBinding;

public class ChangeNewPassword extends AppCompatActivity {
    ActivityChangepasswordBinding binding;
    DatabaseHelper databaseHelper;

    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangepasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPassword = binding.oldPwd.getText().toString();
                String newPassword = binding.newPwd.getText().toString();
                String confirmPassword = binding.confirmPwd.getText().toString();

                if(oldPassword.equals("") || newPassword.equals("") || confirmPassword.equals("")){
                    Toast.makeText(ChangeNewPassword.this, "All Fields are required", Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkCredentials = databaseHelper.checkEmailPassword(email,oldPassword);
                    if(checkCredentials == true){
                        if(newPassword.equals(confirmPassword)){
                            databaseHelper.updatePassword(email,oldPassword,newPassword);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(ChangeNewPassword.this, "new password miss match", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ChangeNewPassword.this, "Password miss match", Toast.LENGTH_SHORT).show();
                    }
                }
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
            }
        });
    }
}
