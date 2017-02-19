package com.javatar.rxjavaonandroidexample.model;

/**
 * Created by gokhan on 19-Feb-17.
 */

public class GitHubUser {
    public final int id;
    public final String login;
    public final String htmlUrl;
    public final String avatarUrl;

    public GitHubUser(String avatarUrl, String htmlUrl, String login, int id) {
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
        this.login = login;
        this.id = id;
    }
}
