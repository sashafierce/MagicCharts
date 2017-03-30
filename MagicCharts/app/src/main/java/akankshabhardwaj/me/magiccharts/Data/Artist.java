package akankshabhardwaj.me.magiccharts.Data;

/**
 * Created by akanksha on 22/3/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("name")
    @Expose
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}