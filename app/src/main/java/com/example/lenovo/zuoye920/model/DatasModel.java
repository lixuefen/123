package com.example.lenovo.zuoye920.model;

import com.example.lenovo.zuoye920.BaseApp;
import com.example.lenovo.zuoye920.DatasCallBack;
import com.example.lenovo.zuoye920.beans.DatasBean;
import com.example.lenovo.zuoye920.db.DatasBeanDao;
import com.example.lenovo.zuoye920.presenter.DatasPresenter;

import java.util.List;

/**
 * Created by lenovo on 2019/9/20.
 */

public class DatasModel {

    private DatasBeanDao datasBeanDao;

    public void addData(DatasBean datasBean, DatasCallBack datasCallBack) {
        DatasBeanDao dao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
        dao.insert(datasBean);
        datasCallBack.OnFaile("成功");
    }

    public void delete(DatasBean datasBean, DatasCallBack callBack) {
        DatasBeanDao dao = BaseApp.getInstance().getDaoSession().getDatasBeanDao();
        dao.delete(datasBean);
        callBack.OnFaile("成功");
    }
}
