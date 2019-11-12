package com.example.sojun_homework1112;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText id,pas;
    String idstr,passtr;
    Button btn,loginbtn;
    ArrayList<String> idlist;
    ArrayList<String> paslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent=new Intent(this, ResisterActivity.class);
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

           }
       });

    }
}
