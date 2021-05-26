package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.security.PublicKey;

public class FAQpage extends AppCompatActivity {
    TextView T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);     //removes title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_f_a_qpage);

        T1 = (TextView) findViewById(R.id.Que1);
        T2 = (TextView) findViewById(R.id.Ans1);
        T3 = (TextView) findViewById(R.id.Que2);
        T4 = (TextView) findViewById(R.id.Ans2);
        T5 = (TextView) findViewById(R.id.Que3);
        T6 = (TextView) findViewById(R.id.Ans3);
        T7 = (TextView) findViewById(R.id.Que4);
        T8 = (TextView) findViewById(R.id.Ans4);
        T9 = (TextView) findViewById(R.id.Que5);
        T10 = (TextView) findViewById(R.id.Ans5);
        T11 = (TextView) findViewById(R.id.Que6);
        T12 = (TextView) findViewById(R.id.Ans6);
    }

    public void Que1Clicked(View v)
    {
        T1.setVisibility(View.VISIBLE);
        T2.setVisibility(View.VISIBLE);
        T3.setVisibility(View.VISIBLE);
        T4.setVisibility(View.GONE);
        T5.setVisibility(View.VISIBLE);
        T6.setVisibility(View.GONE);
        T7.setVisibility(View.VISIBLE);
        T8.setVisibility(View.GONE);
        T9.setVisibility(View.VISIBLE);
        T10.setVisibility(View.GONE);
        T11.setVisibility(View.VISIBLE);
        T12.setVisibility(View.GONE);
    }

    public void Que2Clicked(View v)
    {
        T1.setVisibility(View.VISIBLE);
        T2.setVisibility(View.GONE);
        T3.setVisibility(View.VISIBLE);
        T4.setVisibility(View.VISIBLE);
        T5.setVisibility(View.VISIBLE);
        T6.setVisibility(View.GONE);
        T7.setVisibility(View.VISIBLE);
        T8.setVisibility(View.GONE);
        T9.setVisibility(View.VISIBLE);
        T10.setVisibility(View.GONE);
        T11.setVisibility(View.VISIBLE);
        T12.setVisibility(View.GONE);
    }

    public void Que3Clicked(View v)
    {
        T1.setVisibility(View.VISIBLE);
        T2.setVisibility(View.GONE);
        T3.setVisibility(View.VISIBLE);
        T4.setVisibility(View.GONE);
        T5.setVisibility(View.VISIBLE);
        T6.setVisibility(View.VISIBLE);
        T7.setVisibility(View.VISIBLE);
        T8.setVisibility(View.GONE);
        T9.setVisibility(View.VISIBLE);
        T10.setVisibility(View.GONE);
        T11.setVisibility(View.VISIBLE);
        T12.setVisibility(View.GONE);
    }

    public void Que4Clicked(View v)
    {
        T1.setVisibility(View.VISIBLE);
        T2.setVisibility(View.GONE);
        T3.setVisibility(View.VISIBLE);
        T4.setVisibility(View.GONE);
        T5.setVisibility(View.VISIBLE);
        T6.setVisibility(View.GONE);
        T7.setVisibility(View.VISIBLE);
        T8.setVisibility(View.VISIBLE);
        T9.setVisibility(View.VISIBLE);
        T10.setVisibility(View.GONE);
        T11.setVisibility(View.VISIBLE);
        T12.setVisibility(View.GONE);
    }

    public void Que5Clicked(View v)
    {
        T1.setVisibility(View.VISIBLE);
        T2.setVisibility(View.GONE);
        T3.setVisibility(View.VISIBLE);
        T4.setVisibility(View.GONE);
        T5.setVisibility(View.VISIBLE);
        T6.setVisibility(View.GONE);
        T7.setVisibility(View.VISIBLE);
        T8.setVisibility(View.GONE);
        T9.setVisibility(View.VISIBLE);
        T10.setVisibility(View.VISIBLE);
        T11.setVisibility(View.VISIBLE);
        T12.setVisibility(View.GONE);
    }

    public void Que6Clicked(View v)
    {
        T1.setVisibility(View.VISIBLE);
        T2.setVisibility(View.GONE);
        T3.setVisibility(View.VISIBLE);
        T4.setVisibility(View.GONE);
        T5.setVisibility(View.VISIBLE);
        T6.setVisibility(View.GONE);
        T7.setVisibility(View.VISIBLE);
        T8.setVisibility(View.GONE);
        T9.setVisibility(View.VISIBLE);
        T10.setVisibility(View.GONE);
        T11.setVisibility(View.VISIBLE);
        T12.setVisibility(View.VISIBLE);
    }
}