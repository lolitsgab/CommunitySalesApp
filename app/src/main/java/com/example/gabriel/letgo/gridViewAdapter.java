package com.example.gabriel.letgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 1/6/2018.
 */

public class gridViewAdapter extends BaseAdapter
{

    List<Integer> letters = new ArrayList<>();
    Context context;

    public gridViewAdapter(Context context) //make it accept a list when releasing
    {
        //this.letters = letters;
        this.context = context;
        letters.add(R.drawable.a);
        letters.add(R.drawable.b);
        letters.add(R.drawable.c);
        letters.add(R.drawable.d);
        letters.add(R.drawable.e);
        letters.add(R.drawable.f);
        letters.add(R.drawable.g);
        letters.add(R.drawable.h);
        letters.add(R.drawable.i);
        letters.add(R.drawable.j);
        letters.add(R.drawable.k);
        letters.add(R.drawable.m);
        letters.add(R.drawable.n);
        letters.add(R.drawable.l);
        letters.add(R.drawable.o);
        letters.add(R.drawable.p);
        letters.add(R.drawable.q);
        letters.add(R.drawable.r);
        letters.add(R.drawable.s);
        letters.add(R.drawable.t);
        letters.add(R.drawable.u);
        letters.add(R.drawable.v);
        letters.add(R.drawable.w);
        letters.add(R.drawable.x);
        letters.add(R.drawable.y);
        letters.add(R.drawable.z);

    }
    //
    public gridViewAdapter(Context context, File goodNames) //make it accept a list when releasing
    {

    }

    @Override
    public int getCount() {
        return letters.size();
    }

    @Override
    public Object getItem(int i) {
        return letters.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.gallerygrid, parent, false);
        }
        else
        {
            v = convertView;
        }
        ImageView img = v.findViewById(R.id.gridImgDisp);
        Glide.with(context)
                .load(letters.get(i))
                .thumbnail(0.2f)
                .into(img);
        return v;
    }
}
