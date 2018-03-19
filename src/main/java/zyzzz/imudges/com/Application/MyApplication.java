package zyzzz.imudges.com.Application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2018/3/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
