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

        Observable.create(subscriber ->
                subscriber.onNext("Reactive Programming")
        ).subscribe(
                data -> Log.d("Retrieve", (String) data),
                throwable -> Log.e("Error", throwable.getMessage()),
                () -> Log.d("Completed", "No more data")
        );
    }

    @Override
    protected void onStop() {
        super.onStop();

        subscription.unsubscribe();
    }
}
