package com.android.mvp2.ui;

/**
 * MVP中所有 View的接口
 */
public interface BaseView {

    void showMessage(String msg);

    void close();

    void showProgress(String msg);

    void showProgress(String msg, int progress);

    void hideProgress();

    void showErrorMessage(String msg, String content);
}
