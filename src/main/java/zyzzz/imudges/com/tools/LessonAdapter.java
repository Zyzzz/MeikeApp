package zyzzz.imudges.com.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import zyzzz.imudges.com.meikeapp.LessonActivity;
import zyzzz.imudges.com.meikeapp.R;
import zyzzz.imudges.com.model.LessonInformationModel;

/**
 * Created by Administrator on 2018/3/20.
 */

public class LessonAdapter extends BaseAdapter{
    private List<LessonInformationModel.LandcviewEntitiesBean> landcviewEntitiesBeanList;
    private Context mContext;

    LessonAdapter(List<LessonInformationModel.LandcviewEntitiesBean> landcviewEntitiesBeanList,Context mContext){
        this.landcviewEntitiesBeanList = landcviewEntitiesBeanList;
        this.mContext = mContext;

    }
    @Override
    public int getCount() {
        return landcviewEntitiesBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return landcviewEntitiesBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return landcviewEntitiesBeanList.get(position).getLid();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.lessonitem, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//
//                    Intent intent=new Intent(mContext,LessonActivity.class);
//                    Bundle argBundle=new Bundle();
//                    argBundle.putString("coursename",courseModels.get(position).getName());
//                    argBundle.putInt("courseid",courseModels.get(position).getId());
//                    intent.putExtras(argBundle);
//                    mContext.startActivity(intent);
                }
            });
            TextView textView = (TextView) convertView.findViewById(R.id.lessonname);
            textView.setText(landcviewEntitiesBeanList.get(position).getLname());
        }
        return convertView;
    }
}
