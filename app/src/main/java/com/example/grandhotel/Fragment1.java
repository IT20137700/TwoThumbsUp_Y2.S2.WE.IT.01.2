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


public class Fragment1 extends Fragment {
    @Nullable


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_1, container, false);



        Button lunch_btn2 = (Button) view.findViewById(R.id.Burger_btn3);
        Button lunch_btn3 = (Button) view.findViewById(R.id.D3);
        Button lunch_btn4 = (Button) view.findViewById(R.id.P3);
        FloatingActionButton fabNext=(FloatingActionButton) view.findViewById(R.id.fabNext);







        lunch_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Pizza1.class);
                startActivity(in);
            }
        });



        lunch_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Pizza2.class);
                startActivity(in);
            }
        });


        lunch_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), Pizza3.class);
                startActivity(in);
            }
        });

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), MainActivity4.class);
                startActivity(in);
            }
        });
        return view;
    }
}