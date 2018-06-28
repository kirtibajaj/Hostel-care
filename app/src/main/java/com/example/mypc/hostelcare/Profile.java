package com.example.mypc.hostelcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Profile extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.profile_layout, container,
                false);
        String[] purpose={"Home","for Shopping","for Hangout","Local guardian","health check up","Cafe with friends"};
        String[] time={"5:00PM","9:00AM","12:30AM","7:00AM","10:00AM","3:00PM"};
        String[] approve={"Approved","Approved","Rejected","Approved","Approved","Rejected"};
        String[] date={"20/5/2018","29/03/2018","24/03/2018","2/4/2018","6/4/2018","20/4/2018"};
        ListView list;
        ListAdapter listAdapter;
        list=(ListView)rootView.findViewById(R.id.list_activities);
        listAdapter=new ListAdapter(getActivity(),purpose,time,approve,date);
        list.setAdapter(listAdapter);
       /* Button b=(Button)rootView.findViewById(R.id.add_permission_request);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Permission.class);
                startActivity(intent);
            }
        });
*/
        return rootView;

    }
}
