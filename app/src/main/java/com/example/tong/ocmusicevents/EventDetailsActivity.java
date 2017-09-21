package com.example.tong.ocmusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * EventDetails activity that creates a visual representation of the selected events that takes an intent and gets the text from it to display details and
 * title information to the user
 */
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
        ImageView eventImageView=(ImageView)findViewById(R.id.eventImageView);
        //set the text
        titleTextView.setText(title);
        detailsTextView.setText(details);
        //use asset manager to retrieven a file image
        AssetManager am=getAssets();
        String imageFileName = title.replace(" ", "")+ ".jpeg";
        // Use assetmanager to open a stream to the file name
        try {
            InputStream stream=am.open(imageFileName);
            Drawable image= Drawable.createFromStream(stream,title);
            eventImageView.setImageDrawable(image);
        } catch (IOException e) {
            Log.e("OC Music Events", "Error loading image: "+ imageFileName);
            e.printStackTrace();
        }


    }

    /**
     * Method that finishes the current activity after the goBackButton is clicked
     * @param v the buttonID
     */
    protected void goBackToList(View v)
    {
        finish();
    }

}
