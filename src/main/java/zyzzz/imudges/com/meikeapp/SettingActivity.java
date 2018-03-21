package zyzzz.imudges.com.meikeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
@ContentView(R.layout.activity_setting)
public class SettingActivity extends AppCompatActivity {
    public static final int EXIT = 200;
    @ViewInject(R.id.exit_sgin_up)
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                SharedPreferences userSettings= getSharedPreferences("setting", 0);
                SharedPreferences.Editor editor = userSettings.edit();
                editor.clear();
                editor.commit();
                setResult(EXIT, intent);
                finish();

            }
        });
    }
}
