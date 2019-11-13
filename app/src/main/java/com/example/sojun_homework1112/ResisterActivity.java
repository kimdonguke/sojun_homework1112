package com.example.sojun_homework1112;

import android.content.Context;
import android.content.Intent;
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
import org.json.JSONException;

import java.util.ArrayList;

public class ResisterActivity extends AppCompatActivity {


   ArrayList<String> res_idlist;
   ArrayList<String> res_paslist;
    EditText rid,rpas;
    String ridstr,rpasstr;
    Button resbtn;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister);
        res_idlist=new ArrayList<String>();
        res_paslist=new ArrayList<String>();
        res_idlist=getStringArrayPref(getApplicationContext(),"id");
        res_paslist=getStringArrayPref(getApplicationContext(),"pas");
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
                intent=new Intent(ResisterActivity.this,MainActivity.class);
                intent.putExtra("id",ridstr);
                intent.putExtra("pas",rpasstr);
                startActivity(intent);
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
        Toast.makeText(context, "ArrayList에 저장 성공!", Toast.LENGTH_SHORT).show();
    }
    private ArrayList<String> getStringArrayPref(Context context, String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = prefs.getString(key, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }

}