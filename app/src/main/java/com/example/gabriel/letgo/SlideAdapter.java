package com.example.gabriel.letgo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter{
    private Context context; //where we are launching from, this time its main activity
    //private List<String> titles = new ArrayList<>(); //this will contain all the screens
    private String[] titles = {"1", "2", "3"};

    public SlideAdapter(Context contexto)
    {
        context = contexto;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.disp_image, container, false);
        TextView title = view.findViewById(R.id.textView);
        title.setText(titles[position]);
        container.addView(view);
        return view;
    }
    @Override
    public int getCount()
    {
        return 3;
    }


    public void destroyItem(ViewGroup container, int pos, Object object)
    {
        container.removeView((View) object);
    }
    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }
}
