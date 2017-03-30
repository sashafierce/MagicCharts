package akankshabhardwaj.me.magiccharts;

/**
 * Created by akanksha on 22/3/17.
 */
import akankshabhardwaj.me.magiccharts.Data.Tracks;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LastfmAPI {
    String ENDPOINT = "http://ws.audioscrobbler.com/2.0/" ;

    @GET("?method=tag.gettoptracks&format=json&limit=10&api_key=5f1be570431d49f216533f94408db209&tag=acoustic")
    Call<Tracks> getTracks();
}
