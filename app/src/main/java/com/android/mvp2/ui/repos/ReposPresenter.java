package com.android.mvp2.ui.repos;

import android.content.Context;
import android.util.Log;

import com.android.mvp2.AppApplication;
import com.android.mvp2.data.model.User;
import com.android.mvp2.http.HttpClient;
import com.android.mvp2.http.HttpResultErrorFunc;
import com.android.mvp2.http.HttpResultFunc;
import com.android.mvp2.subscriber.ProgressObserver;
import com.android.mvp2.util.DeviceUtil;
import com.android.mvp2.util.MD5Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cjw on 2016/6/27.
 */
public class ReposPresenter implements ReposContract.Presenter {

    private ReposContract.View mView;

    private Context context;

    public ReposPresenter(Context context) {
        this.context = context;
    }


    @Override
    public void attachView(ReposContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void login(ProgressObserver progressObserver) {

        Map<String, String> map = new HashMap<>();
        map.put("account" , "wuyu");
        map.put("password" , MD5Util.md5("11111"));
        map.put("device_token" , DeviceUtil.getDeviceInfo(AppApplication.getInstance()));
        map.put("device_type" , "1");
        map.put("visit_type" , "1");

        /**
         * onErrorResumeNext 拦截 onError事件（有可能是在请求网络的过程中发出的，
         * 也有可能是 HttpResultFunc 在解析服务器返回数据的时候发现错误而发出的）
         * 主要负责判断并处理 onError 事件里面的错误，然后发出一个"能让view层知道"的错误信息
         */
        HttpClient.getInstance().getMainAPI().login(map)
            .map(new HttpResultFunc<User>() {

                @Override
                public User generateModelFromJSONObject(JSONObject dataObj) throws JSONException {
                    return User.generateUserFromJSONObject(dataObj);
                }
            })
            .onErrorResumeNext(new HttpResultErrorFunc<User>()) // 异常转换器
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(progressObserver);

    }

}
