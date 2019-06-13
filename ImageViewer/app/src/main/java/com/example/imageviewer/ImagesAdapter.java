package com.example.imageviewer;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

public class ImagesAdapter extends BaseAdapter {
    private Context context;

    ImagesAdapter(Context c) {
        context = c;
    }

    public int getCount() {
        return filmImages.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(20, 20, 20, 20);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(filmImages[position]);
        return imageView;
    }

    // All my movie posters
    private Integer[] filmImages = {
            R.drawable.rear_window, R.drawable.drive,
            R.drawable.bttf, R.drawable.ssr, R.drawable.ready_player_one
    };
}
