package com.example.mypc.hostelcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Room_divided extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_divided);
        Button b=(Button)findViewById(R.id.submit_room_select);
        EditText e=(EditText)findViewById(R.id.code_room);
        final String x=e.getText().toString();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Room_divided.this, "Room "+x+"Booked", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Room_divided.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Room_divided.this,MainActivity.class);
        startActivity(intent);
    }
}
