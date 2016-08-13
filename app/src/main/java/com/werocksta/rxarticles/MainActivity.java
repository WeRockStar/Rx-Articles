package com.werocksta.rxarticles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sample01();
    }

    private void sample01() {

        Observable<String> sampleString = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Reactive Programming");
                subscriber.onError(new NullPointerException());
                subscriber.onCompleted();
            }
        });

        subscription = sampleString.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d("Completed", "No more data");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("Error", e.getMessage());
            }

            @Override
            public void onNext(String data) {
                Log.d("Retrieve", data);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();

        subscription.unsubscribe();
    }
}
