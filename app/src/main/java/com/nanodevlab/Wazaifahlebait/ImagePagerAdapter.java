package com.nanodevlab.Wazaifahlebait;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ImagePagerAdapter extends PagerAdapter{

    private Context context;
    private List<String> imageUrls;
    LayoutInflater layoutInflater;

    ImagePagerAdapter(Context context,List<String> imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
        //this.imageUrls= new ArrayList<>();
    }


    @Override
    public int getCount() {
        return  imageUrls.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=layoutInflater.inflate(R.layout.full_item,null);
        ImageView showimage=v.findViewById(R.id.img);
        String url= imageUrls.get(position);
        Glide.with(context).load(url).apply(new RequestOptions().centerInside()).into(showimage);


        ViewPager viewPager=(ViewPager)container;
        viewPager.addView(v,0);
        return v;

    }




    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager=(ViewPager)container;
        View v=(View)object;
        viewPager.removeView(v);
    }


    public String getItemat(int Po){
        String url=imageUrls.get(Po);
        return url;
    }

}
