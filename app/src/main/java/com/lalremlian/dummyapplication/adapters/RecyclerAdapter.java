package com.lalremlian.dummyapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.lalremlian.dummyapplication.R;
import com.lalremlian.dummyapplication.data.model.Post;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myviewholder>
{
    List<Post> postList;
    Context context;

    public RecyclerAdapter(List<Post> list, Context context) {
        this.postList = list;
        this.context = context;
    }

    public void updatepostlist(List<Post> list) {
        this.postList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

      holder.title.setText(postList.get(position).getTitle());
      holder.description.setText(postList.get(position).getBody());

   }

    @Override
    public int getItemCount() {
        if(this.postList !=null)
         return this.postList.size();
        else
            return 0;
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView description;
        CardView cardView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_tv);
            description = itemView.findViewById(R.id.description_tv);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
