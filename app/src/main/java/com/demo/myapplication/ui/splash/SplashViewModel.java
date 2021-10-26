package com.demo.myapplication.ui.splash;
import android.os.Handler;

import com.demo.myapplication.ui.base.BaseViewModel;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {
    public void init() {
       moveToNext();
    }

    public void moveToNext() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getNavigator().onNext();
            }
        }, 1800);
    }
}
