package com.example.mypc.hostelcare;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:9950159150"));
                startActivity(in);

            }
        });
        final Profile profile=new Profile();
        final Seat_Allotment seat_allotment=new Seat_Allotment();
        final Home home=new Home();
        setfragment(home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.seat_allot:
                        setfragment(seat_allotment);
                        return true;
                    case R.id.profile:
                        setfragment(profile);
                        return true;
                }
                return false;
            }
        };
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (count == 0) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
        } else {
            final Home home=new Home();
            setfragment(home);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            Intent intent=new Intent(MainActivity.this,Update_profile.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_settings1) {

            Intent intent=new Intent(MainActivity.this,ChangePassword
                    .class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.issue) {
            // Handle the camera action
            Intent intent=new Intent(MainActivity.this,Issue.class);
            startActivity(intent);
        }
        else if(id==R.id.home)
        {
            final Home home=new Home();

            setfragment(home);
        }
        else if(id==R.id.nav_send){
            Intent intent=new Intent(MainActivity.this,Permission.class);
            startActivity(intent);
        }
        else if (id == R.id.My_account) {
            Intent intent=new Intent(MainActivity.this,MY_Profile.class);
            startActivity(intent);
        } else if (id == R.id.myquery) {
            Intent intent=new Intent(MainActivity.this,Query.class);
            startActivity(intent);
        } else if (id == R.id.about_us) {
            Intent intent=new Intent(MainActivity.this,About_us.class);
            startActivity(intent);
        }  else if (id == R.id.contact_us) {
            Intent intent=new Intent(MainActivity.this,Contact_us.class);
            startActivity(intent);
        }
        else if (id == R.id.Terms) {
            Intent intent=new Intent(MainActivity.this,Terms.class);
            startActivity(intent);
        }
        else if(id==R.id.Log_out)
        {
            AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
            ad.setMessage("Do you want to Log Out").setCancelable(false)
                    .setPositiveButton("Log Out!!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                            startActivity(intent);

                        }
                    })
                    .setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alertDialog= ad.create();
            alertDialog.setTitle("Hostel care");
            alertDialog.show();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setfragment(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();

    }

}
