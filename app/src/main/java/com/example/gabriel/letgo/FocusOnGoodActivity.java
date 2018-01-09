package com.example.gabriel.letgo;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Gabriel on 1/5/2018.
 */

public class FocusOnGoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focused_goods_view);
        Bundle passed = getIntent().getExtras();
        String imageName = "0.JPG";
        if(passed != null)
        {
            imageName = passed.getString("key");

        }
        ImageView img = findViewById(R.id.focused_good_image);
        AssetManager assetManager = getAssets();
        InputStream ims = null;
        try {
            ims = assetManager.open(imageName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        img.setImageDrawable(Drawable.createFromStream(ims, null));
    }
}