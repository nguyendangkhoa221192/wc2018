package wc.dev.khoand.worldcup.Items;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import wc.dev.khoand.worldcup.Utils.Constants;

/**
 * Created by khoam on 3/7/2018.
 */

public class FixtureItem implements Parcelable{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("soccerseasonId")
    @Expose
    private Integer soccerseasonId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("homeTeamName")
    @Expose
    private String homeTeamName;
    @SerializedName("homeTeamId")
    @Expose
    private Integer homeTeamId;
    @SerializedName("awayTeamName")
    @Expose
    private String awayTeamName;
    @SerializedName("awayTeamId")
    @Expose
    private Integer awayTeamId;
    @SerializedName("result")
    @Expose
    private MatchResult result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoccerseasonId() {
        return soccerseasonId;
    }

    public void setSoccerseasonId(Integer soccerseasonId) {
        this.soccerseasonId = soccerseasonId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getDateFormat() {
        try {
            String str_date = this.getDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.FORMAT_DATE);
            Date date = simpleDateFormat.parse(str_date);
            return date;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public Integer getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(Integer awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public MatchResult getResult() {
        return result;
    }

    public void setResult(MatchResult result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mData);
    }

    public static final Parcelable.Creator<FixtureItem> CREATOR = new Parcelable.Creator<FixtureItem>() {
      public FixtureItem createFromParcel(Parcel in) {
          return new FixtureItem(in);
      }

      public FixtureItem[] newArray(int size) {
          return new FixtureItem[size];
      }
    };

    private int mData;

    private FixtureItem(Parcel in) {
        mData = in.readInt();
    }
}
