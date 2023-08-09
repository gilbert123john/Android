package com.example.mvc_db_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText e2,e3;
    CDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        db = new CDB(this);
    }
    public void onAdd(View v){
        CDept rec = new CDept();
        rec.dname = e2.getText().toString();
        rec.dloc = e3.getText().toString();
        db.addDept(rec);
        e2.setText("");
        e3.setText("");
    }
    public void onList(View v){
        List<CDept> rec = db.getAllValues();
        String str = "";
        for(CDept cr : rec ){
            String log = "Did: "+ cr.id + " , DNAME: "+ cr.dname +", DLOC: "+cr.dloc;
            log = log+"\n";
            str = str + log;
        }
        TextView t = (TextView) findViewById(R.id.tv);
        t.setText(str);
    }

}