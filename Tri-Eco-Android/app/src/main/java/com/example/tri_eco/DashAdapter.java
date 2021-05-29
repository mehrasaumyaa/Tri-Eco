package com.example.tri_eco;


import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.ViewHolder> {

    private Context context;
    private List<Sell> posts;

    public DashAdapter(Context context, List<Sell> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dash_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sell post = posts.get(position);
        holder.bind(post);
        //holder.tvTime.setText(post.getFormattedTimeStamp());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tvTitle;
            private TextView tvPrice;
            private ImageView ivImage;
            private TextView tvDescription;
            private TextView tvContact;
            private TextView tvCondition;
            private TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvContact = itemView.findViewById(R.id.tvContact);
            tvCondition = itemView.findViewById(R.id.tvCondition);
            tvTime = itemView.findViewById(R.id.tvTime);

        }

        public void bind(Sell post) {
            //bind the post data to view elements
            tvTitle.setText(post.getTitle());
            tvPrice.setText(post.getPrice());
            tvDescription.setText(post.getDescription());
            tvContact.setText(post.getUser().getUsername()); //TODO: switch to another screen for contact
            tvCondition.setText(post.getCondition());
            ParseFile image = post.getImage();
            tvTime.setText(post.getFormattedTimeStamp().toString());
            Log.i("Dash Adapter", post.getFormattedTimeStamp().toString());
            if (image != null) {
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);
            }
        }
    }
}
