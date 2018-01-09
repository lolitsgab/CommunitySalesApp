package com.example.gabriel.letgo;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodsGalleryFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.gallery_view, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.masonry_grid);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        MasonAdapter adapter = null;
        try {
            List<String> names = grabFileNames(); //grabs names from Assets directory
            List<Drawable> loadedImages = new ArrayList<>(); //Here we will store our drawables that will be generated from above filenames
            AssetManager assetManager = getActivity().getAssets(); //We use an asset manager to get the assets and manipulate
            if(assetManager == null) //If asset folder does not exist or is empty
                Toast.makeText(getContext(), "Asset Manager is NULL", Toast.LENGTH_LONG).show();

            //Below we will run through all the image titles and add them to my input stream
            for (int i = 0; i < names.size(); i++)
            {
                InputStream ims = assetManager.open(names.get(i));
                loadedImages.add(Drawable.createFromStream(ims, null));
            }

            adapter = new MasonAdapter(getContext(), loadedImages, names); //add adapter. If adapter is not attaching, it means there was a problem
                                                                    //loading the images

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Something Has Failed", Toast.LENGTH_LONG).show();
        }
        mRecyclerView.setHasFixedSize(true); //This helps prevent lag on different screen devices
        mRecyclerView.setAdapter(adapter); //set grid adapter onto my recycler view (MasonView)
        return rootView;
    }

    //This will use assetmanager's list method to get all the file names in the folder that end with .JPG
    private List<String> grabFileNames() throws IOException {
        List<String> items = new ArrayList<>();
        AssetManager assetManager = getContext().getAssets();
        for(String s: assetManager.list(""))
        {
            if(s.endsWith(".JPG"))
                items.add(s);
        }
            return items;
    }
}
