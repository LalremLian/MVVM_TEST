package com.lalremlian.dummyapplication.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lalremlian.dummyapplication.data.model.Post;
import com.lalremlian.dummyapplication.databinding.RowItemBinding;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myviewholder> {
    List<Post> postList;
    Context context;
    private OnItemClickListener onItemClickListener;

    public RecyclerAdapter(List<Post> list, Context context) {
        this.postList = list;
        this.context = context;
    }

    public void updatepostlist(List<Post> list) {
        this.postList = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Post post);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RowItemBinding rowItemBinding = RowItemBinding.inflate(layoutInflater, parent, false);
        return new myviewholder(rowItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        Post post = postList.get(position);
        holder.binding.setPost(post);
        holder.binding.getRoot().setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(post);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.postList != null)
            return this.postList.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        RowItemBinding binding;
        public myviewholder(@NonNull RowItemBinding rowItemBinding) {
            super(rowItemBinding.getRoot());
            this.binding = rowItemBinding;
        }
    }
}
