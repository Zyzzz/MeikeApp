package zyzzz.imudges.com.meikeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import zyzzz.imudges.com.model.CourseInformationModel;
import zyzzz.imudges.com.model.LessonInformationModel;
import zyzzz.imudges.com.tools.CourseAdapter;
import zyzzz.imudges.com.tools.DataFactory;
import zyzzz.imudges.com.tools.FileStorage;
import zyzzz.imudges.com.tools.LessonAdapter;

import static zyzzz.imudges.com.tools.DataFactory.jsonToArrayList;

@ContentView(R.layout.activity_lesson)
public class LessonActivity extends AppCompatActivity {
    @ViewInject(R.id.coursenametv)
    TextView coursenametv;
    @ViewInject(R.id.lessonlist)
    ListView lessonList;
    LessonAdapter lessonAdapter;
    List<LessonInformationModel.LandcviewEntitiesBean> landcviewEntitiesBeanList =
            new ArrayList<LessonInformationModel.LandcviewEntitiesBean>();

    int courseid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String coursename = getIntent().getStringExtra("coursename");
        coursenametv.setText(coursename);
        courseid = getIntent().getIntExtra("courseid",0);
        if(courseid!=0){
            initListData(courseid);
        }

    }
    private void initListData(int courseid){
        FileStorage fileStorage = new FileStorage();
        //fileStorage.getUrl("userLogin")
        RequestParams params = new RequestParams(fileStorage.getUrl("getLessonsByCourseId"));
        params.addQueryStringParameter("CourseId",Integer.toString(courseid));
        x.http().get(params, new Callback.CommonCallback<String>() {
            LessonInformationModel lessonInformationModel;
            @Override
            public void onSuccess(String result) {
                lessonInformationModel = (LessonInformationModel) DataFactory.getInstanceByJson(LessonInformationModel.class,result);
                landcviewEntitiesBeanList.addAll(lessonInformationModel.getLandcviewEntities());
                lessonAdapter = new LessonAdapter(landcviewEntitiesBeanList,LessonActivity.this);
                lessonList.setAdapter(lessonAdapter);

            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (ex instanceof HttpException) { // 网络错误
                    Toast.makeText(LessonActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                    HttpException httpEx = (HttpException) ex;
                    int responseCode = httpEx.getCode();
                    String responseMsg = httpEx.getMessage();
                    String errorResult = httpEx.getResult();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.comment, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_compose) {
            Intent intent=new Intent(LessonActivity.this,CommentsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
