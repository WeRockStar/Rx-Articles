package com.werocksta.rxarticles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void sample01() {
        Observable<Integer> sample = Observable.create(subscriber -> {
            subscriber.onNext(10);
        });

        Subscription subscription = sample.subscribe(n -> Log.d("Number", "" + n));
    }
}
