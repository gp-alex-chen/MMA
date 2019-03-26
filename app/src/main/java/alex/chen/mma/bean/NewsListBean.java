package alex.chen.mma.bean;

import java.util.ArrayList;

public class NewsListBean {

    private final ArrayList<NewsBean> newsList;

    public NewsListBean() {
        this.newsList = new ArrayList<>();
    }

    public void addNews(NewsBean newsBean) {
        newsList.add(newsBean);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (NewsBean newsBean : newsList) {
            sb.append(newsBean.toString());
        }
        return sb.toString();
    }
}
