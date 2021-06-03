package com.example.myapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Order;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class HistoryActivity extends AppCompatActivity
{
    private ListView listView;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);     //removes title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();                    //hides action bar
        setContentView(R.layout.activity_history);
        Button History=findViewById(R.id.historybutton);
        listView=findViewById(R.id.list);
        ArrayList<String> list=new ArrayList<>();
        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.list_item,list);
        listView.setAdapter(adapter);
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth= FirebaseAuth.getInstance();
                String userID = mAuth.getCurrentUser().getUid();
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("orders");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        list.clear();
                        for(DataSnapshot snapshot:datasnapshot.getChildren())
                        {
                            for(DataSnapshot snap:snapshot.getChildren()) {

                                String key=snap.getKey();
                                if (key.equals(userID)) {
                                    Orderinfo info = snap.getValue(Orderinfo.class);
                                    String s = "Name:" + info.getName() + "\nDate:" + info.getDate() + "\n" + "Price:" + info.getPrice() + "\n" + "Status:" + info.getStatus() + "\n" + "Summary:" + info.getSummary() + "\nAddress:" + info.getAddress();
                                    list.add(s);
                                }



                            }

                        }
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    };
}

