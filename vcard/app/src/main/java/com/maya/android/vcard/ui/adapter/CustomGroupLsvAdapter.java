package com.maya.android.vcard.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maya.android.utils.Helper;
import com.maya.android.vcard.R;
import com.maya.android.vcard.entity.ContactGroupEntity;

import java.util.ArrayList;

/**
 * 弹窗中listView适配器
 * Created by Administrator on 2015/8/13.
 */
public class CustomGroupLsvAdapter extends BaseAdapter{
    private Context mContext;
    private int mCurrentPosition = 0;
    private ArrayList<ContactGroupEntity> mCustoms = new  ArrayList<ContactGroupEntity>();
    private ArrayList<Integer> mUnEnablePositionList = null;

    public CustomGroupLsvAdapter(Context mContext){
        this.mContext = mContext;
    }
    private boolean isShowRadio = true;//默认显示选中图标
    @Override
    public int getCount() {
        return mCustoms.size();
    }

    @Override
    public ContactGroupEntity getItem(int position) {
        ContactGroupEntity item = this.mCustoms.get(position);
        if(Helper.isNotNull(item)){
            return item;
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean isEnabled(int position) {
        if(Helper.isNotNull(this.mUnEnablePositionList)){
            if(this.mUnEnablePositionList.contains(position)){
                return false;
            }
        }
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHodler = null;
        if(Helper.isNull(convertView)){
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_fragment_custom_lsv_item, null);
            mHodler = new ViewHolder();
            mHodler.mTxvName = (TextView) convertView.findViewById(R.id.txv_custom_lsv_name);
            mHodler.mImvRadio = (ImageView) convertView.findViewById(R.id.imv_custom_lsv_radio);
            convertView.setTag(mHodler);
        }else{
            mHodler = (ViewHolder) convertView.getTag();
        }
        mHodler.mTxvName.setText(this.getItem(position).getName());
        if(this.isShowRadio){
            mHodler.mImvRadio.setVisibility(View.VISIBLE);
            if(this.mCurrentPosition == position){
                mHodler.mImvRadio.setImageResource(R.mipmap.img_custom_rab_true);
            }else{
                mHodler.mImvRadio.setImageResource(R.mipmap.img_custom_rab_false);
            }
        }else{
            mHodler.mImvRadio.setVisibility(View.GONE);
        }
        if(Helper.isNotNull(this.mUnEnablePositionList)){
            if(isEnabled(position)){
                mHodler.mTxvName.setTextColor(this.mContext.getResources().getColor(R.color.color_292929));
            }else{
                mHodler.mTxvName.setTextColor(this.mContext.getResources().getColor(R.color.color_b7babc));
            }
        }
        return convertView;
    }

    /**
     * 添加数据源
     * @param items
     * @return
     */
    public boolean addItems(ArrayList<ContactGroupEntity> items){
        boolean result = false;
        this.mCustoms.clear();
        if(Helper.isNotNull(items)){
            result = this.mCustoms.addAll(items);
        }
        this.notifyDataSetChanged();
        return result;
    }
    /**
     * 设置不可点击 项
     * @param unEnablePositionList
     */
    public void setUnEnableItems(ArrayList<Integer> unEnablePositionList){
        if(Helper.isNotNull(this.mUnEnablePositionList)){
            this.mUnEnablePositionList.clear();
        }else{
            this.mUnEnablePositionList = new ArrayList<Integer>();
        }
        if(Helper.isNotNull(unEnablePositionList)){
            this.mUnEnablePositionList.addAll(unEnablePositionList);
        }
        notifyDataSetChanged();
    }
    /**
     * 设置 选择位置
     * @param position
     */
    public void setPosition(int position){
        this.mCurrentPosition = position;
        this.notifyDataSetChanged();
    }

    /**
     * 改变选中图标的显示状态
     * @param isShowRadio
     */
    public void setShowRadio(boolean isShowRadio){
        this.isShowRadio = isShowRadio;
    }

    private class ViewHolder{
        private TextView mTxvName;
        private ImageView mImvRadio;
    }
}
