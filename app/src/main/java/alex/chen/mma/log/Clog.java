package alex.chen.mma.log;

import android.os.Build;
import android.util.Log;

import alex.chen.mma.BuildConfig;

public class Clog {

    public static void d(String message) {
        if (BuildConfig.DEBUG) {
            Log.d("cc", message);
        }
    }

    public static void e(Throwable throwable) {
        if (BuildConfig.DEBUG) {
            Log.e("cc", throwable.getMessage(), throwable);
        }
    }
}
