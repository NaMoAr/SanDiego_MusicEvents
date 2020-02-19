package edu.miracosta.cs134.sandiegomusicevents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import edu.miracosta.cs134.sandiegomusicevents.model.MusicEvent;

public class EventDetailsActivity extends AppCompatActivity {
//Wire up all the text views and the image view
    ImageView eventImageView;
    TextView eventArtistTextView;
    TextView eventDateDayTextView;
    TextView eventTimeTextView;
    TextView eventVenueTextView;
    TextView eventCityTextView;
    TextView eventStateTextView;
    private MusicEvent myMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        myMusic = new MusicEvent();


        eventImageView = findViewById(R.id.eventImageView);
        eventArtistTextView = findViewById(R.id.eventArtistTextView);
        eventDateDayTextView = findViewById(R.id.eventDateDayTextView);
        eventTimeTextView = findViewById(R.id.eventTimeTextView);
        eventVenueTextView = findViewById(R.id.eventVenueTextView);
        eventCityTextView = findViewById(R.id.eventCityTextView);
        eventStateTextView = findViewById(R.id.eventStateTextView);





        Intent intent = getIntent();
        String artist = intent.getStringExtra("Artist");
        String date = intent.getStringExtra("Date");
        String time = intent.getStringExtra("Time");
        String venue = intent.getStringExtra("Venue");
        String city = intent.getStringExtra("City");
        String state = intent.getStringExtra("State");
        String imageName = intent.getStringExtra("ImageName");

        AssetManager am  = this.getAssets();
        try{
            InputStream stream = am.open(imageName);
            Drawable image = Drawable.createFromStream(stream, artist);
            eventImageView.setImageDrawable(image);
        }catch(IOException e){
            Log.e("SD Music Event", "Error loading " + artist,e);
        }

        eventArtistTextView.setText(artist);
        eventDateDayTextView.setText(date);
        eventTimeTextView.setText(time);
        eventVenueTextView.setText(venue);
        eventCityTextView.setText(city);
        eventStateTextView.setText(state);

    }
}
