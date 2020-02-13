package edu.miracosta.cs134.sandiegomusicevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EventDetailsActivity extends AppCompatActivity {
//Wire up all the text views and the image view
    ImageView eventImageView;
    TextView eventArtistTextView;
    TextView eventDateDayTextView;
    TextView eventTimeTextView;
    TextView eventVenueTextView;
    TextView eventCityTextView;
    TextView eventStateTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        //wire up the views
        eventImageView = findViewById(R.id.eventImageView);
        eventArtistTextView = findViewById(R.id.eventArtistTextView);
        eventDateDayTextView = findViewById(R.id.eventDateDayTextView);
        eventTimeTextView = findViewById(R.id.eventTimeTextView);
        eventVenueTextView = findViewById(R.id.eventVenueTextView);
        eventCityTextView = findViewById(R.id.eventCityTextView);
        eventStateTextView = findViewById(R.id.eventStateTextView);



        //Extract the intent (from MainActivity)
        Intent intent = getIntent();
        String artist = intent.getStringExtra("Artist");
        String date = intent.getStringExtra("Date");
        String day = intent.getStringExtra("Day");

    }
}
