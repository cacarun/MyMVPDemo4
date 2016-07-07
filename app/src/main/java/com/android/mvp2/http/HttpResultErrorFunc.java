package com.android.mvp2.http;

import com.android.mvp2.exception.ExceptionEngine;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by cjw on 2016/7/6.
 */
public class HttpResultErrorFunc<T> implements Func1<Throwable, Observable<T>> {

    @Override
    public Observable<T> call(Throwable throwable) {
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}
