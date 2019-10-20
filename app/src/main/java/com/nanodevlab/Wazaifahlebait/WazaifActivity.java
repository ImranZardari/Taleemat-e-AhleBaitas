package com.nanodevlab.Wazaifahlebait;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import com.nanodevlab.Wazaifahlebait.Adapter.ExpandableListAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WazaifActivity extends AppCompatActivity {



    private ExpandableListView listView;
    public ExpandableListAdapter listAdapter;
    private List<String> listDataheader;
    private HashMap<String,List<String>> listhash;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wazaif);

        getSupportActionBar().setTitle("Wazaif's");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MobileAds.initialize(WazaifActivity.this, "ca-app-pub-2669593833570116~4741609187");

        mInterstitialAd = new InterstitialAd(WazaifActivity.this);

        mInterstitialAd.setAdUnitId("ca-app-pub-2669593833570116/8349202773");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);


        listView =findViewById(R.id.AqwalmainLIst);
        initdata();
        listAdapter =new ExpandableListAdapter(WazaifActivity.this,listDataheader,listhash);

        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                String shareMessage= "\n\nLet me recommend you this application\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";

                String value= listAdapter.getChildurl(groupPosition,childPosition);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, value+shareMessage);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Share Wazaif !"));

                return false;
            }
        });


        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
               switch (groupPosition){
                   case 0:
                  LoadAd();
                   break;

                   case 2:
                       LoadAd();
                       break;

                   case 12:
                       LoadAd();
                       break;

                       case 22:
                       LoadAd();
                       break;

                   case 19:
                       LoadAd();
                       break;

                   case 6:
                       LoadAd();
                       break;
                   case 16:
                       LoadAd();
                       break;
                   case 32:
                       LoadAd();
                       break;
               }
                return false;
            }
        });

    }


    private void initdata() {

        listDataheader=new ArrayList<>();
        listhash =new HashMap<>();

        listDataheader.add("      THE WAZIFA OF MARRIAGE");
        listDataheader.add("      THE WAZIFA OF SALVATION FROM SICKNESS");
        listDataheader.add("      THE WAZIFA OF UNEMPLOYMENT");
        listDataheader.add("      THE WAZIFA FOR BRICK IN PROVISION");
        listDataheader.add("      THE WAZIFA FOR BED SIGHT OR SALVATION FROM JEALOUSY");
        listDataheader.add("      THE WAZIFA FOR SALVATION FROM BLACK MAGIC");
        listDataheader.add("      THE WAZIFA FOR LOVE MARRIAGE");
        listDataheader.add("      THE WAZIFA FOR SALVATION OF EVERY CONFINEMENT");
        listDataheader.add("      THE WAZIFA FOR SALVATION FROM HEADACHE");
        listDataheader.add("      THE WAZIFA OF EYE PAIN");
        listDataheader.add("      THE WAZIFA FOR WEAKNESS OF EYE SIGHT");
        listDataheader.add("      THE WAZIFA FOR ABDOMINAL PAIN");
        listDataheader.add("      THE WAZIFA FOR HEART DISEASE");
        listDataheader.add("      THE WAZIFA FOR KIDNEY STONE");
        listDataheader.add("      THE WAZIFA OF CANCER");
        listDataheader.add("      THE WAZIFA FOR DIABETES");
        listDataheader.add("      THE WAZIFA OF ELIMINATING FATNESS");
        listDataheader.add("      THE WAZIFA FOR MAN INFERTILITY");
        listDataheader.add("      THE WAZIFA FOR WOMEN SECRET DISEASE");
        listDataheader.add("      THE WAZIFA FOR ELEMINATION OF TOOTHACHE");
        listDataheader.add("      THE WAZIFA FOR EAR PAIN");
        listDataheader.add("      THE WAZIFA FOR URINE'S TROUBLE");
        listDataheader.add("      THE WAZIFA FOR KIDNEYS PAIN");
        listDataheader.add("      THE WAZIFA FOR LOST THINGS");
        listDataheader.add("      THE WAZIFA FOR BREATH TROUBLE");
        listDataheader.add("      THE WAZIFA FOR COUGH");
        listDataheader.add("      THE WAZIFA FOR FLU");
        listDataheader.add("      THE WAZIFA FOR CONSTIPATION");
        listDataheader.add("      THE WAZIFA FOR MALARIA");
        listDataheader.add("      THE WAZIFA FOR WHITE HAIR'S");
        listDataheader.add("      THE WAZIFA FOR SALVATION FROM BALDNESS");
        listDataheader.add("      THE WAZIFA FOR SAFE JOURNEY");
        listDataheader.add("      THE WAZIFA FOR SUCCESS");
        listDataheader.add("      THE WAZIFA FOR FOE TO FRIEND");
        listDataheader.add("      THE WAZIFA FOR INCREASE LOVE AND RELATIONSHIP");
        listDataheader.add("      THE WAZIFA FOR DECENDANTS");
        listDataheader.add("      THE WAZIFA FOR BEAUTY");
        listDataheader.add("      THE WAZIFA FOR GOOD HEALTH");
        listDataheader.add("      THE WAZIFA FOR RECOGNIZATION OF HUMAN BEING");
        listDataheader.add("      THE WAZIFA FOR ABSOLUTION OF LATES");
        listDataheader.add("      THE WAZIFA OF SALVATION FROM DIPRESSION");
        listDataheader.add("      THE WAZIFA TO FORGET SOMEONE/ANYONE");
        listDataheader.add("      THE WAZIFA OF SALVATION FROM SADNES AND SORROWS");
        listDataheader.add("      THE WAZIFA FOR HAPPINESS");
        listDataheader.add("      THE WAZIFA FOR LOVE IN HUSBAND AND WIFE");
        listDataheader.add("      THE WAZIFA FOR HAVING A PLACE IN HEART OF HUSBAND");
        listDataheader.add("      THE WAZIFA FOR HAVING A PLACE IN WIFE'S HEART");
        listDataheader.add("      THE WAZIFA FOR GETTING RESPECT IN MOTHER/FATHER IN LAW AND IN LAWS HOME");
        listDataheader.add("      THE WAZIFA FOR UNSEEN HELP");
        listDataheader.add("      THE WAZIFA FOR IMPROVE HEIGHT");
        listDataheader.add("      THE WAZIFA FOR STAMMERNESS");
        listDataheader.add("      THE WAZIFA OF SALVATION FROM PRISON");




        List<String>waz0=new ArrayList<>();
        waz0.add("\nTHE WOMEN WHOSE MARRIAGE IS RESTRICTED OR OBSTACLES\n\n" +
                "SHE WOULD READ SURAH NASAR AND SURAH KOUSAR BOTH 27 TIMES DAILY AFTER ESHA INSHA ALLAH ALLAH WILL" +
                " SEND A GOOD REALATION FOR HER\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S ");

        List<String> waz1=new ArrayList<>();
        waz1.add("\n" +
                "A Person who eats an Apple daily in the morning and he/she read 'YA SHAFI-O,YA HAKEEMO,YA ALLAH' 27 times.\n" +
                "Allah will recover him Insha Allah\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz2 =new ArrayList<>();
        waz2.add("\nA person who read 'YA RAZAQO, YA RAZAQO YA RAZAQO' 108 times daily at night Allah will bless him with\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz3 =new ArrayList<>();
        waz3.add("\nA Person who read 27 times Surah Al-IKHLAS AFTER NAMAZ-E-ISHA ON WATER AND DRINK IT AND PRAYER FROM ALLAH THEN ALLAH WILL PROVIDE HIM/HER BLESSING FROM UNSEEN WAYS\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz4 =new ArrayList<>();
        waz4.add("\nA PERSON WHO READ 'FOUR QUL 'AT EVERY EVENING AND MORNING AND ALSO READ (MIN SHARRI HASIDIN IZHA HASAD)27 TIMES THOSE PERSON DO NOT GOT BED SIGHT,INSHA ALLAH HE/SHE WILL REMAIN FAR HIM JEALOUSY FACTOR.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz5 =new ArrayList<>();
        waz5.add("\nA PERSON WHO READ 'AAYAT-UL-KURSI' AT (HUM FEEHA KHALIDOON) AND BRAISE AT WATER AND DRINK IT THEN SO FROM BLESSING OF ALLAH BLACK MAGICN DO NOT EFFECT UPON THAT INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz6 =new ArrayList<>();
        waz6.add("\nA MAN OR WOMAN BEFORE SLEEPING AT NIGHT READ (SURAH AL-KOUSAR ) 27 TIMES AND THEN PRAYER FROM GOD , ALLAH WILL BLESS WITH HIM/HER LOVE  INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S ");

        List<String> waz7 =new ArrayList<>();
        waz7.add("\nA PERSON WHO IS PRAY OF CONFINEMENT HE/SHE WANT AFTER NAMAZ-MAGRIB.HE READ SURAH'AL-FALAQ' 21 TIMES AND BRAISE AT WATER. FROM THE BLESSING OF ALLAH EVERY OBSTACLES WILL BE GONE.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz8 =new ArrayList<>();
        waz8.add("\nA PERSON WHO READ (SURAH-E-FATIHA) 27 TIMES AND BRAISE AT WATER AND THEN DRINK IT ALLAH WILL RECOVER HIM FROM HEADACHE.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz9 =new ArrayList<>();
        waz9.add("\nA PERSON WHO SOAKED ALMOND AT NIGHT AND AFTER AWAKING AT MORNING HE READ 'YA ALLEMU , YA ALLAH' 27 TIMES AND BRAISE UPON ALMOND AND EAT IT. ALLAH WILL RECOVER HIS EYES INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz10 =new ArrayList<>();
        waz10.add("\nA PERSON WHO READ ON WATER 27 TIMES 'YA-SHAFI-O ,YA-RAHEEM-O' AND PUT WATER IN EYES 7 TIMES IN A DAY AND ALSO DRINK IT THEN ALLAH WILL RECOVER HIS EYES SIGHT INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz11 =new ArrayList<>();
        waz11.add("\nA PERSON WHO BRAISE ON WATER 'SURAH-AL-QADAR' 12 TIMES AND DRINK IT ALLAH WILL RECOVER HIM INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz12 =new ArrayList<>();
        waz12.add("\nTHOSE PERSON WHO EAT LITTLE GINGER AT LUNCH TIME AND READ 'SURAH AL-ASAR' 27 TIMES UPON IT ALLAH WILL RECOVER HIM FROM ALL HEART DISEASES  INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz13 =new ArrayList<>();
        waz13.add("\nA PERSON WHO DRINK MUCH WATER IN A DAY AND WITH EVERY GLASS OF WATER HE READ'YA-HAKEEMO,YA-ALLAH' 3 TIMES, ALLAH WILL BE EXTRACT HIS DISEASE FROM HIM INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz14 =new ArrayList<>();
        waz14.add("\nA PERSON WHO EAT RIPPED ONION AND GINGER AT LUNCH TIME AND BRAISE 'SURAH AL-FATIHA' UPON IT.ALLAH WILL EXTRACT THIS DISEASE FROM HIS BODY,INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz15 =new ArrayList<>();
        waz15.add("\nA PERSON WHO READ 'AYAT-UL-KURSI'ON A RIPPED LADY FINGER (27 TIMES) AND EAT IT,ALLAH WILL BE EXTRACT THIS DISEASE FROM THEM.INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz16 =new ArrayList<>();
        waz16.add("\nA PERSON WHO EAT FOOD TWICE IN A DAY AND AFTER EATING HE READ 'SURAH AL-IKHLAS ' ON LUKEWARM WATER AND DRINK IT.ALLAH WILL ELIMINATE HIS FATNESS INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz17 =new ArrayList<>();
        waz17.add("\nA PERSON WHO READ'SURAH AL-KAFIROON ON MILK AND DRINK IT ON NIGHT ALLAH WILL INCREASE HIS MAN POWER INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz18 =new ArrayList<>();
        waz18.add("\nWHILE DRINKING WATER A WOMEN READ 'SURAH AL-NAS'WITH EACH GLASS OF WATER THEN ALLAH WILL RELEASE HER ALL DISEASES FROM HER INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz19 =new ArrayList<>();
        waz19.add("\nA PEROSN WHO READ 'SURAH AL-FATIHA' ON COLLINS AND PUT IT ON TEETH.ALLAH WILL RECOVER IT INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz20 =new ArrayList<>();
        waz20.add("\nA PERSON WHO READ 'SURAH AL-FATIHA' ON HIS/HER EAR (7 TIMES) ALLAH WILL BE GIVE HIS/HER COMFORT INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz21 =new ArrayList<>();
        waz21.add("\nA PERSON WHO READ 'SURAH-E-YASEEN' DAILY IN THE MORNING INSHALLAH AND BRAISE ON WATER AND DRINK IT ALLAH WILL EXTRACT THIS DISEASE FROM HIM/HER.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz22 =new ArrayList<>();
        waz22.add("\nA PERSON WHO BRAISE ON OWN SELF (5 TIMES) 'SURAH AL-KOUSAR' EVERY NIGHT AND PRAY FROM ALLAH,ALLAH WILL EXTRACT THIS DISEASE FROM HIM/HER INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz23 =new ArrayList<>();
        waz23.add("\nA PERSON WHO READ 'INNALILLAH E WAINNA ELAIHE RAJIEON' (108 TIMES) AND FROM ALLAH INSHALLAH ALLAH WILL GIVE HIM THAT THING OR GIVE HIM A CLUE OR HINT.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz24 =new ArrayList<>();
        waz24.add("\nA PERSON WHO READ 'SURAH AL-REHMAN' DAILY IM THE MORNING ON FLUTE FLOWER AND FEEL ITS FRAGNANCE ALLAH WILL BE PROVIDE HIM RELIEF FROM THIS DISEASE INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz25 =new ArrayList<>();
        waz25.add("\n A PERSON WHO CATCH A COUGHS PROBLEM WHO DRINK LUKEWARM WATER ON NIGHT AFTER READING 'SURAH AL-REHMAN' ON IT. ALLAH WILL BE ELIMINATE THIS DISEASE FROM HIS INSHALLAHT.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz26 =new ArrayList<>();
        waz26.add("\nA PERSON WHO READ 'YA GHAFFAR-O, YA RAHEEM-O' IN FLU.ALLAH WILL BE RECOVER HIM INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz27 =new ArrayList<>();
        waz27.add("\nA PERSON WHO READ 'SURAH AL-LAHAB 'ON LUKEWARM WATER DAILY IN MORNING AND DRINK IT,ALLAH WILL ELIMINATE THIS DISEASE FROM HIM INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz28 =new ArrayList<>();
        waz28.add("\nA PERSON WHO READ 'SURAH AL-SAA' ON WATER AND DRINK IT ALLAH WILL ELIMINATE THIS DISEASE FROM HIM   INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz29 =new ArrayList<>();
        waz29.add("\nA PERSON WHO READ 'SURAH AL-REHMAN AND SURAH MUZAMIL' ON OIL AND USE IT DAILY, ALLAH WILL SOLVE HIS PROBLEM INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz30 =new ArrayList<>();
        waz30.add("\nA PERSON WHO READ 'SURAH AL-FATIHA' ON OIL (108) TIMES AND USE IT WILL SOLVE THIS PROBLEM INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz31 =new ArrayList<>();
        waz31.add("\nA PERSON WHO READ 'SURAH AL-NASAR ' (27 TIMES) AND START HIS JOURNEY ALLAH WILL MAKE HER/HIS JOURNEY SAFE INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz32 =new ArrayList<>();
        waz32.add("\nA PERSON WHO READ 'YA FATTAHU YA ALLAH 27 TIMES' THEN GO FOR WORK ALLAH WILL GIVE HIM SUCCESS IN ITS WORK INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz33 =new ArrayList<>();
        waz33.add("\nA PERSON WHO READ 'SURAH AL-NAAS 27 TIMES' IN EVERY NIGHT HIS ENEMIES WILL NEVER OBSESS ON HIM  INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz34 =new ArrayList<>();
        waz34.add("\nA PERSON WHO READ 'YA WADOOD'O , YA ALLAH 108 TIMES ' ON WATER AND DRINK IT A WANTED AND IF HE/SHE IS ON DISTANCE THEN BRAISE UPON HIS/HER PICTURE THEN ALLAH WILL INCREASE LOVE AND FRIENDSHIP  INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz35 =new ArrayList<>();
        waz35.add("\nA PERSON WHO READ 'SURAH AL-KOUSAR AND SURAH AL-NASAR 27 TIMES ' AT NIGHT AND BRAISE ON MILK AND DRINK BOTH WIFE AND HUSBAND THEN ALLAH WILL BLESS THEM WITH RIGHTEOUS GENERATION INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz36 =new ArrayList<>();
        waz36.add("\nA WOMAN WHO READ 'SURAH AL-YOUSAF' ON WATER AND DRINK WATER EVERY MORNING AND NIGHT AND ALSO USE ON THE FACE ,ALLAH BLESS HER WITH BEAUTY INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz37 =new ArrayList<>();
        waz37.add("\nA PERSON WHO READ 'SURAH AL-FATIHA'ON MILK EVERY NIGHT AND DRINK IT AND HE WILL BE HEALTHY INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz38 =new ArrayList<>();
        waz38.add("\nA PERSON WHO READ 'SURAH AL-NASAR 3 TIMES' AND LOOK IN THE EYES OF SOME ONE THEN ALLAH WILL CLERIFY THAT PERSON IN FRONT OF HIM. INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz39 =new ArrayList<>();
        waz39.add("\nA PERSON WHO WANTS TO ABSOLUTION OF LATES THEN HE READ 'SURAH AL-FATIHA AND SURAH AL-IKHLAS 3 TIMES' EVERY NIGHT , ALLAH WILL DO ABSOLUTION OF HIS LATES INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz40 =new ArrayList<>();
        waz40.add("\nA PERSON WHO READ 'SURAH AL-KOUSAR 108 TIMES' ON ROSE OR SCENT AND KEEP IT SAFE AND THEN FEEL IT'S SMELL (7 TIMES ) IN A DAY ,ALLAH SOLVE HIS PROBLEM FROM HIS BLESSINGS. INSHALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz41 =new ArrayList<>();
        waz41.add("\nA PERSON WHO READ 'SURAH  AL-FALAK AND SURAH AL-NAAS 3 TIMES' ON WATER AND DRINK IT AND PRAY TO FORGET SOMEONE ,ALLAH WILL SOLVE HIS PROBLEM INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz42 =new ArrayList<>();
        waz42.add("\nA PERSON WHO WENT ON SUCH A PLACE DAILY WHERE WILL BE TREES AND FLOWER AND HE READ THERE 'YA ALLAH YA RAHMAN 7 TIMES' BY SEEING ALLAH'S NATURE THEN HIS/HER SORROWS WILL BE ELIMINATE INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz43 =new ArrayList<>();
        waz43.add("\nA PERSON WHO READ DAILY 'SURAH  AL-FATIHA ' ON WATER AND DRINK IT AND THEN START THE DAY THOSE WILL BE HAPPY THE WHOLE DAY INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz44 =new ArrayList<>();
        waz44.add("\nA PERSON WHO READ 'YA WADOOD'O, YA ALLAH ' BEFORE TALKING TO HIS/HER LIFE PARTNER AND THEN TALK BY SMILING THEN ALLAH WILL BRING LOVE B/W THEM INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz45=new ArrayList<>();
        waz45.add("\nA WOMEN WHO READ ' YA RAHEEM'O ,YA WADOOD'O 108 TIMES' BEFORE SLEEPING ON NIGHT AND PRAY THEN SHE WILL FIND PLACE IN HER HUSBANDS HEART INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz46 =new ArrayList<>();
        waz46.add("\nA MAN WHO READ ' SURAH FATIHA AND SURAH IKHLAS 18 TIMES' BEFORE SLEEPING ON NIGHT AND PRAY THEN SHE WILL FIND RESPECT IN WIFE'S HEART INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz47 =new ArrayList<>();
        waz47.add("\nA MAN OR WOMEN WHO READ ' SURAH AL-NASAR AND SURAH AL-QADAR 27 TIMES' IN THE NIGHT AND PRAY THEN THEY FIND RESPECT AND HONOR INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");



        List<String> waz48 =new ArrayList<>();
        waz48.add("\nA PERSON WHO READ 'SURAH IKHLAS 7 TIMES' IN MORNING AND NIGHT AND PRAY THEN ALLAH WILL HELP HIM FROM UNSEEN WAYS INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz49 =new ArrayList<>();
        waz49.add("\nA PERSON WHO READ 'SURAH AL-SAA' ON WATER EVERY NIGHT AND DRINK II THEN HIS HEIGHT GONE TALL FORM ALLAH BLESSING INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");

        List<String> waz50 =new ArrayList<>();
        waz50.add("\n WHENEVER A STAMMER PERSON EAT FOOD OR DRINK WATER THEN READ 'YA KAEEMO ,YA ALEEMU , YA ALLAH ' ON IT AND THEN HE EAT OR DRINK FROM ALLAH KINDNESS HIS STAMMERNESS WILL BE ELIMINATE INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S");


        List<String> waz51 =new ArrayList<>();
        waz51.add("\nWHO READ 'SURAH AL-FATIHA 108 TIMES' DAILY FROM ALLAH'S KINDNESS HE WILL GET ESCAPE FROM PRISON INSHA ALLAH.\n\n* Ref : All Wazaifs Are Taken From Syed Mehrban Ali Shamsi Sabzwari Tabrezi Website And From His Book Wazaif E Imam Ali A.S\n\n");


        listhash.put(listDataheader.get(0),waz0);
        listhash.put(listDataheader.get(1),waz1);
        listhash.put(listDataheader.get(2),waz2);
        listhash.put(listDataheader.get(3),waz3);
        listhash.put(listDataheader.get(4),waz4);
        listhash.put(listDataheader.get(5),waz5);
        listhash.put(listDataheader.get(6),waz6);
        listhash.put(listDataheader.get(7),waz7);
        listhash.put(listDataheader.get(8),waz8);
        listhash.put(listDataheader.get(9),waz9);
        listhash.put(listDataheader.get(10),waz10);
        listhash.put(listDataheader.get(11),waz11);
        listhash.put(listDataheader.get(12),waz12);
        listhash.put(listDataheader.get(13),waz13);
        listhash.put(listDataheader.get(14),waz14);
        listhash.put(listDataheader.get(15),waz15);
        listhash.put(listDataheader.get(16),waz16);
        listhash.put(listDataheader.get(17),waz17);
        listhash.put(listDataheader.get(18),waz18);
        listhash.put(listDataheader.get(19),waz19);
        listhash.put(listDataheader.get(20),waz20);
        listhash.put(listDataheader.get(21),waz21);
        listhash.put(listDataheader.get(22),waz22);
        listhash.put(listDataheader.get(23),waz23);
        listhash.put(listDataheader.get(24),waz24);
        listhash.put(listDataheader.get(25),waz25);
        listhash.put(listDataheader.get(26),waz26);
        listhash.put(listDataheader.get(27),waz27);
        listhash.put(listDataheader.get(28),waz28);
        listhash.put(listDataheader.get(29),waz29);
        listhash.put(listDataheader.get(30),waz30);
        listhash.put(listDataheader.get(31),waz31);
        listhash.put(listDataheader.get(32),waz32);
        listhash.put(listDataheader.get(33),waz33);
        listhash.put(listDataheader.get(34),waz34);
        listhash.put(listDataheader.get(35),waz35);
        listhash.put(listDataheader.get(36),waz36);
        listhash.put(listDataheader.get(37),waz37);
        listhash.put(listDataheader.get(38),waz38);
        listhash.put(listDataheader.get(39),waz39);
        listhash.put(listDataheader.get(40),waz40);
        listhash.put(listDataheader.get(41),waz41);
        listhash.put(listDataheader.get(42),waz42);
        listhash.put(listDataheader.get(43),waz43);
        listhash.put(listDataheader.get(44),waz44);
        listhash.put(listDataheader.get(45),waz45);
        listhash.put(listDataheader.get(46),waz46);
        listhash.put(listDataheader.get(47),waz47);
        listhash.put(listDataheader.get(48),waz48);
        listhash.put(listDataheader.get(49),waz49);
        listhash.put(listDataheader.get(50),waz50);
        listhash.put(listDataheader.get(51),waz51);


    }

    public void LoadAd(){


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }


    }
}

