package com.example.tong.ocmusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventsListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_events_list);
        // define a built in listAdapter
        setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,MusicEvent.titles));
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        String title= MusicEvent.titles[position];
        String details= MusicEvent.details[position];
        //create intent to go to the details activity
        Intent detailsIntent= new Intent(this, EventDetailsActivity.class);
        detailsIntent.putExtra("title", title);
        detailsIntent.putExtra("details",details);
        startActivity(detailsIntent);
    }
    protected void goBackToList(View v)
    {
        this.finish();
    }
}
