package wc.dev.khoand.worldcup.APIClient;

import wc.dev.khoand.worldcup.Utils.Constants;

/**
 * Created by khoam on 3/7/2018.
 */

public class APIUtils {
    private static final String BASE_URL = Constants.ROOT_URL;

    public static APIService getMyService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
