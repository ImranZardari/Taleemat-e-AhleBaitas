package com.nanodevlab.Wazaifahlebait;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    ListView settinglist;
    Dialog myDialog;
    String [] list={"About Developer","About App","Share Application","       Submit Ahadith,Aqwal "};
    int images []={R.drawable.admin,R.drawable.adb,R.drawable.share,R.drawable.upload};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        getSupportActionBar().setTitle("Setting");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        myDialog = new Dialog(this);
       adapter adapter=new adapter();

     settinglist=findViewById(R.id.settinglist);
    settinglist.setAdapter(adapter);




        settinglist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0 :
                        showpopup(view);
                        break;

                    case 1 :
                        showpopup2(view);
                        break;


                    case 2 :
                        shareapp();
                        break;

                    case 3:
                        submitAsset();
                        break;


                }


            }
        });


    }

    private void submitAsset() {

        Intent i=new Intent(SettingActivity.this,Submit_data.class);
        startActivity(i);

    }

    public void showpopup(View v) {

        myDialog.setContentView(R.layout.custompopup);


        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DCDCDC")));
        myDialog.show();


        myDialog.findViewById(R.id.callidno).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number="+923063246643";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });





        myDialog.findViewById(R.id.closebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });



    }

    public void showpopup2(View v) {

        myDialog.setContentView(R.layout.aboutapp);


     myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DCDCDC")));
        myDialog.show();
        myDialog.findViewById(R.id.closebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });



    }



    private void shareapp(){
        try {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
            String shareMessage= "\nLet me recommend you this application\n\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            startActivity(Intent.createChooser(shareIntent, "choose one"));
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }




    class adapter extends BaseAdapter{

        @Override
        public int getCount() {
                  return  list.length;
        }

        @Override
        public Object getItem(int position) {


            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v=getLayoutInflater().inflate(R.layout.list_setting,parent,false);
            TextView listinput=v.findViewById(R.id.input_header);
            ImageView image=v.findViewById(R.id.icon);
            image.setImageResource(images[position]);
            listinput.setText(list[position]);
            return v;
        }
    }

}
