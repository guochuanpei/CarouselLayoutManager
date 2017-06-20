package com.minshu.carousellayoutmanager;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minshu.carousellayoutmanager.adapter.MyRecyclerAdapter;
import com.minshu.carousellayoutmanager.view.CustomRecyclerView;

import java.util.List;
import java.util.Random;

/**
 * 作者：郭传沛 on 2017/6/19 19:24
 * 邮箱：bestyourselfgcp@163.com
 * 类用途:
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<String> mStrings;
    private Context mContext;
    private final int[] mColors;
    private final Random mRandom = new Random();
    private final MyRecyclerAdapter mMyRecyclerAdapter;

    public MyAdapter(List<String> strings, Context context) {
        mStrings = strings;
        mContext = context;
        mColors = new int[mStrings.size()];
        for (int i = 0; i < mStrings.size(); i++) {
            mColors[i] = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        }
        mMyRecyclerAdapter = new MyRecyclerAdapter(mStrings, mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.re_item, parent, false);
        return new BaseViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
        baseViewHolder.itemView.setBackgroundColor(mColors[position]);
        baseViewHolder.recycler.setLayoutManager(new LinearLayoutManager(mContext));
        baseViewHolder.recycler.setAdapter(mMyRecyclerAdapter);
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {

        private final CustomRecyclerView recycler;

        public BaseViewHolder(View itemView) {
            super(itemView);
            recycler = (CustomRecyclerView) itemView.findViewById(R.id.recycler);
        }
    }
}
