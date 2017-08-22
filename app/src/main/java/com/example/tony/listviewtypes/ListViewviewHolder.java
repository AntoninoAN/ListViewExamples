package com.example.tony.listviewtypes;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListViewviewHolder extends AppCompatActivity {
    ListView listViewvh;
    ArrayList<String> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewview_holder);
        listViewvh=(ListView)findViewById(R.id.lvvh);
        listItems=createItems();
        CustomAdapter adapter= new CustomAdapter(ListViewviewHolder.this,
                R.layout.view_item_view_holder,
                listItems);
        listViewvh.setAdapter(adapter);
    }
    private class CustomAdapter extends ArrayAdapter<String>{
        int layoutItemId;
        Context localContext;
        ArrayList<String> data;

        public CustomAdapter(Context localContext, int layoutItemId, ArrayList<String> data) {
            super(localContext, layoutItemId, data);
            this.layoutItemId = layoutItemId;
            this.localContext = localContext;
            this.data = data;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolderItem viewHolder;
            //View mconvertView=convertView;
            String value=getItem(position);
            if(convertView==null){
                LayoutInflater layoutInflater= ((Activity)localContext).getLayoutInflater();
                convertView=layoutInflater.inflate(layoutItemId,parent,false);
                /*mconvertView= LayoutInflater.from(getContext()).inflate(R.layout.view_item_view_holder,
                        parent,
                        false);*/
                viewHolder=new ViewHolderItem();
                viewHolder.textItem=(TextView)convertView.findViewById(R.id.tv_items);
                convertView.setTag(viewHolder);
            }
            else {
                viewHolder = (ViewHolderItem) convertView.getTag();
            }
            //String values=data.get(position);
            if(value!=null)
                viewHolder.textItem.setText(value);
            return convertView;
        }


    }

    static class ViewHolderItem {
        TextView textItem;
    }
    public ArrayList<String> createItems(){
        ArrayList<String>newItems= new ArrayList<>();
        for(int i=0;i<5000;i++){
            newItems.add("New Item No."+String.valueOf(i));
        }
        return newItems;
    }
}
