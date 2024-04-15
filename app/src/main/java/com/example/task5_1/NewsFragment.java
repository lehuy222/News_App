package com.example.task5_1;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsFragment extends Fragment {

    private static final String ARG_NEWS = "news";

    private News news;
    private RecyclerView rvRelatedStories;
    private RelatedNewsAdapter relatedNewsAdapter;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance(News news) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_NEWS, news);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            news = (News) getArguments().getSerializable(ARG_NEWS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        ImageView ivDetailImage = view.findViewById(R.id.ivDetailImage);
        TextView tvDetailTitle = view.findViewById(R.id.tvDetailTitle);
        TextView tvDetailDescription = view.findViewById(R.id.tvDetailDescription);

        rvRelatedStories = view.findViewById(R.id.rvRelatedStories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvRelatedStories.setLayoutManager(layoutManager);

        if (news != null) {
            tvDetailTitle.setText(news.getTitle());
            tvDetailDescription.setText(news.getDescription());
            // Load the image using Glide or Picasso
            // Example with Picasso: Picasso.get().load(news.getImageUrl()).into(ivDetailImage);

            relatedNewsAdapter = new RelatedNewsAdapter(news.getRelatedNews());
            rvRelatedStories.setAdapter(relatedNewsAdapter);
        }

        return view;
    }
}
