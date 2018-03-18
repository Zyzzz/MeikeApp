package zyzzz.imudges.com.tools;

import android.app.Activity;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2018/3/18.
 */


public class FileStorage {
    private String baseUrl = "http://localhost:8080/";
    public String getBaseUrl() {
        return baseUrl;
    }
    public String getUrl(String url){
        return baseUrl+url;
    }

}
