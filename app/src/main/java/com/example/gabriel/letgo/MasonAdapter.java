package com.example.gabriel.letgo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Gabriel on 1/8/2018.
 */

public class MasonAdapter extends RecyclerView.Adapter<MasonAdapter.MasonView> {
   Context context;
   List<Drawable> images;

    public MasonAdapter(Context context, List<Drawable> images)
    {
        this.context = context;
        this.images = images;
    }

    @Override
    public MasonView onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mason_tile, parent, false);
        MasonView masonView = new MasonView(layoutView);
        return masonView;
    }

    @Override
    public void onBindViewHolder(MasonView holder, int position) {
        Glide.with(context)
                .load(images.get(position))
                .thumbnail(0.02f)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MasonView extends RecyclerView.ViewHolder {
    ImageView imageView;
        public MasonView(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
        }
    }
}
