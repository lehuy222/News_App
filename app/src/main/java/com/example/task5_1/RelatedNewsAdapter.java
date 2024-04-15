package com.example.task5_1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.RelatedNewsViewHolder> {

    private List<News> relatedNews;

    public RelatedNewsAdapter(List<News> relatedNews) {
        this.relatedNews = relatedNews;
    }

    @NonNull
    @Override
    public RelatedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new RelatedNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedNewsViewHolder holder, int position) {
        News newsItem = relatedNews.get(position);
        holder.newsTitle.setText(newsItem.getTitle());
        holder.newsDescription.setText(newsItem.getDescription());
        // Load the image using Glide or Picasso
    }

    @Override
    public int getItemCount() {
        return relatedNews.size();
    }

    public static class RelatedNewsViewHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsDescription;

        public RelatedNewsViewHolder(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDescription = itemView.findViewById(R.id.news_description);
        }
    }
}