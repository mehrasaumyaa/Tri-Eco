package com.example.tri_eco.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tri_eco.DashAdapter;
import com.example.tri_eco.R;
import com.example.tri_eco.Sell;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DashFragment extends Fragment {

    public static final String TAG = "DashFragment";
    private RecyclerView rvDash;
    private DashAdapter adapter;
    private List<Sell> allPosts;
    public DashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvDash = view.findViewById(R.id.rvDash);

        allPosts = new ArrayList<>();
        adapter = new DashAdapter(getContext(), allPosts);
        //steps to use the recycler view:
        // 0. create layout for one row in the list (recycler view)
        // 1. create the adapter
        // 2. create the data source (which is query posts from ComposeFragment)
        // 3. set the adapter on the recycler view
        rvDash.setAdapter(adapter);
        // 4. set the layout manager on the recycler view
        rvDash.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPosts();
    }

    protected void queryPosts(){
        // Specify which class to query
        ParseQuery<Sell> query = ParseQuery.getQuery(Sell.class);
        query.include(Sell.KEY_USER);
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