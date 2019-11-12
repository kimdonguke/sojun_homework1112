package com.example.sojun_homework1112;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class ResisterActivity extends AppCompatActivity {
    ArrayList<String> res_idlist;
    ArrayList<String> res_paslist;
    EditText rid,rpas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister);
    }
}
