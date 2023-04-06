package com.lalremlian.dummyapplication.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lalremlian.dummyapplication.data.model.Comment;
import com.lalremlian.dummyapplication.databinding.CommentItemBinding;

import java.util.List;

public class DetailsRecyclerAdapter extends RecyclerView.Adapter<DetailsRecyclerAdapter.myviewholder> {
    List<Comment> commentList;

    public DetailsRecyclerAdapter(List<Comment> postList) {
        this.commentList = postList;
    }

    public void updatecommentlist(List<Comment> list) {
        this.commentList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CommentItemBinding commentItemBinding = CommentItemBinding.inflate(layoutInflater, parent, false);
        return new myviewholder(commentItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsRecyclerAdapter.myviewholder holder, int position) {
        Comment comment = commentList.get(position);
        holder.binding.setComment(comment);
    }



    @Override
    public int getItemCount() {
        if (this.commentList != null)
            return this.commentList.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        CommentItemBinding binding;
        public myviewholder(@NonNull CommentItemBinding commentItemBinding) {
            super(commentItemBinding.getRoot());
            this.binding = commentItemBinding;
        }
    }
}
