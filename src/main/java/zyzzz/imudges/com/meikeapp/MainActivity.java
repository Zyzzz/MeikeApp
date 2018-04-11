package zyzzz.imudges.com.meikeapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

    private Bitmap head;//头像Bitmap
    private static String path ;//
    MenuItem userItem;
    TextView tv_UserName;
    Dialog mCameraDialog;
    ImageView iv_UserImage;
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
        iv_UserImage = (ImageView) headerView.findViewById(R.id.user_imageview);
        mCameraDialog = new Dialog(this, R.style.BottomDialog);
        reLogin();
        path = Environment.getExternalStorageDirectory().getPath();
        Bitmap bt = BitmapFactory.decodeFile(path + "/head.png");//从Sd中找头像，转换成Bitmap
        if (bt != null) {
            if(isLogining)
            //如果本地有头像图片的话
            iv_UserImage.setImageBitmap(bt);
        }
            initLinsiner();
        courseAdapter = new CourseAdapter(courseEntityBeanList,MainActivity.this);
        coursellist.setAdapter(courseAdapter);
        initList();
    }

    private void initLinsiner() {
        iv_UserImage.setOnClickListener(this);
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
        }else if (requestCode==110) {
            cropPhoto(data.getData());//裁剪图片
        }else if(requestCode==120){
            File temp = new File(Environment.getExternalStorageDirectory()
                    + "/head.png");
            cropPhoto(Uri.fromFile(temp));//裁剪图片
        }else if(requestCode==119){
            if (data != null) {
                Bundle extras = data.getExtras();
                head = extras.getParcelable("data");
                if (head != null) {
                    /**
                     * 上传服务器代码
                     */
                    head = createCircleImage(head);
                    setPicToView(head);//保存在SD卡中
                    iv_UserImage.setImageBitmap(head);//用ImageView显示出来

                    mCameraDialog.cancel();
                }
            }
        }
    }

    public static Bitmap createCircleImage(Bitmap source) {
        int length = source.getWidth() < source.getHeight() ? source.getWidth() : source.getHeight();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(length, length, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        canvas.drawCircle(length / 2, length / 2, length / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }

    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        //找到指定URI对应的资源图片
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        //进入系统裁剪图片的界面
        startActivityForResult(intent, 119);
    }
    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd卡是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建以此File对象为名（path）的文件夹
        String fileName = path + "/head.png";//图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件（compress：压缩）
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
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
        }else if(v.getId()==R.id.user_imageview){
            setDialog();
        }else if(v.getId()==R.id.btn_choose_img){
            Intent intent1 = new Intent(Intent.ACTION_PICK, null);//返回被选中项的URI
            intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");//得到所有图片的URI
//                System.out.println("MediaStore.Images.Media.EXTERNAL_CONTENT_URI  ------------>   "
//                        + MediaStore.Images.Media.EXTERNAL_CONTENT_URI);//   content://media/external/images/media
            startActivityForResult(intent1,110);
        }else if(v.getId()==R.id.btn_open_camera){
            try {
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//开启相机应用程序获取并返回图片（capture：俘获）
                intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                        "head.png")));//指明存储图片或视频的地址URI
                startActivityForResult(intent2, 120);//采用ForResult打开
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "相机无法启动，请先开启相机权限", Toast.LENGTH_LONG).show();
            }
        }else if(v.getId()==R.id.btn_cancel){
            mCameraDialog.cancel();
        }

    }
    private void setDialog() {
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.botton_dialog, null);
        //初始化视图
        root.findViewById(R.id.btn_choose_img).setOnClickListener(this);
        root.findViewById(R.id.btn_open_camera).setOnClickListener(this);
        root.findViewById(R.id.btn_cancel).setOnClickListener(this);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
//        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = root.getMeasuredHeight();

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

}
