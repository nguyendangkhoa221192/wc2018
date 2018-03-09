package wc.dev.khoand.worldcup.APIClient;

import retrofit2.Call;
import retrofit2.http.GET;
import wc.dev.khoand.worldcup.MainItem.MatchItem;

/**
 * Created by khoam on 3/7/2018.
 */

public interface APIService {
    @GET("/fixtures")
    Call<MatchItem> getMatchInfo();
}
