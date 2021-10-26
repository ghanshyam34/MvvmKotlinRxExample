package com.demo.myapplication.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.demo.myapplication.BR;
import com.demo.myapplication.R;
import com.demo.myapplication.databinding.ActivitySplashScreenBinding;
import com.demo.myapplication.ui.base.BaseActivity;
import com.demo.myapplication.ui.namelist.NamesListActivity;

public class SplashScreenActivity extends BaseActivity<ActivitySplashScreenBinding,SplashViewModel> implements SplashNavigator {

    private SplashViewModel mSplashViewModel = new SplashViewModel();

    @Override
    public int getBindingVariable() {
        return BR.SplashVM;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.init();
    }

    @Override
    public void onNext() {
        Intent intent = new Intent(this, NamesListActivity.class);
        startActivity(intent);
        finish();
    }
}