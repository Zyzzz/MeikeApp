package zyzzz.imudges.com.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import zyzzz.imudges.com.model.CourseInformationModel;
import zyzzz.imudges.com.model.CourseModel;

/**
 * Created by Administrator on 2018/3/19.
 */

public class CourseAdapter extends BaseAdapter {

    private List<CourseInformationModel.CourseInformationEntitiesBean.CourseEntityBean> courseModels;
    private Context mContext;

    public CourseAdapter(List<CourseInformationModel.CourseInformationEntitiesBean.CourseEntityBean> courseModels,Context mContext){
        this.courseModels=courseModels;
        this.mContext=mContext;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
