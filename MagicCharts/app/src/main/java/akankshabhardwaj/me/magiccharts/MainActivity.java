package akankshabhardwaj.me.magiccharts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import akankshabhardwaj.me.magiccharts.Data.Track;
import akankshabhardwaj.me.magiccharts.Data.Tracks;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<Tracks> , View.OnClickListener {
    LastfmAPI lastfmAPI ;
    ListView listView ;
    Button button ;
    TrackAdapter trackAdapter ;
    List<Track> trackList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        button =  (Button)findViewById(R.id.btn);
        button.setOnClickListener(this);
        trackList = new ArrayList<Track>();
        trackAdapter = new TrackAdapter(this , trackList);
        listView.setAdapter(trackAdapter);
  }
    @Override
    public void onClick(View view) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LastfmAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        lastfmAPI = retrofit.create(LastfmAPI.class);

        switch (view.getId()) {
            case R.id.btn:
                Toast.makeText(MainActivity.this, "pressed " , Toast.LENGTH_LONG).show();
                Call<Tracks> tracksCall = lastfmAPI.getTracks();
                tracksCall.enqueue(this);
                break;
        }
    }

             @Override
    public void onResponse(Call<Tracks> call, Response<Tracks> response) {
        if (response.isSuccessful()) {
            Tracks tracks = response.body();
              trackList = tracks.getTrack();
            StringBuilder builder = new StringBuilder();
            for (Track track: trackList) {
                           builder.append(track.getName());

            }
              Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_SHORT).show();

        } else
        {
            Toast.makeText(MainActivity.this, "Error code " + response.code(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFailure(Call<Tracks> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Did not work " +  t.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
