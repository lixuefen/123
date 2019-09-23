package com.example.lenovo.zuoye920;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.zuoye920.adapters.ArtAdapter;
import com.example.lenovo.zuoye920.beans.DatasBean;
import com.example.lenovo.zuoye920.presenter.ArtPresenter;
import com.example.lenovo.zuoye920.presenter.DatasPresenter;
import com.example.lenovo.zuoye920.view.ArtView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ArtView{
    /**
     * 列表
     */
    private TextView mToolBarTitle;
    private Toolbar mMyToolBar;
    private RecyclerView mMyRec;
    private List<DatasBean> datas;
    private ArtPresenter artPresenter;
    private ArtAdapter artAdapter;
    private DatasPresenter datasPresenter;

    //李学峰
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        artPresenter = new ArtPresenter(this);
        datasPresenter = new DatasPresenter(this);
        initView();
        initToolBar();
        initData();
    }
    private void initData() {
        mMyRec.setLayoutManager(new LinearLayoutManager(this));
        mMyRec.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        datas = new ArrayList<>();
        artAdapter = new ArtAdapter(datas, this);
        mMyRec.setAdapter(artAdapter);
        artAdapter.setOnItemClickListener(new ArtAdapter.OnItemClickListener() {
            @Override
            public void OnClickListener(View v, int position) {
                Button bt = v.findViewById(R.id.guanzhu);
                String s = bt.getText().toString();
                if (s.equals("关注")){
                    datasPresenter.insert(datas.get(position));
                    bt.setText("取消");
                }else{
                    datasPresenter.delete(datas.get(position));
                    bt.setText("关注");
                }
            }
        });
        artPresenter.initArt();
    }
    private void initToolBar() {
        mMyToolBar.setTitle("");
        setSupportActionBar(mMyToolBar);
    }
    private void initView() {
        mToolBarTitle = (TextView) findViewById(R.id.ToolBarTitle);
        mMyToolBar = (Toolbar) findViewById(R.id.myToolBar);
        mMyRec = (RecyclerView) findViewById(R.id.myRec);
    }
    @Override
    public void setArtData(List<DatasBean> data) {
        datas.addAll(data);
        artAdapter.notifyDataSetChanged();
    }
    @Override
    public void ShowTo(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
