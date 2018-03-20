package zyzzz.imudges.com.meikeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_lesson)
public class LessonActivity extends AppCompatActivity {
    @ViewInject(R.id.coursenametv)
    TextView coursenametv;
    @ViewInject(R.id.lessonlist)
    ListView lessonList;

    int courseid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String coursename = getIntent().getStringExtra("coursename");
        coursenametv.setText(coursename);
        courseid = getIntent().getIntExtra("courseid",0);

    }
}
