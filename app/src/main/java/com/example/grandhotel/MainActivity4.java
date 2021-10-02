package com.example.grandhotel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {
    EditText Pi1;
    EditText Pi2;
    EditText Pi3;
    EditText Bu1;
    EditText Bu2;
    EditText Bu3;
    EditText Ju4;
    EditText Ju2;
    EditText Ju3;
    Button back_btn;

    Button confirm_btn;
    Button clear_btn;
    Button view_btn;
    Button Update_btn;
    Button Delete_btn;
    TextView tv_bill;

    FoodOrder obFOder;
    EditText et_name;
    EditText et_number;


    DatabaseReference db;
    String Piz1;
    String Piz2;
    String Piz3;
    String Dri1;
    String Dri2;
    String Dri3;
    String Bur1;
    String Bur2;
    String Bur3;


    int NumPiz1 = 0;
    int NumPiz2 = 0;
    int NumPiz3 = 0;
    int NumBu1 = 0;
    int NumBu2 = 0;
    int NumBu3 = 0;
    int NumJu4 = 0;
    int NumJu2 = 0;
    int NumJu3 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv_bill = findViewById(R.id.tv_bill);
        et_name = findViewById(R.id.et_name);
        et_number = findViewById(R.id.et_number);
        confirm_btn = findViewById(R.id.confirm_btn);

        obFOder = new FoodOrder();


        // fetch number of plates in the cart
        Pi1 = findViewById(R.id.Pi1);
        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("pizza1", Context.MODE_PRIVATE);
        Piz1 = sp1.getString("peporoPizza", "");
        Pi1.setText(Piz1);
        if (Piz1 != null && Piz1.length() > 0) {
            NumPiz1 = Integer.parseInt(Piz1);
        }

        Pi2 = findViewById(R.id.Pi2);
        SharedPreferences sp2 = getApplicationContext().getSharedPreferences("pizza2", Context.MODE_PRIVATE);
        Piz2 = sp2.getString("cheesepizza", "");
        Pi2.setText(Piz2);
        if (Piz2 != null && Piz2.length() > 0) {
            NumPiz2 = Integer.parseInt(Piz2);
        }

        Pi3 = findViewById(R.id.Pi3);
        SharedPreferences sp3 = getApplicationContext().getSharedPreferences("pizza3", Context.MODE_PRIVATE);
        Piz3 = sp3.getString("VegPizza", "");
        Pi3.setText(Piz3);
        if (Piz3 != null && Piz3.length() > 0) {
            NumPiz3 = Integer.parseInt(Piz3);
        }

        Bu1 = findViewById(R.id.Bu1);
        SharedPreferences sp4 = getApplicationContext().getSharedPreferences("burger1", Context.MODE_PRIVATE);
        Bur1 = sp4.getString("BurgerNo1", "");
        Bu1.setText(Bur1);
        if (Bur1 != null && Bur1.length() > 0) {
            NumBu1 = Integer.parseInt(Bur1);
        }

        Bu2 = findViewById(R.id.Bu2);
        SharedPreferences sp5 = getApplicationContext().getSharedPreferences("burger2", Context.MODE_PRIVATE);
        Bur2 = sp5.getString("cheeseNo", "");
        Bu2.setText(Bur2);
        if (Bur2 != null && Bur2.length() > 0) {
            NumBu2 = Integer.parseInt(Bur2);
        }


        Bu3 = findViewById(R.id.Bu3);
        SharedPreferences sp6 = getApplicationContext().getSharedPreferences("burger3", Context.MODE_PRIVATE);
        Bur3 = sp6.getString("DburgerNo", "");
        Bu3.setText(Bur3);
        if (Bur3 != null && Bur3.length() > 0) {
            NumBu3 = Integer.parseInt(Bur3);
        }


        Ju4 = findViewById(R.id.Ju4);
        SharedPreferences sp7 = getApplicationContext().getSharedPreferences("juice1", Context.MODE_PRIVATE);
        Dri1 = sp7.getString("MangoNo", "");
        Ju4.setText(Dri1);
        if (Dri1 != null && Dri1.length() > 0) {
            NumJu4 = Integer.parseInt(Dri1);
        }

        Ju2 = findViewById(R.id.Ju2);
        SharedPreferences sp8 = getApplicationContext().getSharedPreferences("juice2", Context.MODE_PRIVATE);
        Dri2 = sp8.getString("AvacadoNo", "");
        Ju2.setText(Dri2);
        if (Dri2 != null && Dri2.length() > 0) {
            NumJu2 = Integer.parseInt(Dri2);
        }

        Ju3 = findViewById(R.id.Ju3);
        SharedPreferences sp9 = getApplicationContext().getSharedPreferences("juice3", Context.MODE_PRIVATE);
        Dri3 = sp9.getString("stawberyNo", "");
        Ju3.setText(Dri3);
        if (Dri3 != null && Dri3.length() > 0) {
            NumJu3= Integer.parseInt(Dri3);
        }


        int billAmount = Totalbill(NumPiz1, NumPiz2, NumPiz3, NumBu1, NumBu2, NumBu3, NumJu4, NumJu2, NumJu3);

        tv_bill.setText(Integer.toString(billAmount));


        clear_btn = findViewById(R.id.clear_btn);
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearControll();
            }
        });


        back_btn = (Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment1();
            }
        });


        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save();
            }
        });

        Delete_btn = findViewById(R.id.Delete_btn);
        Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DeleteData();
            }
        });

        view_btn = findViewById(R.id.view_btn);
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ViewData();
            }
        });

        Update_btn = findViewById(R.id.Update_btn);
        Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //UpdateData();
            }
        });


    }


    public void openfragment1() {

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);


    }


    public void ClearControll() {

        SharedPreferences sp1 = getApplicationContext().getSharedPreferences("Pizza1", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed1 = sp1.edit();
        ed1.remove("");
        ed1.apply();
        Pi1.setText(" ");

        SharedPreferences sp2 = getApplicationContext().getSharedPreferences("Pizza2", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed2 = sp2.edit();
        ed2.remove("");
        ed2.apply();
        Pi2.setText("");

        SharedPreferences sp3 = getApplicationContext().getSharedPreferences("Pizza3", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed3 = sp3.edit();
        ed3.remove("");
        ed3.apply();
        Pi3.setText("");

        SharedPreferences sp4 = getApplicationContext().getSharedPreferences("burger1", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed4 = sp4.edit();
        ed4.remove("");
        ed4.apply();
        Bu1.setText("");

        SharedPreferences sp5 = getApplicationContext().getSharedPreferences("burger2", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed5 = sp5.edit();
        ed5.remove("");
        ed5.apply();
        Bu2.setText("");

        SharedPreferences sp6 = getApplicationContext().getSharedPreferences("burger3", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed6 = sp6.edit();
        ed6.remove("");
        ed6.apply();
        Bu3.setText("");

        SharedPreferences sp7 = getApplicationContext().getSharedPreferences("Juice1", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed7 = sp7.edit();
        ed7.remove("");
        ed7.apply();
        Ju4.setText("");

        SharedPreferences sp8 = getApplicationContext().getSharedPreferences("Juice2", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed8 = sp8.edit();
        ed8.remove("");
        ed8.apply();
        Ju2.setText("");

        SharedPreferences sp9 = getApplicationContext().getSharedPreferences("Juice3", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed9 = sp9.edit();
        ed9.remove("");
        ed9.apply();
        Ju3.setText("");



        tv_bill.setText("");
        et_name.setText("");
        et_number.setText("");
    }

    //insert
    public void Save() {
        db = FirebaseDatabase.getInstance().getReference().child("FoodOder");


        try {
            if (TextUtils.isEmpty(et_name.getText().toString().trim())) {
                Toast.makeText(getApplicationContext(), "Enter the Event Date ", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty((et_number.getText().toString().trim()))) {
                Toast.makeText(getApplicationContext(), "Enter the Email address", Toast.LENGTH_LONG).show();
            } else {
                obFOder.setNumber(et_name.getText().toString().trim());
                obFOder.setName(et_number.getText().toString().trim());

                obFOder.setPeporoniPizza(Pi1.getText().toString().trim());
                obFOder.setCheesePizza(Pi2.getText().toString().trim());
                obFOder.setCheesePizza(Pi3.getText().toString().trim());
                obFOder.setChickenBurger(Bu1.getText().toString().trim());
                obFOder.setCheseseBurger(Bu2.getText().toString().trim());
                obFOder.setDonutBurger(Bu3.getText().toString().trim());
                obFOder.setMangoJuice(Ju4.getText().toString().trim());
                obFOder.setMangoJuice(Ju2.getText().toString().trim());
                obFOder.setMangoJuice(Ju3.getText().toString().trim());

                //db.push().setValue(obFOder);
                db.child("Foder1").setValue(obFOder);
                Toast.makeText(getApplicationContext(), "Confirm oder successfully", Toast.LENGTH_LONG).show();
                ClearControll();
            }

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Number formate Exception", Toast.LENGTH_LONG).show();
        }

    }

  public void ViewData(){
        db = FirebaseDatabase.getInstance().getReference().child("FoodOder").child("oder1");
        try {
            db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.hasChildren()) {
                        et_name.setText(dataSnapshot.child("date").getValue().toString());
                        et_number.setText(dataSnapshot.child("email").getValue().toString());

                        Pi2.setText(dataSnapshot.child("Pi1").getValue().toString());
                        Pi3.setText(dataSnapshot.child("Pi2").getValue().toString());
                        Pi1.setText(dataSnapshot.child("Pi3").getValue().toString());
                        Bu2.setText(dataSnapshot.child("Bu1").getValue().toString());
                        Bu1.setText(dataSnapshot.child("Bu2").getValue().toString());
                        Bu3.setText(dataSnapshot.child("Bu3").getValue().toString());
                        Ju4.setText(dataSnapshot.child("Ju4").getValue().toString());
                        Ju3.setText(dataSnapshot.child("Ju4").getValue().toString());
                        Ju2.setText(dataSnapshot.child("Ju4").getValue().toString());

                    } else
                        Toast.makeText(getApplicationContext(), " No Source To Display!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(), "Number formate Exception", Toast.LENGTH_LONG).show();
        }
    }


    //delete data from Firebase Database
    public void DeleteData () {
        db = FirebaseDatabase.getInstance().getReference().child("FoodOder");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("oder1")) {
                    db = FirebaseDatabase.getInstance().getReference().child("FoodOder").child("oder1");
                    db.removeValue();
                    ClearControll();

                    Toast.makeText(getApplicationContext(), "Data Deleted Successfully!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "No Source To Display!", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }





    //update data in the Firebase database
    public void UpdateData () {
        db = FirebaseDatabase.getInstance().getReference().child("FoodOder");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("oder1")) {
                    try {
                        obFOder.setName(et_name.getText().toString().trim());
                        obFOder.setNumber(et_number.getText().toString().trim());
                        obFOder.setPeporoniPizza(Pi1.getText().toString().trim());
                        obFOder.setCheesePizza(Pi2.getText().toString().trim());
                        obFOder.setVegPizza(Pi3.getText().toString().trim());
                        obFOder.setChickenBurger(Bu1.getText().toString().trim());
                        obFOder.setCheseseBurger(Bu2.getText().toString().trim());
                        obFOder.setDonutBurger(Bu3.getText().toString().trim());
                        obFOder.setMangoJuice(Ju4.getText().toString().trim());
                        obFOder.setMangoJuice(Ju3.getText().toString().trim());
                        obFOder.setMangoJuice(Ju2.getText().toString().trim());

                        db = FirebaseDatabase.getInstance().getReference().child("FoodOder").child("oder1");
                        db.setValue(obFOder);
                        ClearControll();

                        Toast.makeText(getApplicationContext(), "Data updated Successfully!", Toast.LENGTH_SHORT).show();
                    }
                    catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Invalid data type", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                    Toast.makeText(getApplicationContext(), "No Source To Display!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    protected int Totalbill( int NumPiz1, int NumPiz2, int NumPiz3, int NumBu1, int NumBu2, int NumBu3, int NumJu4,int NumJu1, int NumJu2){
        return (NumPiz1*2500)+ (NumPiz2*3000)+ (NumPiz3*1500) +(NumBu1*300)+(NumBu2*220) + (NumBu3*110)+(NumJu4*120)+(NumJu1*120) +(NumJu2*120);
    }



}