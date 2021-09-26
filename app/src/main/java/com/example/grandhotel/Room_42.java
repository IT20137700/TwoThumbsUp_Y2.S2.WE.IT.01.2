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

public class Room_42 extends AppCompatActivity {
    Button back_btn;
    EditText NoofNights;
    Button booking_btn;
    SharedPreferences sp;
    String room_42_tot;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_42);

        back_btn=(Button) findViewById(R.id.back_btn);
        booking_btn=findViewById(R.id.booking_btn);
        NoofNights=findViewById(R.id.NoofNights);

        sp = getSharedPreferences("room_42", Context.MODE_PRIVATE);
        booking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room_42_tot=NoofNights.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("room_42_tot",room_42_tot);
                editor.commit();
                Toast.makeText(Room_42.this,"Added number of nights",Toast.LENGTH_SHORT).show();
            }
        });




        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment3();
            }
        });

    }


    public void openfragment3(){

        Intent intent=new Intent(this, Fragment_quad_rooms.class);
        startActivity(intent);



    }

}