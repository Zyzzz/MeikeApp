package zyzzz.imudges.com.meikeapp;

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
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import zyzzz.imudges.com.model.UserModel;
import zyzzz.imudges.com.tools.FileStorage;

public class RegisterActivity extends AppCompatActivity {
    EditText reginEmail;
    EditText reginPassword;
    EditText checkPassword;
    Button signuoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reginEmail = (EditText) findViewById(R.id.regin_email);
        reginPassword= (EditText) findViewById(R.id.regin_password);
        checkPassword = (EditText) findViewById(R.id.check_password);
        signuoButton = (Button) findViewById(R.id.email_sign_up_button);
        signuoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRegister();
            }
        });
    }

    private void doRegister(){
        String email = reginEmail.getText().toString();
        String rPassword = reginPassword.getText().toString();
        String cPassword = checkPassword.getText().toString();
        if(!rPassword.equals(cPassword)){
            Toast.makeText(RegisterActivity.this,"两次输入的密码不同" ,Toast.LENGTH_SHORT).show();
        }else if(!isEmailValid(email)){
            Toast.makeText(RegisterActivity.this,"请输入正确邮箱" ,Toast.LENGTH_SHORT).show();
        }else if(!isPasswordValid(rPassword)){
            Toast.makeText(RegisterActivity.this,"密码长度要大于6" ,Toast.LENGTH_SHORT).show();
        }else{
            FileStorage fileStorage = new FileStorage();
            //fileStorage.getUrl("userLogin")
            RequestParams params = new RequestParams(fileStorage.getUrl("user_register"));
            params.addQueryStringParameter("email",email);
            params.addQueryStringParameter("password",cPassword);
            x.http().get(params, new Callback.CommonCallback<String>() {
                String loginResult;
                UserModel userModel;
                @Override
                public void onSuccess(String result) {
                    Gson gson =new Gson();
                    userModel = gson.fromJson(result,UserModel.class);
                    if(userModel.getStatus()==0) {
                        Toast.makeText(RegisterActivity.this,"注册成功" ,Toast.LENGTH_SHORT).show();
                    }else {
                        loginResult = userModel.getResult();
                    }

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
                    finish();
                }

            });
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 6;
    }
}
