package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity
{
    private ListView listView;
    private List<Order> list;
    private FirebaseAuth mAuth;
    DatabaseReference reference= FirebaseDatabase.getInstance().getReference("orders");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);     //removes title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();                    //hides action bar
        setContentView(R.layout.activity_history);
        Button History=findViewById(R.id.historybutton);
        listView=findViewById(R.id.listView);
        list= new ArrayList<>();
        MyAdapter myAdapter = new MyAdapter(this,R.layout.list_item,list);
        listView.setAdapter(myAdapter);
        History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth= FirebaseAuth.getInstance();
                String userID = mAuth.getCurrentUser().getUid();
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                        list.clear();
                        for(DataSnapshot snapshot:datasnapshot.getChildren())
                        {
                            for(DataSnapshot snap:snapshot.getChildren()) {

                                String key=snap.getKey();
                                if (key.equals(userID)) {
                                    Order info = snap.getValue(Order.class);
                                    String s = "Name:" + info.getName() + "\nDate:" + info.getDate() + "\n" + "Price:" + info.getPrice() + "\n" + "Status:" + info.getStatus() + "\n" + "Summary:" + info.getSummary() + "\nAddress:" + info.getAddress();
                                    list.add(new Order(info.getDate(),info.getPrice(),info.getSummary(),info.getStatus(),info.getAddress(),info.getName()));
                                }

                            }

                        }
                        myAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    };
}

