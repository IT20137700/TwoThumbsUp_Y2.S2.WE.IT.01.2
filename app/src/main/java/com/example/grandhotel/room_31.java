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

public class room_31 extends AppCompatActivity {


    EditText NoofNights;
    Button back_btn;
    Button booking_btn;
    SharedPreferences sp;
    String room_31_tot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_31);
        booking_btn=findViewById(R.id.booking_btn);
        NoofNights=findViewById(R.id.NoofNights);

        back_btn=(Button) findViewById(R.id.back_btn);




        sp = getSharedPreferences("room_31", Context.MODE_PRIVATE);
        booking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room_31_tot=NoofNights.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("room_31",room_31_tot);
                editor.commit();
                Toast.makeText(com.example.grandhotel.room_31.this,"Added number of nights",Toast.LENGTH_SHORT).show();
            }
        });



        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment2();
            }
        });


    }

    public void openfragment2(){

        Intent intent=new Intent(this, Fragment_triple_rooms.class);
        startActivity(intent);



    }
}