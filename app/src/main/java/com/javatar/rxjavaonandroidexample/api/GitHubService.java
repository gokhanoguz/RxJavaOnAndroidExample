package com.javatar.rxjavaonandroidexample.api;

import com.javatar.rxjavaonandroidexample.model.GitHubUser;

import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by gokhan on 19-Feb-17.
 */

public interface GitHubService {
    @GET("users") Observable<List<GitHubUser>> getAllUsers();
}
