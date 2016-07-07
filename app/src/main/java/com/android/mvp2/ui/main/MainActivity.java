package com.android.mvp2.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.mvp2.R;
import com.android.mvp2.ui.BaseActivity;
import com.android.mvp2.ui.repos.ReposListActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getName();

    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainPresenter = new MainPresenter();
        mMainPresenter.attachView(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }


    @Override
    public int getLayoutId(){
        return R.layout.activity_main;
    }

    @OnClick(R.id.id_main_button)
    public void onShowRepositoriesClick() {
        Log.e(TAG, "1. click");
        mMainPresenter.getClick();
    }

    @Override
    public void toReposListActivity() {
        Log.e(TAG, "3. click back");
        startActivity(new Intent(this, ReposListActivity.class));
    }
}
