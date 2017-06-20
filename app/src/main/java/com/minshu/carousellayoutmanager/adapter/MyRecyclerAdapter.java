package com.minshu.carousellayoutmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minshu.carousellayoutmanager.R;

import java.util.List;

/**
 * 作者：郭传沛 on 2017/6/20 10:13
 * 邮箱：bestyourselfgcp@163.com
 * 类用途:
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mStrings;
    private Context mContext;

    public MyRecyclerAdapter(List<String> strings, Context context) {
        mStrings = strings;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mItem_text.setText(mStrings.get(position));
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView mItem_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            mItem_text = (TextView) itemView.findViewById(R.id.item_text);
        }
    }
}
