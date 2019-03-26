package alex.chen.mma.http;

import android.os.AsyncTask;

import java.io.IOException;

import alex.chen.mma.log.Clog;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class BaseRequester<T> extends AsyncTask<Void, Void, T> {

    protected abstract String getUrl();
    protected abstract String getGetParams();
    protected abstract FormBody getPostBody();
    protected abstract Request createRequest();
    protected abstract T parseResponse(Response response);
    private HttpCallback<T> httpCallback;

    public BaseRequester(HttpCallback<T> httpCallback) {
        this.httpCallback = httpCallback;
    }

    @Override
    protected T doInBackground(Void... voids) {
        try {
            OkHttpClient okHttpClient = HttpClient.getInstance();
            Request request = createRequest();
            Response response = okHttpClient.newCall(request).execute();
            Clog.d(response.toString());
            return parseResponse(response);
        } catch (IOException e) {
            Clog.e(e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(T t) {
        httpCallback.onResponse(t);
    }

    public interface HttpCallback<T> {
        void onResponse(T t);
    }

}
