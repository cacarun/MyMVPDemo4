package com.android.mvp2.ui.repos;

import com.android.mvp2.data.model.User;
import com.android.mvp2.subscriber.ProgressObserver;
import com.android.mvp2.ui.BasePresenter;
import com.android.mvp2.ui.BaseView;

import org.json.JSONObject;

import rx.Subscriber;

/**
 * Created by cjw on 2016/6/28.
 */
public interface ReposContract {

    interface Presenter extends BasePresenter<View> {

        void login(ProgressObserver progressObserver);
    }

    interface View extends BaseView {
        // void fillData(String data);
    }

}
