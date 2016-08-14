package com.werocksta.rxarticles.chapter01;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.werocksta.rxarticles.R;

public class Chapter02Fragment extends Fragment {


    public Chapter02Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chapter02, container, false);
    }

}
