package com.trollologic.pocketgithub.search;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.trollologic.pocketgithub.R;
import com.trollologic.pocketgithub.databinding.ActivitySearchBinding;
import com.trollologic.pocketgithub.utils.Constants;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, com.trollologic.pocketgithub.search.SearchView {

    private static final String TAG = SearchActivity.class.getSimpleName();
    private ActivitySearchBinding binding;
    private SearchPresenter presenter;
    private String sort = Constants.SORT_BY_UPDATED;
    private String order = Constants.ORDER_ASC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        renderView();
    }

    private void renderView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        presenter = new SearchPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        presenter.search(query, sort, order);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showFailureMessage(String message) {

    }

    @Override
    public Context getContext() {
        return this;
    }
}