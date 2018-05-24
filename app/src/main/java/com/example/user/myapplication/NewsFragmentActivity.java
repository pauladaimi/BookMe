package com.example.user.myapplication;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragmentActivity extends AppCompatActivity {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private List<Space> newsItems;
    private LinearLayoutManager linearLayoutManager;
    private BookService bookService;
    private SwipeRefreshLayout sRLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_fragment);
        RetrofitClient.initRetrofit(this);
        bookService = ApiUtils.getBookService();
        newsItems = new ArrayList<>();
        setupViews();
        loadNews();
    }



    private void setupViews() {

        sRLayout = findViewById(R.id.swipe_refresh_layout);
        sRLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        loadNews();
                    }
                }
        );
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        newsAdapter = new NewsAdapter(newsItems, this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                recyclerView.getContext(),
                linearLayoutManager.getOrientation()
        );
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void loadNews() {
        sRLayout.setRefreshing(false);
        bookService.getSpaces().enqueue(new Callback<List<Space>>() {
            @Override
            public void onResponse(Call<List<Space>> call, Response<List<Space>> response) {
                // Log.w("loadNEWS",));
                if(response.isSuccessful()) {
                    newsAdapter.updateNews(response.body());
                    Log.w("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    Log.w("MainActivity",Integer.toString(response.code()));
                }
            }
            @Override
            public void onFailure(Call<List<Space>> call, Throwable t) {
                Log.w("MainActivity", t.toString());

            }
        });
    }
}
