package alex.chen.mma.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import alex.chen.mma.R;
import alex.chen.mma.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        GankTodayRequester gankTodayRequester = new GankTodayRequester(moduleListBean -> {
//            Clog.d(moduleListBean.getNewsListBean().toString());
//        });
//        gankTodayRequester.execute();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
        .add(R.id.fragment_frame, NewsFragment.newInstance("news")).commit();

    }
}
