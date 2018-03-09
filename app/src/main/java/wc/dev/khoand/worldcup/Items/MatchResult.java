package wc.dev.khoand.worldcup.Items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * Created by khoam on 3/7/2018.
 */

public class MatchResult {
    @SerializedName("goalsHomeTeam")
    @Expose
    private Object goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private Object goalsAwayTeam;

    public Object getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(Object goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public Object getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(Object goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

}
