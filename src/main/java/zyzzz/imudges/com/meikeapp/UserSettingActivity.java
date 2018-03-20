package zyzzz.imudges.com.meikeapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import zyzzz.imudges.com.model.UserModel;
import zyzzz.imudges.com.tools.FileStorage;

@ContentView(R.layout.activity_user_setting)
public class UserSettingActivity extends AppCompatActivity {
    @ViewInject(R.id.userNickname)
    AutoCompleteTextView userNickname;
    @ViewInject(R.id.user_age)
    EditText userAge;
    @ViewInject(R.id.user_phone)
    EditText userPhone;
    @ViewInject(R.id.user_address)
    EditText usetAddress;
    @ViewInject(R.id.user_setting_save)
    Button settingSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initData();
        settingSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = userNickname.getText().toString();
                String age = userAge.getText().toString();
                String phone = userPhone.getText().toString();
                String address = usetAddress.getText().toString();
                saveSetting(nickname,age,phone,address);
                SharedPreferences userSettings = getSharedPreferences("setting", 0);
                SharedPreferences.Editor editor = userSettings.edit();
                editor.putString("username",nickname);
                editor.putInt("age",Integer.parseInt(age));
                editor.putString("phone",phone);
                editor.putString("address",address);
                editor.commit();
            }
        });
    }

    private void  saveSetting(String nickname,String age, String phone,String address){
        FileStorage fileStorage = new FileStorage();
        //fileStorage.getUrl("userLogin")
        RequestParams params = new RequestParams(fileStorage.getUrl("ModfityStudent"));
        params.addQueryStringParameter("nickname",nickname);
        params.addQueryStringParameter("age",age);
        params.addQueryStringParameter("phone",phone);
        params.addQueryStringParameter("address",address);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(UserSettingActivity.this,"用户信息修改成功",Toast.LENGTH_SHORT).show();
            }

            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(x.app(), ex.getMessage(), Toast.LENGTH_LONG).show();
                if (ex instanceof HttpException) { // 网络错误
                    HttpException httpEx = (HttpException) ex;
                    Toast.makeText(UserSettingActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
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

    private void initData(){
        SharedPreferences sp = getSharedPreferences("setting", Context.MODE_PRIVATE);
        String username = sp.getString("username",null);
        int age = sp.getInt("age",-1);
        String phone = sp.getString("phone",null);
        String address = sp.getString("address",null);
        userNickname.setText(username);
        userPhone.setText(phone);
        usetAddress.setText(address);
        if(age!=-1){
            userAge.setText(Integer.toString(age));
        }
    }



}
