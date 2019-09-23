package com.example.lenovo.zuoye920.model;

import com.example.lenovo.zuoye920.ApiService;
import com.example.lenovo.zuoye920.ArtCallBack;
import com.example.lenovo.zuoye920.beans.ArtBean;
import com.example.lenovo.zuoye920.beans.DatasBean;
import com.example.lenovo.zuoye920.presenter.ArtPresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2019/9/20.
 */

public class ArtModel {
    public void initArt(final ArtCallBack artCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.ARTURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Observable<ArtBean> observable = service.getArt();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArtBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArtBean artBean) {
                            List<DatasBean> data = artBean.getDatas();
                            artCallBack.OnSuccess(data);
                    }
                    @Override
                    public void onError(Throwable e) {
                        artCallBack.OnFalie("请求失败");
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
