package com.example.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class MainActivityFragment extends Fragment {


    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);
        ImageView imgV = (ImageView) view.findViewById(R.id.img);
        String imgUrl = "https://raw.githubusercontent.com/JohnMads/CS6392019/master/brooklyn.png";
        LongOperation longOp = new LongOperation(imgV);
        longOp.execute(imgUrl);
        return view;
    }

    private class LongOperation extends AsyncTask<String, String, Bitmap> {

        ImageView imgV;

        public LongOperation(ImageView imgV) {
            this.imgV = imgV;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bmap = null;
            try {
                URL url = new URL(params[0]);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                if(con.getResponseCode() != 200){
                    throw new Exception("Failed to connect");
                }
                InputStream stream = con.getInputStream();
                bmap = BitmapFactory.decodeStream(stream);
                return bmap;
            } catch(Exception e) {
                Log.e("Image", "Failed to load image", e);
                Log.e("error", e.getMessage());
            }
            return bmap;
        }


        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imgV.setImageBitmap(bitmap);
            ;
        }
    }
}
