package alex.chen.mma.bean;

public class ModuleListBean {

    private NewsListBean newsListBean;
    private VideoListBean videoListBean;
    private SeListBean seListBean;

    public void setNewsListBean(NewsListBean newsListBean) {
        this.newsListBean = newsListBean;
    }

    public NewsListBean getNewsListBean() {
        return newsListBean;
    }
}
