package com.example.grandhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class room_21 extends AppCompatActivity {
   EditText NoofNights;
    Button back_btn;
    Button booking_btn;
    SharedPreferences sp;
    String room_21_tot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_21);
        booking_btn=(Button)findViewById(R.id.booking_btn);
        back_btn=(Button) findViewById(R.id.back_btn);
        NoofNights=(EditText)findViewById(R.id.NoofNights);

        sp = getSharedPreferences("room_21", Context.MODE_PRIVATE);
        booking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room_21_tot=NoofNights.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("room_21_tot",room_21_tot);
                editor.commit();
                Toast.makeText(room_21.this,"Added number of nights",Toast.LENGTH_SHORT).show();
            }
        });



        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment1();
            }
        });




    }


    public void openfragment1(){


        Intent intent=new Intent(this, Fragment_double_rooms.class);
        startActivity(intent);








    }







}