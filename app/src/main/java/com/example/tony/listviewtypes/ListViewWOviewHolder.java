package com.example.tony.listviewtypes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListViewWOviewHolder extends AppCompatActivity {
    ListView listViewWOvh;
    List<String> listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_woview_holder);
        listViewWOvh=(ListView)findViewById(R.id.lvwovh);
        listItem=createItems();
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(
                ListViewWOviewHolder.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listItem
        );

        listViewWOvh.setAdapter(arrayAdapter);
    }
    public ArrayList<String> createItems(){
        ArrayList<String>newItems= new ArrayList<>();
        for(int i=0;i<5000;i++){
            newItems.add("New Item No."+String.valueOf(i));
        }
        return newItems;
    }
}
