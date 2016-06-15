package com.crprojects.mymovie.fragments;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crprojects.mymovie.R;
import com.crprojects.mymovie.omdbfiles.SearchService;

/**
 * Created by Pc on 15-Jun-16.
 */

public class ImdbDetails extends Fragment {

    public ImdbDetails() {
        // Required empty public constructor
    }


    public static final String MOVIE_DETAIL = "movie_detail";
    public static final String IMAGE_URL = "image_url";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_imdb_details, container, false);


        final SearchService.Detail detail = getActivity().getIntent().getParcelableExtra(MOVIE_DETAIL);
        final String imageUrl =  getActivity().getIntent().getStringExtra(IMAGE_URL);
        Glide.with(this).load(imageUrl).into( (ImageView) rootView.findViewById(R.id.main_backdrop));

        // set title for the appbar
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.main_collapsing);
        collapsingToolbarLayout.setTitle(detail.Title);

        ((TextView) rootView.findViewById(R.id.grid_title)).setText(detail.Title);
        ((TextView) rootView.findViewById(R.id.grid_writers)).setText(detail.Writer);
        ((TextView) rootView.findViewById(R.id.grid_actors)).setText(detail.Actors);
        ((TextView) rootView.findViewById(R.id.grid_director)).setText(detail.Director);
        ((TextView) rootView.findViewById(R.id.grid_genre)).setText(detail.Genre);
        ((TextView) rootView.findViewById(R.id.grid_released)).setText(detail.Released);
        ((TextView) rootView.findViewById(R.id.grid_plot)).setText(detail.Plot);
        ((TextView) rootView.findViewById(R.id.grid_runtime)).setText(detail.Runtime);
        // Inflate the layout for this fragment
        return rootView;
    }


}
