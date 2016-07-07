package com.android.mvp2.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getLayoutId() != 0)
            setContentView(getLayoutId());

        unbinder = ButterKnife.bind(this);

    }

    protected abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }

    // base view implement

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void close() {

    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void showProgress(String msg, int progress) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showErrorMessage(String msg, String content) {

    }
}