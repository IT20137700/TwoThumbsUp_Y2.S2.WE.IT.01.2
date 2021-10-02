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

public class burger3 extends AppCompatActivity {
    Button back_btn;
    EditText Noofpizza;
    Button oder_btn;
    SharedPreferences sp;
    String PizzaNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger3);
        back_btn=(Button) findViewById(R.id.back_btn);
        oder_btn=findViewById(R.id.oder_btn);
        Noofpizza=findViewById(R.id.Noofpizza);

        sp = getSharedPreferences("burger3", Context.MODE_PRIVATE);
        oder_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PizzaNum=Noofpizza.getText().toString();
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("DburgerNo",PizzaNum);
                editor.commit();
                Toast.makeText(burger3.this,"added number of pizza",Toast.LENGTH_SHORT).show();
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

        Intent intent=new Intent(this, Fragment2.class);
        startActivity(intent);



    }
}