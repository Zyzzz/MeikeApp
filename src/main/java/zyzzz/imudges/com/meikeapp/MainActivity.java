package zyzzz.imudges.com.meikeapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import zyzzz.imudges.com.model.CourseInformationModel;
import zyzzz.imudges.com.tools.CourseAdapter;
import zyzzz.imudges.com.tools.FileStorage;

import static zyzzz.imudges.com.tools.DataFactory.jsonToArrayList;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{
    @ViewInject(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.courselist)
    ListView coursellist;
    @ViewInject(R.id.computerimageview)
    ImageView computeriv;
    @ViewInject(R.id.computertextview)
    TextView computertv;
    @ViewInject(R.id.kaoyaniv)
    ImageView kaoyaniv;
    @ViewInject(R.id.kaoyantv)
    TextView kaoyantv;
    @ViewInject(R.id.sfiv)
    ImageView sfiv;
    @ViewInject(R.id.sftv)
    TextView sftv;
    @ViewInject(R.id.coursealliv)
    ImageView coursealliv;
    @ViewInject(R.id.coursealltv)
    TextView coursealltv;

    MenuItem userItem;
    TextView tv_UserName;
    CourseAdapter courseAdapter;
    boolean isLogining;
    List<CourseInformationModel.CourseInformationEntitiesBean.CourseEntityBean> courseEntityBeanList
            = new ArrayList<CourseInformationModel.CourseInformationEntitiesBean.CourseEntityBean>();
    public final static int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        isLogining = false;
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        userItem = navigationView.getMenu().findItem(R.id.nav_user);
        tv_UserName = (TextView) headerView.findViewById(R.id.tv_username);
        reLogin();
        initLinsiner();
        courseAdapter = new CourseAdapter(courseEntityBeanList,MainActivity.this);
        coursellist.setAdapter(courseAdapter);
        initList();
    }

    private void initLinsiner() {
        computeriv.setOnClickListener(this);
        computertv.setOnClickListener(this);
        kaoyaniv.setOnClickListener(this);
        kaoyantv.setOnClickListener(this);
        sfiv.setOnClickListener(this);
        sftv.setOnClickListener(this);
        coursealliv.setOnClickListener(this);
        coursealltv.setOnClickListener(this);
    }


    private void initList(){
        FileStorage fileStorage = new FileStorage();
        //fileStorage.getUrl("userLogin")
        RequestParams params = new RequestParams(fileStorage.getUrl("getAllCourse"));
        x.http().get(params, new Callback.CommonCallback<String>() {
            Gson gson =new Gson();
            CourseInformationModel courseInformationModel;
            @Override
            public void onSuccess(String result) {
                courseInformationModel = gson.fromJson(result,CourseInformationModel.class);
                for(int i =0;i<courseInformationModel.getCourseInformationEntities().size();i++){
                    courseEntityBeanList.add(courseInformationModel.getCourseInformationEntities().get(i).getCourseEntity());
                }
                courseAdapter = new CourseAdapter(courseEntityBeanList,MainActivity.this);
                coursellist.setAdapter(courseAdapter);
                courseAdapter.notifyDataSetChanged();

            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (ex instanceof HttpException) { // 网络错误
                    Toast.makeText(MainActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
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

    private void getCourseListByType(String type){
        FileStorage fileStorage = new FileStorage();
        //fileStorage.getUrl("userLogin")
        RequestParams params = new RequestParams(fileStorage.getUrl("getCourseByType"));
        params.addQueryStringParameter("type",type);
        x.http().get(params, new Callback.CommonCallback<String>() {
            List<CourseInformationModel.CourseInformationEntitiesBean.CourseEntityBean> courseEntityBeans;
            @Override
            public void onSuccess(String result) {

                courseEntityBeans = jsonToArrayList(result,CourseInformationModel.CourseInformationEntitiesBean.CourseEntityBean.class);
                courseEntityBeanList.clear();
                courseEntityBeanList.addAll(courseEntityBeans);
                courseAdapter = new CourseAdapter(courseEntityBeanList,MainActivity.this);
                coursellist.setAdapter(courseAdapter);
                courseAdapter.notifyDataSetChanged();
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(MainActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
                if (ex instanceof HttpException) { // 网络错误
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




    private void reLogin() {
        SharedPreferences sp = getSharedPreferences("setting", Context.MODE_PRIVATE);
        String cookie = sp.getString("cookie",null);
        String username = sp.getString("username",null);
        if(cookie!=null){
            userItem.setTitle("用户信息");
            isLogining=true;
            if(username!=null)
                tv_UserName.setText(username);
            else
                tv_UserName.setText("未设置");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode==REQUEST_CODE)
        {
            if(resultCode==LoginActivity.RESULT_CODE)
            {
                isLogining=true;
                Bundle bundle = data.getExtras();
                String str = bundle.getString("username");
                tv_UserName.setText(str);
                userItem.setTitle("用户信息");
            }else if(resultCode==SettingActivity.EXIT){
                isLogining=false;
                tv_UserName.setText("未登录");
                userItem.setTitle("用户登陆");
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_user) {
            // Handle the camera action
            if(isLogining){
                Intent intent=new Intent(MainActivity.this, UserSettingActivity.class);
                startActivity(intent);
            }else {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }

        } else if (id == R.id.nav_course) {
            courseEntityBeanList.clear();
            initList();

        }  else if (id == R.id.nav_manage) {
            Intent intent=new Intent(MainActivity.this, SettingActivity.class);
            startActivityForResult(intent,REQUEST_CODE);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.coursealliv||v.getId()==R.id.coursealltv){
            courseEntityBeanList.clear();
            initList();
        }else if(v.getId()==R.id.computertextview||v.getId()==R.id.computerimageview){
            getCourseListByType("计算机");
        }else if(v.getId()==R.id.sftv||v.getId()==R.id.sfiv){
            getCourseListByType("四六级");
        }else if(v.getId()==R.id.kaoyantv||v.getId()==R.id.kaoyaniv){
            getCourseListByType("考研");
        }

    }
}
