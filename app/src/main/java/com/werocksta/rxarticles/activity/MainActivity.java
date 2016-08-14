package com.werocksta.rxarticles.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.werocksta.rxarticles.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        intent = new Intent(this, ChapterActivity.class);
    }

    @OnClick({R.id.btnChapter01, R.id.btnChapter02, R.id.btnChapter03})
    void onClickChapter(View view) {
        intent.putExtra("CHAPTER", ((Button) view).getText().toString());
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
