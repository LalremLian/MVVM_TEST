package com.lalremlian.dummyapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lalremlian.dummyapplication.R;
import com.lalremlian.dummyapplication.data.model.Comment;
import com.lalremlian.dummyapplication.ui.view.DetailsActivity;

import java.util.List;

public class DetailsRecyclerAdapter extends RecyclerView.Adapter<DetailsRecyclerAdapter.myviewholder> {
    List<Comment> postList;
    Context context;

    public DetailsRecyclerAdapter(List<Comment> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    public void updatecommentlist(List<Comment> list) {
        this.postList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsRecyclerAdapter.myviewholder holder, int position) {
        holder.name.setText(postList.get(position).getName());
        holder.comment.setText(postList.get(position).getBody());
    }



    @Override
    public int getItemCount() {
        if (this.postList != null)
            return this.postList.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView name;
        TextView comment;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_tv);
            comment = itemView.findViewById(R.id.body_tv);
        }
    }
}
