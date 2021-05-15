package com.example.tri_eco.fragments;

import android.util.Log;

import com.example.tri_eco.Sell;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends DashFragment {

    protected void queryPosts() {
        // Specify which class to query
        ParseQuery<Sell> query = ParseQuery.getQuery(Sell.class);
        query.include(Sell.KEY_USER);
        query.whereEqualTo(Sell.KEY_USER, ParseUser.getCurrentUser());
        //limit the number of posts to be displayed
        query.setLimit(20);
        //newest will come first and oldest will be displayed last acc to mentioned key
        query.addDescendingOrder(Sell.KEY_CREATED_AT);

        query.findInBackground(new FindCallback<Sell>() {
            @Override
            public void done(List<Sell> posts, ParseException e) {
                if(e!=null){
                    Log.e(TAG, "Issue with getting posts");
                    return;
                }
                for(Sell post: posts){
                    Log.i(TAG, "Post: "+ post.getTitle());
                    Log.i(TAG, "Price: "+ post.getPrice());
                    Log.i(TAG, "Description: "+ post.getDescription());
                    Log.i(TAG, "Condition: "+ post.getCondition());
                }
                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();

            }
        });

    }
}
