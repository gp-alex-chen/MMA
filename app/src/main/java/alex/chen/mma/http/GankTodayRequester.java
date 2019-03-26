package alex.chen.mma.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import alex.chen.mma.bean.ModuleListBean;
import alex.chen.mma.bean.NewsBean;
import alex.chen.mma.bean.NewsListBean;
import alex.chen.mma.log.Clog;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

public class GankTodayRequester extends BaseRequester<ModuleListBean> {

    public GankTodayRequester(HttpCallback<ModuleListBean> httpCallback) {
        super(httpCallback);
    }

    @Override
    protected String getUrl() {
        return "http://gank.io/api/today";
    }

    @Override
    protected String getGetParams() {
        return null;
    }

    @Override
    protected FormBody getPostBody() {
        return null;
    }

    @Override
    protected Request createRequest() {
        return new Request.Builder()
                .get()
                .url(getUrl())
                .build();
    }

    @Override
    protected ModuleListBean parseResponse(Response response) {

        JSONArray android = null;
        try {
            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONObject results = jsonObject.getJSONObject("results");
            android = results.getJSONArray("Android");
        } catch (JSONException | IOException e) {
            Clog.e(e);
        }

        NewsListBean newsListBean = new NewsListBean();
        if (android != null) {
            for (int i = 0; i < android.length(); i++) {
                JSONObject item;
                try {
                    item = android.getJSONObject(i);
                    NewsBean newsItem = new NewsBean();
                    newsItem.setId(item.getString("_id"));
                    newsItem.setCreatedAt(item.getString("createdAt"));

                    newsItem.setDesc(item.getString("desc"));
                    newsItem.setPublishedAt(item.getString("publishedAt"));
                    newsItem.setSource(item.getString("source"));
                    newsItem.setType(item.getString("type"));
                    newsItem.setUrl(item.getString("url"));
                    newsItem.setUsed(item.getBoolean("used"));
                    newsItem.setWho(item.getString("who"));

                    newsListBean.addNews(newsItem);
                } catch (JSONException e) {
                    Clog.e(e);
                }
            }
        }
        ModuleListBean moduleListBean = new ModuleListBean();
        moduleListBean.setNewsListBean(newsListBean);
        return moduleListBean;
    }
}
