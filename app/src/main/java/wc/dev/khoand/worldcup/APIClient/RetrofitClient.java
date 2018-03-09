package wc.dev.khoand.worldcup.APIClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wc.dev.khoand.worldcup.Utils.Constants;

/**
 * Created by khoam on 3/7/2018.
 */

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String url) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return  retrofit;
    }
}
