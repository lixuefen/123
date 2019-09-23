package com.example.lenovo.zuoye920.presenter;

import com.example.lenovo.zuoye920.DatasCallBack;
import com.example.lenovo.zuoye920.beans.DatasBean;
import com.example.lenovo.zuoye920.model.DatasModel;
import com.example.lenovo.zuoye920.view.ArtView;

import java.util.List;

/**
 * Created by lenovo on 2019/9/20.
 */

public class DatasPresenter implements DatasCallBack{
    private ArtView artView;
    private DatasModel datasModel;

    public DatasPresenter(ArtView artView) {
        this.artView = artView;
        datasModel = new DatasModel();
    }

    @Override
    public void OnSuccess(List<DatasBean> data) {
    }

    @Override
    public void OnFaile(String str) {

    }


    public void insert(DatasBean data) {
        datasModel.addData(data,this);
    }

    public void delete(DatasBean datasBean) {
        datasModel.delete(datasBean,this);
    }
}
