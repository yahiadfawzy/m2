package com.example.bsmallah.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.PostViewHolder> {


    private List<Post> postList;
    private Context context;
    private PostClickListener postClickListener;


    public void setPostes(List<Post> posts){
      postList = posts;
    }

    public PostRecyclerAdapter(List<Post> postList, Context context, PostClickListener postClickListener) {
        this.postList = postList;
        this.context = context;
        this.postClickListener = postClickListener;
    }

    @Override

    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
      return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
      // holder
        holder.title.setText(postList.get(position).getTitle());
        holder.body.setText(postList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView body;

        public PostViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    postClickListener.OnPostClikListener(getAdapterPosition());
                }
            });
        }


    }

    public interface PostClickListener {
       void OnPostClikListener(int position);
    }
}



