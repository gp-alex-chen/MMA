package alex.chen.mma.http;

import okhttp3.OkHttpClient;

public class HttpClient {

    static {
        okHttpClient = new OkHttpClient();
    }

    private HttpClient() {
    }

    private static OkHttpClient okHttpClient;

    public static OkHttpClient getInstance() {
        return okHttpClient;
    }
}
