package com.werocksta.rxarticles.chapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.werocksta.rxarticles.R;

import rx.Observable;

public class Chapter01Fragment extends Fragment {

    public Chapter01Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter01, container, false);

        sample01();
        sample02();
        sample03();
        sample04();

        return view;
    }

    private void sample01() {

        Observable<String> sampleString = Observable.create(subscriber ->
                subscriber.onNext("Reactive Programming")
        );

        sampleString.map(String::toLowerCase)
                .subscribe(data -> Log.d("Retrieve", data));

        sampleString.map(String::toUpperCase)
                .subscribe(data -> Log.d("Retrieve", data));

    }

    private void sample02() {
        Observable.just(showHelloWorld())
                .subscribe(
                        message -> Log.d("Message", message),
                        throwable -> Log.d("Error", throwable.getMessage()),
                        () -> Log.d("Completed", "No more data"));
    }

    private void sample03() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(n -> n % 2 == 0)
                .subscribe(n -> Log.d("Number Odd", n + ""));
    }

    private void sample04() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .filter(n -> n % 2 == 0)
                .take(2)
                .subscribe(n -> Log.d("Number Odd", n + ""));
    }

    private String showHelloWorld() {
        return "Hello world";
    }


}
