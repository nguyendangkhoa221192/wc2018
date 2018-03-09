package wc.dev.khoand.worldcup.MainItem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import wc.dev.khoand.worldcup.Items.CountryTeam;

/**
 * Created by khoam on 3/9/2018.
 */

public class CountryItem {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("teams")
    @Expose
    private ArrayList<CountryTeam> teams = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<CountryTeam> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<CountryTeam> teams) {
        this.teams = teams;
    }
}
