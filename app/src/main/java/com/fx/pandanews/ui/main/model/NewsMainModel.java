package com.fx.pandanews.ui.main.model;


import android.util.Log;

import com.fx.pandanews.app.AppApplication;
import com.fx.pandanews.app.AppConstant;
import com.fx.pandanews.bean.NewsChannelTable;
import com.fx.pandanews.db.NewsChannelTableManager;
import com.fx.pandanews.ui.main.contract.NewsMainContract;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.commonutils.ACache;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by fangxiong on 2017/9/2.
 */
public class NewsMainModel implements NewsMainContract.Model {
    @Override
    public Observable<List<NewsChannelTable>> lodeMineNewsChannels() {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>(){
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                ArrayList<NewsChannelTable> newsChannelTableList = (ArrayList<NewsChannelTable>) ACache.get(AppApplication.getAppContext()).getAsObject(AppConstant.CHANNEL_MINE);
                if(newsChannelTableList == null){
                    newsChannelTableList= (ArrayList<NewsChannelTable>) NewsChannelTableManager.loadNewsChannelsStatic();
                    ACache.get(AppApplication.getAppContext()).put(AppConstant.CHANNEL_MINE,newsChannelTableList);
                }
                Log.d("NewsChannelTableList"," "+newsChannelTableList.size());
                subscriber.onNext(newsChannelTableList);
                subscriber.onCompleted();
            }
        }).compose(RxSchedulers.<List<NewsChannelTable>>io_main());
    }
}
