package zyzzz.imudges.com.meikeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import zyzzz.imudges.com.model.CommentModel;
import zyzzz.imudges.com.tools.CommentAdapter;

public class CommentsActivity extends AppCompatActivity {

    ListView commentlist;
    List<CommentModel> commentModels;
    CommentAdapter commentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        commentModels = new ArrayList<>();
        commentlist = (ListView) findViewById(R.id.commentlist);
        final SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        commentAdapter = new CommentAdapter(getDate(),getApplicationContext());
        commentlist.setAdapter(commentAdapter);
        SharedPreferences sp = getSharedPreferences("setting", Context.MODE_PRIVATE);
        final String username = sp.getString("username",null);
        Button button = (Button) findViewById(R.id.commentup);
        final EditText editText = (EditText) findViewById(R.id.comment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username!=null){
                    CommentModel commentModel = new CommentModel();
                    commentModel.setUsername(username);
                    commentModel.setComment(editText.getText().toString());
                    commentModel.setTime(df.format(new Date()));
                    commentModels.add(commentModel);
                    commentAdapter = new CommentAdapter(commentModels,getApplicationContext());
                    commentlist.setAdapter(commentAdapter);
                }else {
                    Toast.makeText(getApplicationContext(),"请登录后评论",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private List<CommentModel>  getDate(){
        CommentModel commentModel1 = new CommentModel();
        commentModel1.setUsername("周炎");
        commentModel1.setComment("课程很不错");
        commentModel1.setTime("2018年3月25日");
        CommentModel commentModel2 = new CommentModel();
        commentModel2.setUsername("Cyy");
        commentModel2.setComment("很好的课程");
        commentModel2.setTime("2018年3月26日");
        commentModels.add(commentModel1);
        commentModels.add(commentModel2);
        return commentModels;
    }


}
