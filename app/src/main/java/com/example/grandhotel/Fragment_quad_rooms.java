package com.example.grandhotel;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Fragment_quad_rooms extends Fragment {
    @Nullable


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_quad_rooms, container, false);



        Button dinner_btn1 = (Button) view.findViewById(R.id.Dinner_btn1);

        Button  dinner_btn2= (Button) view.findViewById(R.id.Dinner_btn2);
        FloatingActionButton fabNext=(FloatingActionButton) view.findViewById(R.id.fabNext);



        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), MainActivity_booking4.class);
                startActivity(in);
            }
        });

        dinner_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Room_41.class);
                startActivity(in);
            }
        });





        dinner_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Room_42.class);
                startActivity(in);
            }
        });


        return view;
    }
}