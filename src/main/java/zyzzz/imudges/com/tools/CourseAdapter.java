package zyzzz.imudges.com.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import zyzzz.imudges.com.meikeapp.LessonActivity;
import zyzzz.imudges.com.meikeapp.R;
import zyzzz.imudges.com.model.CourseInformationModel;

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
        return  (courseModels==null)?0:courseModels.size();
    }

    @Override
    public Object getItem(int position) {
        return courseModels.get(position);
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return courseModels.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(mContext,LessonActivity.class);
                    Bundle argBundle=new Bundle();
                    argBundle.putString("coursename",courseModels.get(position).getName());
                    argBundle.putInt("courseid",courseModels.get(position).getId());
                    intent.putExtras(argBundle);
                    mContext.startActivity(intent);
                }
            });
            TextView textView = (TextView) convertView.findViewById(R.id.coursename);
            textView.setText(courseModels.get(position).getName());
        }
        return convertView;
    }
}
