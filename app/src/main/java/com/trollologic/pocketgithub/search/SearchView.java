package com.trollologic.pocketgithub.search;

import android.app.FragmentManager;

import com.trollologic.pocketgithub.base.BaseView;
import com.trollologic.pocketgithub.models.responses.GithubUser;
import com.trollologic.pocketgithub.models.responses.SearchResults;

/**
 * Created by miroslav on 02.02.17..
 */

public interface SearchView extends BaseView {

    void updateResultList(SearchResults items);

    ResultAdapter getAdapter();

    void updateUserInfo(GithubUser user);

    FragmentManager getFragmentManager();

}
