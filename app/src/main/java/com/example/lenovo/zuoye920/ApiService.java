package com.example.lenovo.zuoye920;

import com.example.lenovo.zuoye920.beans.ArtBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2019/9/20.
 */

public interface ApiService {
    String ARTURL = "http://static.owspace.com/";
    @GET("?c=api&a=getList&page_id=0")
    Observable<ArtBean> getArt();
}
