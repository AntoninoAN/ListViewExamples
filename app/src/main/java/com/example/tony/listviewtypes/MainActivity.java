package com.example.tony.listviewtypes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_lvvh,btn_lvwovh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_lvvh=(Button) findViewById(R.id.btnLvvH);
        btn_lvvh.setOnClickListener(this);
        btn_lvwovh= (Button) findViewById(R.id.btnLvWOvH);
        btn_lvwovh.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnLvvH:
                sendToLvVH();
                break;
            case R.id.btnLvWOvH:
                sendToWOLvVH();
                break;
        }
    }
    public void sendToLvVH( ){
        Intent intent= new Intent(MainActivity.this,ListViewviewHolder.class);
        startActivity(intent);
    }
    public void sendToWOLvVH( ){
        Intent intent= new Intent(MainActivity.this,ListViewWOviewHolder.class);
        startActivity(intent);
    }
}
