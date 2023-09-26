package com.example.downloadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onStartDownload(View v){
        EditText e = (EditText)findViewById(R.id.t1);
        String qs = e.getText().toString();
        try
        {

            URL url = new URL(qs);
            URLConnection conexion = url.openConnection();
            conexion.connect();

            int lenghtOfFile = conexion.getContentLength();
            Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

            InputStream input = new BufferedInputStream(url.openStream());
            OutputStream output = new FileOutputStream("/sdcard/Download/test.pdf");

            byte data[] = new byte[1024];
            int count;
            long total = 0;

            while ((count = input.read(data)) != -1)
            {
                total += count;
                //publishProgress(""+(int)((total*100)/lenghtOfFile));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }

}