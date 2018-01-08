package com.example.gabriel.letgo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustPageAdapter extends FragmentPagerAdapter{
    public CustPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new ProfileFragment();
            case 1:
                return new GoodsGalleryFragment();
            case 2:
                return new AllChatsFragment();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
