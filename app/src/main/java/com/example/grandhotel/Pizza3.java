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

public class Pizza3 extends AppCompatActivity {
    SharedPreferences sp;
    Button back_btn;
    EditText Noofpizza;
    Button oder_btn;
    String VegPizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza3);
        back_btn=(Button) findViewById(R.id.back_btn);
        oder_btn=findViewById(R.id.oder_btn);
        Noofpizza=findViewById(R.id.Noofpizza);


        sp = getSharedPreferences("pizza3", Context.MODE_PRIVATE);
        oder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VegPizza=Noofpizza.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("VegPizza",VegPizza);
                editor.commit();
                Toast.makeText(Pizza3.this,"added number of Pizza",Toast.LENGTH_SHORT).show();
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