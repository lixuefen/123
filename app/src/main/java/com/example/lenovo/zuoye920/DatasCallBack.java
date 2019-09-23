package com.example.lenovo.zuoye920;

import com.example.lenovo.zuoye920.beans.DatasBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/20.
 */

public interface DatasCallBack {
    void OnSuccess(List<DatasBean> data);
    void OnFaile(String str);
}
