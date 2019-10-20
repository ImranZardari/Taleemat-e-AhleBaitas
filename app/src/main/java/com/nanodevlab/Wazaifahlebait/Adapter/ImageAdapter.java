package com.nanodevlab.Wazaifahlebait.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import com.nanodevlab.Wazaifahlebait.Interfaces.IRecyclerViewClickListener;
import com.nanodevlab.Wazaifahlebait.R;


import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext;
    public List<String> Urls;
    IRecyclerViewClickListener listener;


    public ImageAdapter(Context context,List<String> url,IRecyclerViewClickListener listener) {
        mContext = context;
        Urls=url;
        this.listener=listener;



    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

              String currentimage=Urls.get(position);

            ImageView imageView=holder.image;
            final ProgressBar progressBar=holder.progressBar;

        Glide.with(mContext).load(currentimage).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(imageView);



    }

    @Override
    public int getItemCount() {
        return Urls.size();
    }


    //ImageView Holder Class ..................................................

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView image;
        ProgressBar progressBar;

        public ImageViewHolder(View itemView) {
            super(itemView);


        progressBar=itemView.findViewById(R.id.progbar);
        image = itemView.findViewById(R.id.image_view_upload);
        itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }
}