package com.android.mvp2.subscriber;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import com.android.mvp2.exception.APIException;
import com.android.mvp2.util.DialogUtil;

public abstract class ProgressObserver<T> extends BaseSubscriber<T> {

    private Dialog dialog;

    public ProgressObserver(Context context) {
        dialog = DialogUtil.createLoadingDialog(context, "正在加载...");
    }

    @Override
    public void onStart() {
        Log.e("onStart", Thread.currentThread().getName());
        dialog.show();
        super.onStart();
    }

    @Override
    protected void onError(APIException ex) {
        String displayMessage = ex.getDisplayMessage();
        Log.e("onError", "Thread: " + Thread.currentThread().getName() + "  error msg: " + displayMessage);

        dialog.dismiss();
    }

    @Override
    public void onCompleted() {
        Log.e("onCompleted", Thread.currentThread().getName());
        dialog.dismiss();
    }

}
