package com.example.lenovo.zuoye920.presenter;

import com.example.lenovo.zuoye920.ArtCallBack;
import com.example.lenovo.zuoye920.beans.DatasBean;
import com.example.lenovo.zuoye920.model.ArtModel;
import com.example.lenovo.zuoye920.view.ArtView;

import java.util.List;

/**
 * Created by lenovo on 2019/9/20.
 */

public class ArtPresenter implements ArtCallBack{
    private ArtView artView;
    private ArtModel artModel;

    public ArtPresenter(ArtView artView) {
        this.artView = artView;
        artModel = new ArtModel();
    }
    public void initArt() {
        artModel.initArt(this);
    }
    @Override
    public void OnSuccess(List<DatasBean> data) {
        artView.setArtData(data);
    }

    @Override
    public void OnFalie(String str) {
        artView.ShowTo(str);
    }
}
