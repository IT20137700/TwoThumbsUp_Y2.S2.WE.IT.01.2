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

public class MainActivity_booking4 extends AppCompatActivity {
    EditText no_r_23;
    EditText no_r_22;
    EditText no_r_21;
    EditText no_r_32;
    Button back_btn;
    EditText no_r_31;
    EditText no_r_41;
    EditText no_r_42;
    Button confirm_btn;
    Button clear_btn;
    Button view_btn;
    Button Update_btn;
    Button Delete_btn;


    EditText et_date;
    EditText et_email;
    TextView tv_bill;

    Booking obBooking;

    DatabaseReference db;
    String room22;
    String room23;
    String room31;
    String room32;
    String room41;
    String room42;
    String room21;



    int Num_r21=0;
    int Num_r22=0;
    int Num_r23=0;

    int Numroom32=0;
    int Numroom31=0;

    int Numroom41=0;
    int Numroom42=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_booking4);

        tv_bill=findViewById(R.id.tv_bill);
        et_date=findViewById(R.id.et_date);
        et_email=findViewById(R.id.et_email);
        confirm_btn=findViewById(R.id.confirm_btn);

        obBooking =new Booking();

        no_r_22=findViewById(R.id.no_r_22);
        SharedPreferences sp =getApplicationContext().getSharedPreferences("room_22", Context.MODE_PRIVATE);
        room22 =sp.getString("room_22_tot","");
        no_r_22.setText(room22);
        if(room22!=null && room22.length()>0) {
            Num_r22 = Integer.parseInt(room22);

        }

        no_r_23=findViewById(R.id.no_r_23);
        SharedPreferences sp1 =getApplicationContext().getSharedPreferences("room_23", Context.MODE_PRIVATE);
        room23 = sp1.getString("room_23_tot","");
        no_r_23.setText(room23);
        if(room23!=null && room23.length()>0) {
            Num_r23 = Integer.parseInt(room23);

        }

        no_r_31=findViewById(R.id.no_r_31);
        SharedPreferences sp2 =getApplicationContext().getSharedPreferences("room_31", Context.MODE_PRIVATE);
        room31 = sp2.getString("room_31_tot","");
        no_r_31.setText(room31);
        if(room31 !=null && room31.length()>0) {
            Numroom31 = Integer.parseInt(room31);

        }

        no_r_32=findViewById(R.id.no_r_32);
        SharedPreferences sp3 =getApplicationContext().getSharedPreferences("room_32", Context.MODE_PRIVATE);
        room32 = sp3.getString("room_32_tot","");
        no_r_32.setText(room32);
        if(room32!=null && room32.length()>0) {
            Numroom32 = Integer.parseInt(room32);

        }

        no_r_41=findViewById(R.id.no_r_41);
        SharedPreferences sp4 =getApplicationContext().getSharedPreferences("room_41", Context.MODE_PRIVATE);
        room41 = sp4.getString("room_41_tot","");
        no_r_41.setText(room41);
        if( room41!=null && room41.length()>0) {
            Numroom41= Integer.parseInt(room41);

        }

        no_r_42=findViewById(R.id.no_r_42);
        SharedPreferences sp5 =getApplicationContext().getSharedPreferences("room_42", Context.MODE_PRIVATE);
        room42 = sp5.getString("room_42_tot","");
        no_r_42.setText(room42);
        if( room42!=null && room42.length()>0) {
            Numroom42= Integer.parseInt(room42);

        }

        no_r_21=findViewById(R.id.no_r_21);
        SharedPreferences sp6 =getApplicationContext().getSharedPreferences("room_21", Context.MODE_PRIVATE);
        room21 = sp6.getString("room_21_tot","");
        no_r_21.setText(room21);
        if( room21!=null && room21.length()>0) {
            Num_r21= Integer.parseInt(room21);

        }

        int billAmount= (Num_r21*20000)+ (Num_r23*20000)+ (Num_r22*20000) +(Numroom32*23000)+(Numroom31*23000)+ (Numroom41*28000)+(Numroom42*28000);
        tv_bill.setText(Integer.toString(billAmount));




        clear_btn=findViewById(R.id.clear_btn);
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClearControll();
            }
        });


        back_btn=(Button) findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfragment1();
            }
        });


        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save ();
            }
        });

        Delete_btn=findViewById(R.id.Delete_btn);
        Delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteData();
            }
        });

        view_btn=findViewById(R.id.view_btn);
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewData();
            }
        });

        Update_btn=findViewById(R.id.Update_btn);
        Update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData();
            }
        });







    }


    public void openfragment1(){

        Intent intent=new Intent(this, MainActivity_booking2.class);
        startActivity(intent);



    }


    public void ClearControll() {

        SharedPreferences sp1 =getApplicationContext().getSharedPreferences("room_23", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed1 =sp1.edit();
        ed1.remove("room_23_tot");
        ed1.apply();
        no_r_23.setText("");

        SharedPreferences sp =getApplicationContext().getSharedPreferences("room_22", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed =sp.edit();
        ed.remove("room_22_tot");
        ed.apply();
        no_r_22.setText("");

        SharedPreferences sp6 =getApplicationContext().getSharedPreferences("room_21", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed6 =sp6.edit();
        ed6.remove("room_21_tot");
        ed6.apply();
        no_r_21.setText("");


        SharedPreferences sp3 =getApplicationContext().getSharedPreferences("room_32", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed3 =sp3.edit();
        ed3.remove("room_32_tot");
        ed3.apply();
        no_r_32.setText("");


        SharedPreferences sp2 =getApplicationContext().getSharedPreferences("room_31", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed2 =sp2.edit();
        ed2.remove("room_31_tot");
        ed2.apply();
        no_r_31.setText("");

        SharedPreferences sp4 =getApplicationContext().getSharedPreferences("room_41", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed4 =sp4.edit();
        ed4.remove("room_41_tot");
        ed4.apply();
        no_r_41.setText("");

        SharedPreferences sp5 =getApplicationContext().getSharedPreferences("room_42", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed5 =sp5.edit();
        ed5.remove("room_42_tot");
        ed5.apply();
        no_r_42.setText("");


        tv_bill.setText("");
        et_date.setText("");
        et_email.setText("");
    }


    public void  Save () {
        db = FirebaseDatabase.getInstance().getReference().child("Booking");


        try {
            if (TextUtils.isEmpty(et_date.getText().toString().trim())) {
                Toast.makeText(getApplicationContext(), "Enter the Event Date ", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty((et_email.getText().toString().trim()))) {
                Toast.makeText(getApplicationContext(), "Enter the Email address", Toast.LENGTH_LONG).show();
            } else {
                obBooking.setDate(et_date.getText().toString().trim());
                obBooking.setEmail(et_email.getText().toString().trim());

                obBooking.setno_r_22(no_r_22.getText().toString().trim());
                obBooking.setno_r_21(no_r_21.getText().toString().trim());
                obBooking.setno_r_23(no_r_23.getText().toString().trim());
                obBooking.setno_r_31(no_r_31.getText().toString().trim());
                obBooking.setno_r_32(no_r_32.getText().toString().trim());
                obBooking.setno_r_41(no_r_41.getText().toString().trim());
                obBooking.setno_r_42(no_r_42.getText().toString().trim());


                db.push().setValue(obBooking);
                db.child("oder1").setValue(obBooking);
                Toast.makeText(getApplicationContext(), "Confirm oder successfully", Toast.LENGTH_LONG).show();
                ClearControll();
            }

        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Number formate Exception", Toast.LENGTH_LONG).show();
        }


    }


     public void ViewData(){

            db = FirebaseDatabase.getInstance().getReference().child("Booking").child("oder1");

         try {
             db.addListenerForSingleValueEvent(new ValueEventListener() {
                 @Override
                  public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                     if (dataSnapshot.hasChildren()) {
                         et_date.setText(dataSnapshot.child("date").getValue().toString());
                         et_email.setText(dataSnapshot.child("email").getValue().toString());
                         no_r_22.setText(dataSnapshot.child("no_r_22").getValue().toString());
                         no_r_21.setText(dataSnapshot.child("no_r_21").getValue().toString());
                         no_r_23.setText(dataSnapshot.child("no_r_23").getValue().toString());
                         no_r_31.setText(dataSnapshot.child("no_r_31").getValue().toString());
                         no_r_32.setText(dataSnapshot.child("no_r_32").getValue().toString());
                         no_r_41.setText(dataSnapshot.child("no_r_41").getValue().toString());
                         no_r_42.setText(dataSnapshot.child("no_r_42").getValue().toString());

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
        db = FirebaseDatabase.getInstance().getReference().child("Booking");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("oder1")) {
                    db = FirebaseDatabase.getInstance().getReference().child("Booking").child("oder1");
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
        db = FirebaseDatabase.getInstance().getReference().child("Booking");
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("oder1")) {
                    try {
                        obBooking.setDate(et_date.getText().toString().trim());
                        obBooking.setEmail(et_email.getText().toString().trim());

                        obBooking.setno_r_22(no_r_22.getText().toString().trim());
                        obBooking.setno_r_21(no_r_21.getText().toString().trim());
                        obBooking.setno_r_23(no_r_23.getText().toString().trim());
                        obBooking.setno_r_31(no_r_31.getText().toString().trim());
                        obBooking.setno_r_32(no_r_32.getText().toString().trim());
                        obBooking.setno_r_41(no_r_41.getText().toString().trim());
                        obBooking.setno_r_42(no_r_42.getText().toString().trim());

                        db = FirebaseDatabase.getInstance().getReference().child("Booking").child("oder1");
                        db.setValue(obBooking);
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







}





















