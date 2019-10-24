package com.nanodevlab.Wazaifahlebait;

import android.content.Intent;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nanodevlab.Wazaifahlebait.Adapter.ImageAdapter;
import com.nanodevlab.Wazaifahlebait.Interfaces.IRecyclerViewClickListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AqwalActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ProgressBar mProgressCircle;
    private DatabaseReference mDatabaseRef;
    public  List<String> mUploads;
    private DatabaseReference mDatabaseOffline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aqwal);



        mProgressCircle = findViewById(R.id.progress_circle);

        mRecyclerView = findViewById(R.id.recycler_view);
        layoutManager =new GridLayoutManager(this,2);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(layoutManager);

        mUploads =new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Aqwals");
        mDatabaseOffline = FirebaseDatabase.getInstance().getReference("Aqwals");



        final IRecyclerViewClickListener listener=new IRecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent=new Intent(AqwalActivity.this,Display.class);
                intent.putExtra("Images", (ArrayList<String>)mUploads);
                intent.putExtra("position",position);
                startActivity(intent);


            }
        };


           mDatabaseRef.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                       for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                           mDatabaseOffline.keepSynced(true);
                           String url= postSnapshot.child("imageurl").getValue().toString();
                           mUploads.add(url);


                       }

                   Collections.reverse(mUploads);
                   ImageAdapter imageAdapter=new ImageAdapter(AqwalActivity.this,mUploads,listener);
                   mRecyclerView.setAdapter(imageAdapter);
                   imageAdapter.notifyDataSetChanged();
                   mProgressCircle.setVisibility(View.INVISIBLE);

               }

               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {
                   mProgressCircle.setVisibility(View.INVISIBLE);
                   Toast.makeText(AqwalActivity.this, databaseError.toString(), Toast.LENGTH_SHORT).show();
               }
           });






    }


}
