package example.mvp.com.myapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import example.mvp.com.myapplication.R;
import example.mvp.com.myapplication.model.GitHubRepo;

/**
 * Created by Pranay Bansal on 9/25/2017.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsVH> {

    private Context context;
    private ArrayList<GitHubRepo> posts;
    public PostsAdapter(Context context, ArrayList<GitHubRepo> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public PostsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostsVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_posts,parent,false));
    }

    @Override
    public void onBindViewHolder(PostsVH holder, int position) {
        String title = posts.get(position).getName();
        String body = posts.get(position).getId()+"";
        holder.tvPost.setText(TextUtils.isEmpty(title)?"":title);
        holder.tvPostBody.setText(TextUtils.isEmpty(body)?"":body);
        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Clcik on row",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (posts!=null)?posts.size():0;
    }

    public class PostsVH extends RecyclerView.ViewHolder{
        TextView tvPost;
        TextView tvPostBody;
        LinearLayout llRow;
        public PostsVH(View itemView) {
            super(itemView);
            tvPost = (TextView) itemView.findViewById(R.id.tvPost);
            tvPostBody = (TextView) itemView.findViewById(R.id.tvPostBody);
            llRow = (LinearLayout) itemView.findViewById(R.id.llRow);
        }
    }
}
