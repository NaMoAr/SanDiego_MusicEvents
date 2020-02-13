package edu.miracosta.cs134.sandiegomusicevents;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.Inflater;

import edu.miracosta.cs134.sandiegomusicevents.model.MusicEvent;

public class MusicEventListAdopter extends ArrayAdapter<MusicEvent> {

    //Make instances variables for which of the parameters
    private Context mContext;
    private int mResource;
    private List<MusicEvent> mMusicEventList;

    public MusicEventListAdopter(@NonNull Context context, int resource, @NonNull List<MusicEvent> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        mMusicEventList = objects;
    }

    //override a method call getView
    //ctrl+o => override menu

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource,null);


        //Wire up the linear layout
        LinearLayout musicEventLinearLayout = view.findViewById(R.id.musicEventListLinearLayout);

        MusicEvent selectedEvent = mMusicEventList.get(position);

        //"inflate" the information about the artist name and date
        TextView musicEventListTextView = view.findViewById(R.id.musicEventListTextView);
        musicEventListTextView.setText(selectedEvent.getArtist());


        //set its tag (hidden locker) to be the selected music event
        musicEventLinearLayout.setTag(selectedEvent);



        TextView musicEventListDateTextView = view.findViewById(R.id.musicEventListDateTextView);
        musicEventListDateTextView.setText(selectedEvent.getDate());
        ImageView musicEventImageView = view.findViewById(R.id.musicEventListImageView);
        AssetManager am  = mContext.getAssets();
        try{
            InputStream stream = am.open(selectedEvent.getImageName());
            Drawable image = Drawable.createFromStream(stream, selectedEvent.getArtist());
            musicEventImageView.setImageDrawable(image);
        }catch(IOException e){
            Log.e("SD Music Event", "Error loading " + selectedEvent.getArtist(),e);
        }
        return view;
    }
}
