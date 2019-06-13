package com.example.imageviewer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.support.annotation.Nullable;


public class Images extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View imageView = inflater.inflate(R.layout.fragment_images, container, false);

        GridView gridview = (GridView) imageView.findViewById(R.id.gridview);
        gridview.setAdapter(new ImagesAdapter(imageView.getContext()));
        return imageView;
    }
}
