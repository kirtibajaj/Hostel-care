package com.example.mypc.hostelcare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Seat_Allotment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.seat_layout, container,
                false);
        String[] floor={"Floor1","Floor2","Floor3","Floor4","Floor5","Floor6"};
        String[] year={"4th year","3rd year","2nd year","1st year","1st year","Non ac"};
        ListAdapterf listAdapterf;
        ListView list;
        list=(ListView)rootView.findViewById(R.id.list_floor);
        listAdapterf=new ListAdapterf(getActivity(),floor,year);
        list.setAdapter(listAdapterf);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item=((TextView)view).getText().toString();
                Intent intent=new Intent(getActivity(),Room.class);
                //intent.putExtra("name",item);
                startActivity(intent);

            }
        });
        return rootView;
    }

}
class ListAdapterf extends BaseAdapter {
    Context context;

    String[] Floor;
    String[] Year;
    LayoutInflater inflater;

    public ListAdapterf(Context context, String[] floor,String[] year) {

        this.context = context;
        this.Year=year;
        this.Floor = floor;
    }

    public int getCount() {
        return Floor.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        TextView floor;
        TextView year;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.single_list_seat_layout, parent, false);
        floor = (TextView) itemView.findViewById(R.id.floor_message);
        year=(TextView)itemView.findViewById(R.id.year_card_list);
        floor.setText(Floor[position]);
        year.setText(Year[position]);
        return itemView;
    }
}
