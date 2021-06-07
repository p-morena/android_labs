package com.example.task_7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;


    //Добавляем изображения в массив:
    public Integer[] mThumbIds = { R.drawable.audi, R.drawable.bmv,
            R.drawable.ford, R.drawable.honda, R.drawable.hyndai,
            R.drawable.lexus, R.drawable.nissan, R.drawable.porsche,
            R.drawable.reno, R.drawable.subaru, R.drawable.toyota,
            R.drawable.volkswagen};

    //Конструктор:
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
       // imageView = (ImageView) convertView.findViewById(R.id.imagepart);
        imageView.setImageResource(mThumbIds[position]);
        //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);




        return imageView;
    }

}