package com.wesleyreisz.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.mymusic.model.Song;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Dillion on 10/19/2015.
 */
public class SongAdapter extends ArrayAdapter<Song> {
    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy (EEE)");
    private Context mContext;
    private List<Song> mEntries;

    public SongAdapter(Context context, int resource, List<Song> objects) {
        super(context, resource, objects);

        mContext = context;
        mEntries = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_song_layout, parent, false);
        }

        final Song song = mEntries.get(position);

        TextView textViewTitle = (TextView)convertView.findViewById(R.id.textView_songTitle);
        textViewTitle.setText(song.getSongTitle());
        TextView textViewArtist = (TextView)convertView.findViewById(R.id.textView_songArtist);
        textViewArtist.setText(song.getArtistName());
        TextView textViewDate = (TextView)convertView.findViewById(R.id.textView_songYear);
        textViewDate.setText(df.format(song.getSongPublishedDate()));


        return convertView;
    }
}
