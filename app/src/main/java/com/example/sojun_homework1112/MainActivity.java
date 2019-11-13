package com.example.sojun_homework1112;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText id,pas;
    String idstr,passtr;
    Button btn,loginbtn;
    ArrayList<String> idlist;
    ArrayList<String> paslist;
    Intent intent;
    int chid,chpas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idlist=getStringArrayPref(getApplicationContext(),"id");
        paslist=getStringArrayPref(getApplicationContext(),"pas");
       intent=new Intent(this, ResisterActivity.class);
        id=findViewById(R.id.Login_id);
        pas=findViewById(R.id.Login_pas);
        btn=findViewById(R.id.resister_btn);
        loginbtn=findViewById(R.id.Login_btn);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              startActivity(intent);
           }
       });
       loginbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               idstr=id.getText().toString();
               passtr=pas.getText().toString();
               if(idlist.contains(idstr)){
                   chid=1;
               }
               else{
                   chid=0;
               }
               if(paslist.contains(passtr)){
                   chpas=1;
               }
               else{
                   chpas=0;
               }
               if(chid==0&&chpas==0){
                   Toast.makeText(MainActivity.this, "id 와 password 모두 틀렷습니다", Toast.LENGTH_SHORT).show();
               }
               else if(chid==1&&chpas==0){
                   Toast.makeText(MainActivity.this, "password 가 틀렸습니다", Toast.LENGTH_SHORT).show();
               }
               else if(chid==0&&chpas==1){
                   Toast.makeText(MainActivity.this, "일치하는 id가 없습니다", Toast.LENGTH_SHORT).show();
               }
               else{

               }

           }
       });
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
