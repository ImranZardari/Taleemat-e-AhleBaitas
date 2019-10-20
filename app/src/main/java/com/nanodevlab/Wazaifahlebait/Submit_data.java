package com.nanodevlab.Wazaifahlebait;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.util.UUID;

public class Submit_data extends AppCompatActivity {

    private static final int Pick_image_request = 1;
    Button choosefile, submitfile;
    ImageView showImage;
    ProgressDialog progress;
    StorageReference storageRef;
    public Uri imageuri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_data);

        getSupportActionBar().setTitle("Submit Images");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        choosefile = findViewById(R.id.choosebtn);
        submitfile = findViewById(R.id.submit_btn);
        showImage = findViewById(R.id.imageview);


        storageRef = FirebaseStorage.getInstance().getReference("submitedImages");


        choosefile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });


        submitfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if(imageuri!=null){
                  UploadImage();
              }
              else
                  Toast.makeText(Submit_data.this, "Select A Image First", Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void UploadImage() {
        progress=new ProgressDialog(Submit_data.this);
        progress.setTitle("Uploading File ...");
        progress.setMessage("It Will Take A while ....");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setCanceledOnTouchOutside(false);
        progress.show();
        storageRef.child(UUID.randomUUID().toString()).putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                progress.dismiss();
                Toast.makeText(Submit_data.this, "Uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Submit_data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, Pick_image_request);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Pick_image_request && resultCode == RESULT_OK) {

           if(data!=null){
               imageuri = data.getData();
               showImage.setImageURI(imageuri);

           }
           else
               Toast.makeText(this, "Please select a image first", Toast.LENGTH_SHORT).show();

        }


    }
}