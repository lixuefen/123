package com.example.lenovo.zuoye920;

import com.example.lenovo.zuoye920.beans.DatasBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/20.
 */

public interface ArtCallBack {
    void OnSuccess(List<DatasBean> data);
    void OnFalie(String str);
}
