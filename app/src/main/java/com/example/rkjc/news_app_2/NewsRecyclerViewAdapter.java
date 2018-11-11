package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ArticleHolder> {

    private Context context;
    public ArrayList<NewsItem> articles1;

    public NewsRecyclerViewAdapter(ArrayList<NewsItem> articles, Context context){
        this.articles1 = articles;
        this.context=context;
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(R.layout.news_item, parent, shouldAttachToParentImmediately);
        ArticleHolder holder = new ArticleHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return articles1.size();
    }

    class ArticleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView description;
        TextView time;


        ArticleHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            description = (TextView)view.findViewById(R.id.description);
            time = view.findViewById(R.id.time);
            view.setOnClickListener(this);
        }

        public void bind(final int pos){

            title.setText(articles1.get(pos).getTitle());
            description.setText(articles1.get(pos).getDescription());
            time.setText(articles1.get(pos).getTime());
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String getInput=articles1.get(getAdapterPosition()).getUrl();
            Intent intent=new Intent(
                    Intent.ACTION_VIEW, Uri.parse(getInput)
            );
            context.startActivity(intent);
        }
    }



}
