package com.example.lenovo.zuoye920.adapters;

import android.app.backup.RestoreObserver;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.zuoye920.R;
import com.example.lenovo.zuoye920.beans.DatasBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/20.
 */

public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ViewHolder>{
    private List<DatasBean> datas;
    private Context context;

    public ArtAdapter(List<DatasBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.art_item_layout,null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(context).load(datas.get(position).getThumbnail()).apply(options).into(holder.thumbnail);
        holder.title.setText(datas.get(position).getTitle());
        holder.author.setText(datas.get(position).getAuthor());
        holder.guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnClickListener(v,position);
            }
        });
    }
    @Override
    public int getItemCount() {
        return datas.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView author;
        Button guanzhu;
        public ViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            guanzhu = itemView.findViewById(R.id.guanzhu);
        }
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void OnClickListener(View v,int position);
    }
}
