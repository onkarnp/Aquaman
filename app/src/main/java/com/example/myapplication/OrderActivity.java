package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.*;

public class OrderActivity extends AppCompatActivity {
    private int q1=0,q2=0,q3=0,amt=0,year,day,month;
    private String summ;
    private String status = "Pending";
    private EditText date;
    private TextView price;
    private TextView summary;
    private ProgressDialog loadingBar;
    private Button placeOrderButton,summarybtn;

    private FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public OrderActivity(EditText date,TextView price,TextView summary){
        this.date = date;
        this.price = price;
        this.summary = summary;
    }
    public OrderActivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);     //removes title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.order_activity);

        date = (EditText) findViewById(R.id.date);
        price = (TextView) findViewById(R.id.price);
        summarybtn=(Button)findViewById((R.id.summarybtn));
        placeOrderButton = (Button)findViewById(R.id.placeOrderButton);
        TextView sumtxt=(TextView)findViewById(R.id.summary);
        Calendar cal= Calendar.getInstance();
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year=cal.get(Calendar.YEAR);
                month=cal.get(Calendar.MONTH);
                day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(OrderActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(SimpleDateFormat.getDateInstance().format(cal.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        summarybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox s1=(CheckBox)findViewById(R.id.checkbox1);
                CheckBox s2=(CheckBox)findViewById(R.id.checkbox2);
                CheckBox s3=(CheckBox)findViewById(R.id.checkbox3);
                if(s1.isChecked())
                {
                    summ="3L bottle - "+q1+"\n";
                }
                if(s2.isChecked())
                {
                    summ=summ+"5L bottle - "+q2+"\n";
                }
                if(s3.isChecked())
                {
                    summ=summ+"10L bottle - "+q3;
                }
                sumtxt.setText(summ);
            }
        });

        placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = date.getText().toString();
                String price =price.toString();
                String summary = summary.toString();
                String status = "Pending";
                loadingBar.setTitle("Place order");
                loadingBar.setMessage("Your order is being placed...");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
                rootNode = FirebaseDatabase.getInstance();
                String userID = mAuth.getCurrentUser().getUid();
                reference = rootNode.getReference("orders");
                Order order = new Order(date,price,summary,status);
                reference.child(date).child(userID).setValue(order);
                loadingBar.dismiss();
                Toast.makeText(OrderActivity.this, "Order placed successfully :)", Toast.LENGTH_SHORT).show();
            }
        });



    }







    public void increment1(View view)
    {
        q1=q1+1;
        display1(q1);
    }
    public void decrement1(View view) {
        if (q1 != 0) {
            q1 = q1 - 1;
            display1(q1);
        }
    }
    private void display1(int a)
    {
        TextView t1=(TextView)findViewById(R.id.quantity1);
        t1.setText(""+a);
    }
    public void increment2(View view)
    {
        q2=q2+1;
        display2(q2);
    }
    public void  decrement2(View view) {
        if (q2 != 0) {
            q2 = q2 - 1;
            display2(q2);
        }
    }
    private void display2(int a)
    {
        TextView t1=(TextView)findViewById(R.id.quantity2);
        t1.setText(""+a);
    }
    public void increment3(View view)
    {
        q3=q3+1;
        display3(q3);
    }
    public void  decrement3(View view) {
        if (q3 != 0) {
            q3 = q3 - 1;
            display3(q3);
        }
    }
    private void display3(int a)
    {
        TextView t1=(TextView)findViewById(R.id.quantity3);
        t1.setText(""+a);
    }
    public void amount(View view)
    {
        CheckBox c1=(CheckBox)findViewById(R.id.checkbox1);
        CheckBox c2=(CheckBox)findViewById(R.id.checkbox2);
        CheckBox c3=(CheckBox)findViewById(R.id.checkbox3);
        if(c1.isChecked())
        {
            amt=amt+20*q1;
        }
        if(c2.isChecked())
        {
            amt=amt+30*q2;
        }
        if(c3.isChecked())
        {
            amt=amt+50*q3;
        }
        displayamt(amt);
    }
    private void displayamt(int a)
    {
        TextView t1=(TextView)findViewById(R.id.price);
        t1.setText(""+a);
    }



}
