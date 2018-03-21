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

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCFullScreenActivity;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import zyzzz.imudges.com.meikeapp.LessonActivity;
import zyzzz.imudges.com.meikeapp.R;
import zyzzz.imudges.com.meikeapp.RegisterActivity;
import zyzzz.imudges.com.meikeapp.VideoActivity;
import zyzzz.imudges.com.model.LessonInformationModel;
import zyzzz.imudges.com.model.LessonsInformationEntity;
import zyzzz.imudges.com.model.UserModel;

/**
 * Created by Administrator on 2018/3/20.
 */

public class LessonAdapter extends BaseAdapter{
    private List<LessonInformationModel.LandcviewEntitiesBean> landcviewEntitiesBeanList;
    private Context mContext;

    public  LessonAdapter(List<LessonInformationModel.LandcviewEntitiesBean> landcviewEntitiesBeanList,Context mContext){
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.lessonitem, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String Lname = landcviewEntitiesBeanList.get(position).getLname();
                    int lid= landcviewEntitiesBeanList.get(position).getLid();
                    FileStorage fileStorage = new FileStorage();
                    //fileStorage.getUrl("userLogin")
                    RequestParams params = new RequestParams(fileStorage.getUrl("getLessonsByLid"));
                    params.addQueryStringParameter("lid",Integer.toString(lid));
                    x.http().get(params, new Callback.CommonCallback<String>() {
                        LessonsInformationEntity lessonsInformationEntity ;
                        @Override
                        public void onSuccess(String result) {
                            lessonsInformationEntity =
                                    (LessonsInformationEntity) DataFactory.getInstanceByJson(LessonsInformationEntity.class,result);
                            //Toast.makeText(mContext,lessonsInformationEntity.getLessonsinformationEntity().getUrl(),Toast.LENGTH_SHORT).show();
                            JCFullScreenActivity.startActivity(mContext,lessonsInformationEntity.getLessonsinformationEntity().getUrl(),JCVideoPlayerStandard.class,Lname);

                        }

                        //请求异常后的回调方法
                        @Override
                        public void onError(Throwable ex, boolean isOnCallback) {
                            Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
                            if (ex instanceof HttpException) { // 网络错误
                                HttpException httpEx = (HttpException) ex;
                                int responseCode = httpEx.getCode();
                                String responseMsg = httpEx.getMessage();
                                String errorResult = httpEx.getResult();
                                System.out.print("Code:"+responseCode+"   Message:"+responseMsg+"   Result:"+errorResult);
                            }
                        }

                        //主动调用取消请求的回调方法
                        @Override
                        public void onCancelled(CancelledException cex) {
                        }

                        @Override
                        public void onFinished() {

                        }
                    });

                }
            });
            TextView textView = (TextView) convertView.findViewById(R.id.lessonname);
            textView.setText(landcviewEntitiesBeanList.get(position).getLname());
        }
        return convertView;
    }
}
