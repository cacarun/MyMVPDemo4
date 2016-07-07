package com.android.mvp2.ui.main;

import android.util.Log;

/**
 * Created by cjw on 2016/6/27.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter() {
    }

    @Override
    public void getClick() {
        Log.e("MainPresenterImpl", "2. in P");
        mView.toReposListActivity();
    }

    @Override
    public void attachView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
