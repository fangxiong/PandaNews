package com.fx.pandanews.ui.news.presenter;


import com.fx.pandanews.R;
import com.fx.pandanews.bean.PhotoGirl;
import com.fx.pandanews.ui.news.contract.PhotoListContract;
import com.jaydenxiao.common.baserx.RxSubscriber;

import java.util.List;

/**
 * Created by fangxiong on 2017/9/2.
 */
public class PhotosListPresenter extends PhotoListContract.Presenter{
    @Override
    public void getPhotosListDataRequest(int size, int page) {
             mRxManage.add(mModel.getPhotosListData(size,page).subscribe(new RxSubscriber<List<PhotoGirl>>(mContext,false) {
                 @Override
                 public void onStart() {
                     super.onStart();
                     mView.showLoading(mContext.getString(R.string.loading));
                 }
                 @Override
                 protected void _onNext(List<PhotoGirl> photoGirls) {
                     mView.returnPhotosListData(photoGirls);
                     mView.stopLoading();
                 }

                 @Override
                 protected void _onError(String message) {
                     mView.showErrorTip(message);
                 }
             }));
    }
}
