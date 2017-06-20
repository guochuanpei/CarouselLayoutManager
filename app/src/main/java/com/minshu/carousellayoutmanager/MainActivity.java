package com.minshu.carousellayoutmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList_horizontal;
    private List<String> mStrings;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        mList_horizontal = (RecyclerView) findViewById(R.id.list_horizontal);
        mMyAdapter = new MyAdapter(mStrings, this);

        /**
         * 关键布局管理器
         */
        final CarouselLayoutManager carouselLayoutManager = new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL,false);
        carouselLayoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        carouselLayoutManager.setMaxVisibleItems(2);
        mList_horizontal.setLayoutManager(carouselLayoutManager);
        mList_horizontal.setHasFixedSize(true);
        mList_horizontal.setAdapter(mMyAdapter);
        mList_horizontal.addOnScrollListener(new CenterScrollListener());
//        DefaultChildSelectionListener.initCenterItemListener(new DefaultChildSelectionListener.OnCenterItemClickListener() {
//            @Override
//            public void onCenterItemClicked(@NonNull final RecyclerView recyclerView, @NonNull final CarouselLayoutManager carouselLayoutManager, @NonNull final View v) {
//                final int position = recyclerView.getChildLayoutPosition(v);
//                final String msg = String.format(Locale.US, "Item %1$d was clicked", position);
//                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//        }, mList_horizontal, carouselLayoutManager);
//        carouselLayoutManager.addOnItemSelectionListener(new CarouselLayoutManager.OnCenterItemSelectionListener() {
//
//            @Override
//            public void onCenterItemChanged(final int adapterPosition) {
//                if (CarouselLayoutManager.INVALID_POSITION != adapterPosition) {
//                    String s = mMyAdapter.mStrings.get(adapterPosition);
///*
//                    adapter.mPosition[adapterPosition] = (value % 10) + (value / 10 + 1) * 10;
//                    adapter.notifyItemChanged(adapterPosition);
//*/
//                }
//            }
//        });
    }

    public void initData() {
        mStrings = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            mStrings.add("我是测试数据" + i);
        }
    }
}
