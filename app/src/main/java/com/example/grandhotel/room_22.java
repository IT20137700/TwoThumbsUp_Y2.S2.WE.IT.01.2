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

public class room_22 extends AppCompatActivity {

    EditText NoofNights;
    Button back_btn;
    Button booking_btn;
    SharedPreferences sp;
    String room_22_tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_22);
        back_btn=(Button) findViewById(R.id.back_btn);
        booking_btn=findViewById(R.id.booking_btn);
        NoofNights=findViewById(R.id.NoofNights);

        sp = getSharedPreferences("room_22", Context.MODE_PRIVATE);
        booking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room_22_tot=NoofNights.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("NoofNights",room_22_tot);
                editor.commit();
                Toast.makeText(room_22.this,"Added number of nights",Toast.LENGTH_SHORT).show();
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