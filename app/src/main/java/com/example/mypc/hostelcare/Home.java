package com.example.mypc.hostelcare;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Home extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_layout, container,
                false);
        TextView textView=(TextView)rootView.findViewById(R.id.title_home);
        Animation x;
        x= AnimationUtils.loadAnimation(getActivity(),R.anim.blink);
        textView.setVisibility(View.VISIBLE);
        textView.startAnimation(x);
        return rootView;
    }
}
