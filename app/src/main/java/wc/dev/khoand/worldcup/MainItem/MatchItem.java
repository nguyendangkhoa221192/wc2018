package wc.dev.khoand.worldcup.MainItem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import wc.dev.khoand.worldcup.Items.FixtureItem;

/**
 * Created by khoam on 3/1/2018.
 */

public class MatchItem {
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("fixtures")
    @Expose
    private ArrayList<FixtureItem> fixtures = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ArrayList<FixtureItem> getFixtures() {
        return fixtures;
    }

    public void setFixtures(ArrayList<FixtureItem> fixtures) {
        this.fixtures = fixtures;
    }
}
