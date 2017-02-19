package com.javatar.rxjavaonandroidexample.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.javatar.rxjavaonandroidexample.R;
import com.javatar.rxjavaonandroidexample.adapter.holder.GitHubUserViewHolder;
import com.javatar.rxjavaonandroidexample.model.GitHubUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gokhan on 19-Feb-17.
 */

public class UserListAdapter extends BaseAdapter {

    private List<GitHubUser> gitHubUsers = new ArrayList<GitHubUser>();
    private Context mContext;

    public UserListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return gitHubUsers.size();
    }

    @Override
    public GitHubUser getItem(int position) {
        if (position < 0 || position >= gitHubUsers.size()) {
            return null;
        } else {
            return gitHubUsers.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = (convertView != null ? convertView : createView(parent));
        final GitHubUserViewHolder viewHolder = (GitHubUserViewHolder) view.getTag();
        viewHolder.setUser(getItem(position), mContext);
        return view;
    }

    public void setGitHubUsers(@Nullable List<GitHubUser> users) {
        if (users == null) {
            return;
        }
        gitHubUsers.clear();
        gitHubUsers.addAll(users);
        notifyDataSetChanged();
    }

    private View createView(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_github_user, parent, false);
        final GitHubUserViewHolder viewHolder = new GitHubUserViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }
}