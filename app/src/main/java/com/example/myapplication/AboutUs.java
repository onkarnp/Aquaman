package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutUs extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.contact_us)
                .setDescription("This app solely developed to make mineral water distribution easy and make clean mineral water available for everyone...")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("CONNECT WITH US!")
                .addEmail("Grno24technologies@gmail.com")
                .addYoutube("UCbekhhidkzkGryM7miSYs_w")   //Enter your youtube link here (replace with my channel link)
                .addPlayStore("com.example.myapplication")   //Replace all this with your package name
                .addInstagram("pranav_sp_309")
                .addFacebook("Pranav Pawar")
                .addTwitter("Your Twitter id")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }
    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d by Aquaman", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setIconDrawable(R.mipmap.ic_launcher_foreground);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutUs.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}