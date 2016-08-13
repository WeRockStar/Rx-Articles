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
        sample02();
    }

    private void sample01() {

        Observable<String> sampleString = Observable.create(subscriber ->
                subscriber.onNext("Reactive Programming")
        );

        sampleString.map(data -> data.toLowerCase())
                .subscribe(data -> Log.d("Retrieve", data));

        sampleString.map(data -> data.toUpperCase())
                .subscribe(data -> Log.d("Retrieve", data));

    }

    private void sample02() {
        Observable.just(showHelloWorld())
                .subscribe(
                        message -> Log.d("Message", message),
                        throwable -> Log.d("Error", throwable.getMessage()),
                        () -> Log.d("Completed", "No more data"));
    }

    private String showHelloWorld() {
        return "Hello world";
    }

    @Override
    protected void onStop() {
        super.onStop();

        // subscription.unsubscribe();
    }
}
