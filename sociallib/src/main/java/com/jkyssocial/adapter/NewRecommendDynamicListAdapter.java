package com.jkyssocial.adapter;

import android.app.Activity;
import android.view.View;

import com.jkyssocial.common.manager.ApiManager;
import com.jkyssocial.data.Dynamic;
import com.jkyssocial.listener.ListUIListener;

/**
 * Sugar
 * Created by yangxiaolong on 15/9/2.
 */
public class NewRecommendDynamicListAdapter extends NewDynamicListAdapter{

    public NewRecommendDynamicListAdapter(Activity context, ListUIListener listUIListener) {
        super(context, listUIListener, "short-");
    }

    @Override
    public void onBindViewHolder(DynamicTextViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Dynamic dynamic = dynamicList.get(position);
        holder.renqiTV.setVisibility(View.GONE);
        holder.comeVG.setVisibility(View.GONE);
        holder.topicTV.setText(dynamic.getTopic() == null ? "" : "# " + dynamic.getTopic().getName());
    }

    public void create(){
        ApiManager.listDynamicForRecommendNew(this, CREATE_CODE, context, null, PAGING_COUNT);
    }

    public void loadmore(){
        ApiManager.listDynamicForRecommendNew(this, LOAD_MORE_CODE, context, baseLine, PAGING_COUNT);
    }

    public void refresh(){
        ApiManager.listDynamicForRecommendNew(this, REFRESH_CODE, context, null, PAGING_COUNT);
    }

}