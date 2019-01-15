package com.example.suncuoglu.handlerexample.Adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.suncuoglu.handlerexample.Image;
import com.example.suncuoglu.handlerexample.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterPager extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<Image> images;

    public CustomAdapterPager(ArrayList<Image> images, Context context) {
        this.images = images;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.viewpager_item, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        RequestOptions requestOptions = new RequestOptions();

        Glide.with(context)
                .load(images.get(position).getUrl())
                .apply(requestOptions)
                .into(imageView);

        container.addView(view);
        return view;

    }
    public void AddItem(Image image){
        images.add(image);
        notifyDataSetChanged();
    }

}
