package com.werocksta.rxarticles.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.werocksta.rxarticles.R;
import com.werocksta.rxarticles.chapter.Chapter01Fragment;
import com.werocksta.rxarticles.chapter.Chapter02Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChapterActivity extends AppCompatActivity {

    private static final String CHAPTER_01 = "chapter 01";
    private static final String CHAPTER_02 = "chapter 02";

    @BindView(R.id.tvChapter)
    TextView tvChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        ButterKnife.bind(this);

        getChapter();
    }

    private void getChapter() {
        tvChapter.setText(getIntentChapter());
        switchChapter(getIntentChapter());
    }

    private String getIntentChapter() {
        return getIntent().getStringExtra("CHAPTER");
    }

    private void switchChapter(String chapter) {
        switch (chapter) {
            case CHAPTER_01:
                changeFragment(new Chapter01Fragment());
                break;
            case CHAPTER_02:
                changeFragment(new Chapter02Fragment());
                break;
        }
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentContainer, fragment)
                .commit();
    }
}
