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
            List<String> images = grabFileNames();
            List<Drawable> loadedImages = new ArrayList<>();
            AssetManager assetManager = getActivity().getAssets();
            if(assetManager == null)
                Toast.makeText(getContext(), "Asset Manager is NULL", Toast.LENGTH_LONG).show();
            for (int i = 0; i < images.size(); i++)
            {
                InputStream ims = assetManager.open(images.get(i));
                loadedImages.add(Drawable.createFromStream(ims, null));
            }
            adapter = new MasonAdapter(getContext(), loadedImages);

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Something Has Failed", Toast.LENGTH_LONG).show();
        }
        //mRecyclerView.setNestedScrollingEnabled(true);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        return rootView;
    }
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
