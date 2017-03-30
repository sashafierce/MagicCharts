package akankshabhardwaj.me.magiccharts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import akankshabhardwaj.me.magiccharts.Data.Track;

/**
 * Created by akanksha on 23/3/17.
 */

public class TrackAdapter extends ArrayAdapter<Track> {
    public TrackAdapter(Context context, List<Track> tracks) {
        super(context, 0, tracks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Track track = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
            TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView artist = (TextView) convertView.findViewById(R.id.artist);
        TextView url = (TextView) convertView.findViewById(R.id.url);
        // Populate the data into the template view using the data object
        name.setText(track.getName());
        artist.setText(track.getArtist().getName());
        url.setText(track.getUrl());
        // Return the completed view to render on screen
        return convertView;
    }
}