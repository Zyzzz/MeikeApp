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
import zyzzz.imudges.com.model.CommentModel;
import zyzzz.imudges.com.model.CourseInformationModel;

/**
 * Created by Administrator on 2018/3/19.
 */

public class CommentAdapter extends BaseAdapter {

    private List<CommentModel> commentModels;
    private Context mContext;

    public CommentAdapter(List<CommentModel> commentModels, Context mContext){
        this.commentModels=commentModels;
        this.mContext=mContext;
    }

    public List<CommentModel> getCommentModels() {
        return commentModels;
    }

    public void setCommentModels(List<CommentModel> commentModels) {
        this.commentModels = commentModels;
    }

    @Override
    public int getCount() {
        return  (commentModels==null)?0:commentModels.size();
    }

    @Override
    public Object getItem(int position) {
        return commentModels.get(position);
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.comment_item, null);
            TextView textView = (TextView) convertView.findViewById(R.id.cuser_name);
            TextView commenttextView = (TextView) convertView.findViewById(R.id.commenttextview);
            TextView commenttime = (TextView) convertView.findViewById(R.id.commenttime);
            textView.setText(commentModels.get(position).getUsername());
            commenttime.setText(commentModels.get(position).getTime());
            commenttextView.setText(commentModels.get(position).getComment());
        }
        return convertView;
    }
}
