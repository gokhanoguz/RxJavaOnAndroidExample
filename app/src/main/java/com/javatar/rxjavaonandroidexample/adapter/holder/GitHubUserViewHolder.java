package com.javatar.rxjavaonandroidexample.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.javatar.rxjavaonandroidexample.R;
import com.javatar.rxjavaonandroidexample.model.GitHubUser;

/**
 * Created by gokhan on 19-Feb-17.
 */

public class GitHubUserViewHolder {
    private TextView loginTextView;
    private TextView htmlUrlTextView;
    private ImageView avatarImageView;

    public GitHubUserViewHolder(View view) {
        loginTextView = (TextView) view.findViewById(R.id.login);
        htmlUrlTextView = (TextView) view.findViewById(R.id.htmlUrl);
        avatarImageView = (ImageView) view.findViewById(R.id.avatar);
    }

    public void setUser(GitHubUser gitHubUser, Context context) {
        loginTextView.setText(gitHubUser.login);
        htmlUrlTextView.setText(gitHubUser.htmlUrl);
        Glide.with(context)
                .load(gitHubUser.avatarUrl)
                .centerCrop()
                .crossFade()
                .into(avatarImageView);
    }
}
