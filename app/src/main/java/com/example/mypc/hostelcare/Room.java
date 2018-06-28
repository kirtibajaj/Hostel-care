package com.example.mypc.hostelcare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Room extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        String[] values={"101","102","103","104","105","106","107","108","109","110","111","112","113","114","115"};
        GridView gridView=(GridView)findViewById(R.id.grid_rooms);
        GridAdapter ga=new GridAdapter(this,values);
        gridView.setAdapter(ga);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(Room.this,Room_divided.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

    class GridAdapter extends BaseAdapter {
        Context context;
        private String[] values;
        View view;
        LayoutInflater layoutInflater;

        public GridAdapter(Context c, String[] values) {
            context = c;
            this.values = values;
        }

        @Override
        public int getCount() {
            return values.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View Vview, ViewGroup viewGroup) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (Vview == null) {
                view = new View(context);
                view = layoutInflater.inflate(R.layout.single_room_layout, null);

                TextView textView = (TextView) view.findViewById(R.id.room_no);
                textView.setText("Room no:" + values[position]);
            }
            return view;
        }
    }
