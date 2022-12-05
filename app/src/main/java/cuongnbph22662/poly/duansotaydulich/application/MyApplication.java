package cuongnbph22662.poly.duansotaydulich.application;

import android.app.Application;

import cuongnbph22662.poly.duansotaydulich.data_local.DataLocalManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }
}
