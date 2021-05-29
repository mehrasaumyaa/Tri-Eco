package com.example.tri_eco.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tri_eco.R;
import com.example.tri_eco.Sell;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends DashFragment {
    public static final String TAG= "ProfileFragment";
    private ImageView ivProfile;
    private TextView tvName;
    private TextView tvCollege;
    private TextView tvEmail;

    public ProfileFragment (){
        //empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivProfile = view.findViewById(R.id.ivProfile);
        tvName = view.findViewById(R.id.tvName);
        tvCollege = view.findViewById(R.id.tvCollege);
        tvEmail = view.findViewById(R.id.tvEmail);
    }

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
