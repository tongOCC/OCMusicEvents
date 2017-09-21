package com.example.tong.ocmusicevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        //get the data out of the Intent
        Intent intent= getIntent();
        String title= intent.getStringExtra("title");
        String details=intent.getStringExtra("details");
      //if scope is only on Create
        TextView titleTextView=(TextView) findViewById(R.id.eventTitleTextView);
        TextView detailsTextView=(TextView)findViewById(R.id.eventDetailsTextView);
        //set the text
        titleTextView.setText(title);
        detailsTextView.setText(details);

    }

}
