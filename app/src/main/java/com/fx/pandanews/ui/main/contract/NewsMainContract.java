package com.fx.pandanews.ui.main.contract;


import com.fx.pandanews.bean.NewsChannelTable;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by fangxiong on 2017/9/2.
 */
public interface NewsMainContract {
    interface Model extends BaseModel{
       Observable<List<NewsChannelTable>> lodeMineNewsChannels();
    }

    interface View extends BaseView {
        void returnMineNewsChannels(List<NewsChannelTable> newsChannelsMine);
    }

    abstract  class Presenter extends BasePresenter<View,Model>{
        public abstract void lodeMineChannelsRequest();
    }
}
