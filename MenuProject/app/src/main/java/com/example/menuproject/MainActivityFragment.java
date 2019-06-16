package com.example.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);

        Button smsBtn = (Button) view.findViewById(R.id.sms);
        smsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final Intent intentSms = new Intent(Intent.ACTION_SENDTO);
                intentSms.setData(Uri.parse("smsto:" + Uri.encode("19171111111")));
                intentSms.putExtra("sms_body", "John Madias");
                startActivity(intentSms);
            }
        });

        Button phoneBtn = (Button) view.findViewById(R.id.phone);
        phoneBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final Intent intentPhone = new Intent(Intent.ACTION_DIAL);
                intentPhone.setData(Uri.parse("tel:22222222222"));
                startActivity(intentPhone);
            }
        });

        Button webBtn = (Button) view.findViewById(R.id.web);
        webBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://techcrunch.com"));
                startActivity(intentWeb);
            }
        });

        Button mapBtn = (Button) view.findViewById(R.id.map);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                String geoUri = String.format("geo:40.6452227,-74.0152091");
                Uri geo = Uri.parse(geoUri);
                Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(geoMap);
            }
        });

        Button shareBtn = (Button) view.findViewById(R.id.share);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                final Intent chooser = new Intent(Intent.ACTION_SEND);
                chooser.setType("text/plain");
                chooser.putExtra(Intent.EXTRA_SUBJECT, "CS639");
                chooser.putExtra(Intent.EXTRA_TEXT, "Join CS639");
                startActivity(Intent.createChooser(chooser, "Share the love"));
            }
        });

        Button newActivityBtn = (Button) view.findViewById(R.id.new_activity);
        newActivityBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent newActivity = new Intent(getActivity(), NewActivity.class);
                startActivity(newActivity);
            }
        });

        return view;

    }

}
