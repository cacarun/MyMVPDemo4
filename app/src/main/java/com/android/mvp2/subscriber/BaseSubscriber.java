package com.android.mvp2.subscriber;


import com.android.mvp2.exception.APIException;
import com.android.mvp2.exception.ERROR;

import rx.Subscriber;

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onError(Throwable e) {
        if (e instanceof APIException) {
            onError((APIException)e);
        } else {
            onError(new APIException(e, ERROR.UNKNOWN));
        }
    }

    /**
     * 错误回调
     */
    protected abstract void onError(APIException ex);
}
