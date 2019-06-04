package com.example.emanuel.appserviciosautos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.emanuel.appserviciosautos.models.QueryModel;
import com.example.emanuel.appserviciosautos.utils.QueryAdapter;
import com.example.emanuel.appserviciosautos.utils.QueryItem;

import java.util.LinkedList;

public class QueryActivityRV extends AppCompatActivity {

    private LinkedList<QueryItem> query;
    private RecyclerView rvQuery;
    private QueryModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_rv);

        Intent intent = getIntent();
        int querryType = intent.getIntExtra("type",0);
        if(querryType == 0)
            query = model.revenueByCity();
        if(querryType == 1)
            query = model.servicesYearCityTrademark();
        if(querryType == 2)
            query = model.personsWithoutService();

        QueryAdapter adapter = new QueryAdapter(query);
        rvQuery.setAdapter(adapter);
    }
}
