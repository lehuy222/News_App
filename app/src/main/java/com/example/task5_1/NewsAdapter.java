package com.example.task5_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context mContext;
    private List<News> newsList;
    private OnNewsListener onNewsListener;

    public NewsAdapter(Context mContext, List<News> newsList, OnNewsListener onNewsListener) {
        this.mContext = mContext;
        this.newsList = newsList;
        this.onNewsListener = onNewsListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view, onNewsListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News newsItem = newsList.get(position);
        holder.newsTitle.setText(newsItem.getTitle());
        holder.newsDescription.setText(newsItem.getDescription());
        // Load image using Glide or Picasso
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public interface OnNewsListener {
        void onNewsClick(News news);
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView newsImage;
        TextView newsTitle, newsDescription;
        OnNewsListener onNewsListener;

        public NewsViewHolder(@NonNull View itemView, OnNewsListener onNewsListener) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.news_image);
            newsTitle = itemView.findViewById(R.id.news_title);
            newsDescription = itemView.findViewById(R.id.news_description);
            this.onNewsListener = onNewsListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNewsListener.onNewsClick(newsList.get(getAdapterPosition()));
        }
    }
}
