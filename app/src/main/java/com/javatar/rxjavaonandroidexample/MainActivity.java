package com.javatar.rxjavaonandroidexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.javatar.rxjavaonandroidexample.adapter.UserListAdapter;
import com.javatar.rxjavaonandroidexample.api.GitHubClient;
import com.javatar.rxjavaonandroidexample.model.GitHubUser;
import java.util.List;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private UserListAdapter adapter;
    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new UserListAdapter(this);
        ListView listView = (ListView) findViewById(R.id.user_listview);
        listView.setAdapter(adapter);

        getAllUsers();
    }

    private void getAllUsers() {
        subscription = GitHubClient.getInstance()
                .getAllUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GitHubUser>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError()");
                    }

                    @Override
                    public void onNext(List<GitHubUser> gitHubUsers) {
                        Log.d(TAG, "onNext()");
                        adapter.setGitHubUsers(gitHubUsers);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onDestroy();
    }

}