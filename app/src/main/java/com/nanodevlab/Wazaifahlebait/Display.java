package com.nanodevlab.Wazaifahlebait;


import android.Manifest;

import android.app.WallpaperManager;

import android.content.Intent;
import android.graphics.Bitmap;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;


import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.app.ActivityCompat;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Display extends AppCompatActivity {

    public ViewPager pager;
    private AdView mAdView1,mAdView2;
    private InterstitialAd mInterstitialAd;
    private ImageButton ShareBtn,SaveBtn,SetWallpaperbtn;


    List<String> images;
    int position;
    ImageView imageView;

    public ImagePagerAdapter adap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        ActivityCompat.requestPermissions(Display.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_display);
        images=new ArrayList<>();
        pager=findViewById(R.id.imagepager);
        showSystemUI();

        if(savedInstanceState==null){
            Intent intent=getIntent();

            images  = (ArrayList<String>)getIntent().getSerializableExtra("Images");
            position=intent.getIntExtra("position",0);

        }

        adap =new ImagePagerAdapter(Display.this,images);
        pager.setAdapter(adap);
        pager.setCurrentItem(position,true);

        imageView= findViewById(R.id.img);

        MobileAds.initialize(this, "ca-app-pub-2669593833570116~4741609187");
        mInterstitialAd = new InterstitialAd(Display.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2669593833570116/4058125045");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);


        mAdView1 = findViewById(R.id.adView);
        AdRequest adRequest1 = new AdRequest.Builder().build();
       mAdView1.loadAd(adRequest1);


        mAdView2 = findViewById(R.id.adViewupper);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);



        ShareBtn=findViewById(R.id.sharebtn);
        SaveBtn=findViewById(R.id.save_btn);
        SetWallpaperbtn=findViewById(R.id.setwallpaper_btn);


        ShareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int po=pager.getCurrentItem();
                String url=adap.getItemat(po);
                shareContent(url);
            }
        });


        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int po2=pager.getCurrentItem();
                String url2=adap.getItemat(po2);
                SaveImage(url2);
                LoadAd();
            }
        });


        SetWallpaperbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int po3=pager.getCurrentItem();
                String url3=adap.getItemat(po3);
                setwallpaper(url3);
                LoadAd();
            }
        });



        }







    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }





    private void LoadAd(){


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }


    }

    private void SaveImage(String url){

         Picasso.with(Display.this).load(url).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                File dir=new File(Environment.getExternalStorageDirectory()+"/save/");
                dir.mkdirs();
                String filename= UUID.randomUUID().toString()+".png";
                File file=new File(dir,filename);
                OutputStream out=null;
                try {
                    out = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,out);
                    out.flush();
                    out.close();

                    Toast.makeText(Display.this, "Image Saved ", Toast.LENGTH_SHORT).show();
                    LoadAd();
                }
                catch (java.io.IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Toast.makeText(Display.this, "Error While Saving, Make Sure Your Are Connected To Internet ", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });




    }

    private void shareContent(String url) {

        Picasso.with(Display.this).load(url).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                        bitmap, "Title", null);
                Uri imageUri =  Uri.parse(path);
                share.putExtra(Intent.EXTRA_STREAM, imageUri);
                startActivity(Intent.createChooser(share, "Select"));
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Toast.makeText(Display.this, "Error While Sharing, Make Sure Your Are Connected To Internet ", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });









    }

    private void setwallpaper(String url){


        Picasso.with(Display.this).load(url).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                int height = metrics.heightPixels;
                int width = metrics.widthPixels;

                Bitmap mBit = returnBitmap(bitmap, width, height);

                WallpaperManager myWallpaperManager = WallpaperManager
                        .getInstance(getApplicationContext());
              myWallpaperManager.setWallpaperOffsetSteps(1, 1);

                try {

                    myWallpaperManager.setBitmap(mBit);

                    Toast.makeText(Display.this, "Wallpaper set",
                            Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(Display.this,
                            "Error setting wallpaper", Toast.LENGTH_SHORT)
                            .show();
                }
            }


            private Bitmap returnBitmap(Bitmap originalImage, int width, int height){
                Bitmap background = Bitmap.createBitmap((int)width, (int)height, Bitmap.Config.ARGB_8888);

                float originalWidth = originalImage.getWidth();
                float originalHeight = originalImage.getHeight();

                Canvas canvas = new Canvas(background);

                float scale = width / originalWidth;

                float xTranslation = 0.0f;
                float yTranslation = (height - originalHeight * scale) / 2.0f;

                Matrix transformation = new Matrix();
                transformation.postTranslate(xTranslation, yTranslation);
                transformation.preScale(scale, scale);

                Paint paint = new Paint();
                paint.setFilterBitmap(true);

                canvas.drawBitmap(originalImage, transformation, paint);

                return background;
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Toast.makeText(Display.this, "Error While Setting Wallpaper, Make Sure Your Are Connected To Internet ", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });


    }





}







