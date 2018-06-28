package com.example.mypc.hostelcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context context;
    String[] Purpose;
    String[] Time;
    String[] Approve;
    String[] Date;
    LayoutInflater inflater;

    public ListAdapter(Context context, String[] purpose, String[] time, String[] approve,String[] date) {

        this.context = context;

        this.Purpose = purpose;
        this.Time = time;
        this.Date=date;
        this.Approve = approve;
    }
    public int getCount() {
        return Purpose.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        TextView purpose;
        TextView approve;
        TextView time;
        TextView date;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.activity_single, parent, false);
        purpose = (TextView) itemView.findViewById(R.id.activity_message);
        approve = (TextView) itemView.findViewById(R.id.message_Approval);
        time = (TextView) itemView.findViewById(R.id.message_time);
        date=(TextView)itemView.findViewById(R.id.message_date);
        purpose.setText(Purpose[position]);
        approve.setText(Approve[position]);
        time.setText(Time[position]);
        date.setText(Date[position]);
        return itemView;
    }

}
