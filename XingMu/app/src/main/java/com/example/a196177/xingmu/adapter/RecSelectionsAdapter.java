package com.example.a196177.xingmu.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.a196177.xingmu.R;
import com.example.a196177.xingmu.bean.SelectionsBean;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class RecSelectionsAdapter extends RecyclerView.Adapter<RecSelectionsAdapter.ViewHolder> {

    private Context context;
    private List<SelectionsBean.DataEntity> list;

    public RecSelectionsAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<SelectionsBean.DataEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.image_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        RoundedCorners corners = new RoundedCorners(30);
        RequestOptions options = RequestOptions.bitmapTransform(corners)
                .override(530,400);
        Glide.with(context)
                .load(list.get(position).getThumbnail())
                .apply(options)
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null){
                    onItemClickListener.onClick(list.get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(int id);
    }
}
