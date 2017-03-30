package akankshabhardwaj.me.magiccharts.Data;

/**
 * Created by akanksha on 22/3/17.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("artist")
    @Expose
    private Artist artist;

//    @SerializedName("image")
//    @Expose
//    private List<Image> image = null;
    @SerializedName("@attr")
    @Expose
    private Attr attr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

//    public List<Image> getImage() {
//        return image;
//    }
//
//    public void setImage(List<Image> image) {
//        this.image = image;
//    }
//
    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

}