package com.example.task5_1;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsAdapter.OnNewsListener {

    private RecyclerView rvTopStories;
    private RecyclerView rvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTopStories = findViewById(R.id.rvTopStories);
        rvNews = findViewById(R.id.rvNews);

        // Initialize the RecyclerView for top stories
        LinearLayoutManager layoutManagerTopStories = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvTopStories.setLayoutManager(layoutManagerTopStories);
        NewsAdapter topStoriesAdapter = new NewsAdapter(this, getDummyNews(), this); // Assuming you have a getDummyNews() method to generate list of news
        rvTopStories.setAdapter(topStoriesAdapter);

        // Initialize the RecyclerView for news with multiple rows
        GridLayoutManager layoutManagerNews = new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false);
        rvNews.setLayoutManager(layoutManagerNews);
        NewsAdapter newsAdapter = new NewsAdapter(this, getDummyNews(), this);
        rvNews.setAdapter(newsAdapter);
    }

    // Method to open NewsFragment with the details of the clicked news
    @Override
    public void onNewsClick(News news) {
        // Make the fragment container visible
        findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);

        // Create a new instance of the NewsFragment with the clicked news item
        NewsFragment newsFragment = NewsFragment.newInstance(news);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newsFragment)
                .addToBackStack(null)
                .commit();
    }

    // Dummy method to generate a list of news
    private List<News> getDummyNews() {
        List<News> newsList = new ArrayList<>();

        // Here we create 10 dummy news items
        for (int i = 1; i <= 15; i++) {
            String title = "News Title " + i;
            String description = "This is the description for news item " + i + ". It contains interesting information about the topic.";
            String imageUrl = "@drawable/ic_placeholder_image"; // Placeholder image URL

            // Creating a list of related news (for simplicity, using the same list for all)
            List<News> relatedNews = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                relatedNews.add(new News("Related News Title " + j, "Description for related news " + j, imageUrl, new ArrayList<>()));
            }

            newsList.add(new News(title, description, imageUrl, relatedNews));
        }

        return newsList;
    }
}