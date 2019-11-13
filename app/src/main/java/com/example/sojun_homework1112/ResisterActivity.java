package com.example.sojun_homework1112;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

public class ResisterActivity extends AppCompatActivity {


    ArrayList<String> res_idlist;
    ArrayList<String> res_paslist;
    EditText rid,rpas;
    String ridstr,rpasstr;
    Button resbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rid=findViewById(R.id.res_id);
        rpas=findViewById(R.id.res_pas);
        resbtn=(Button)findViewById(R.id.res_submitbtn);
        resbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ridstr=rid.getText().toString();
                rpasstr=rpas.getText().toString();
                res_idlist.add(ridstr);
                res_paslist.add(rpasstr);
                setStringArrayPref(getApplicationContext(),"id",res_idlist);
                setStringArrayPref(getApplicationContext(),"pas",res_paslist);
                Toast.makeText(ResisterActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void setStringArrayPref(Context context, String key, ArrayList<String> values) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
    }

}