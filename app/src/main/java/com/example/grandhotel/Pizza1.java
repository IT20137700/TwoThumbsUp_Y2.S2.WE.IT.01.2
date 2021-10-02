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

public class Pizza1 extends AppCompatActivity {
   EditText Noofpizza;
    Button back_btn;
    Button oder_btn;
    SharedPreferences sp;
    String peporoPizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza1);
        oder_btn=(Button)findViewById(R.id.oder_btn);
        back_btn=(Button) findViewById(R.id.back_btn);
        Noofpizza=(EditText)findViewById(R.id.Noofpizza);

        sp = getSharedPreferences("pizza1", Context.MODE_PRIVATE);
        oder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peporoPizza=Noofpizza.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("peporoPizza",peporoPizza);
                editor.commit();
                Toast.makeText(Pizza1.this,"added number of Pizza",Toast.LENGTH_SHORT).show();
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


        Intent intent=new Intent(this, Fragment1.class);
        startActivity(intent);








    }







}