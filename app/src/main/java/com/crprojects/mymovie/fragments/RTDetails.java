package com.crprojects.mymovie.fragments;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.crprojects.mymovie.R;
import com.crprojects.mymovie.omdbfiles.SearchService;

import static com.crprojects.mymovie.activity.DetailActivity.IMAGE_URL;
import static com.crprojects.mymovie.activity.DetailActivity.MOVIE_DETAIL;

/**
 * Created by Pc on 15-Jun-16.
 */

public class RTDetails extends Fragment {

    public RTDetails() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_r_t_details, container, false);


        final SearchService.Detail detail = getActivity().getIntent().getParcelableExtra(MOVIE_DETAIL);
        final String imageUrl =  getActivity().getIntent().getStringExtra(IMAGE_URL);
        Glide.with(this).load(imageUrl).into( (ImageView) rootView.findViewById(R.id.main_backdrop));

        // set title for the appbar
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.main_collapsing);
        collapsingToolbarLayout.setTitle(detail.Title);
        if (!detail.tomatoMeter.equals("N/A")) {
            int tmeter = Integer.parseInt(detail.tomatoMeter);
            if (tmeter < 60) {
                String imageUrl1 = "http://www.directv.com/cms2/technology/receivers/as/rt_lg_02.png";
                Glide.with(this).load(imageUrl1).into((ImageView) rootView.findViewById(R.id.img1));
                ((ProgressBar) rootView.findViewById(R.id.pbar1)).setProgress(tmeter);
                ((ProgressBar) rootView.findViewById(R.id.pbar2)).setVisibility(View.INVISIBLE);
            } else if (tmeter < 75) {
                String imageUrl1 = "http://planetmoviereviews.com/wp-content/uploads/2015/08/rotten-tomatoes.png";
                Glide.with(this).load(imageUrl1).into((ImageView) rootView.findViewById(R.id.img1));
                ((ProgressBar) rootView.findViewById(R.id.pbar2)).setProgress(tmeter);

            } else if (tmeter > 74) {
                String imageUrl1 = "https://d2a5cgar23scu2.cloudfront.net/static/images/icons/cf-lg.png";
                Glide.with(this).load(imageUrl1).into((ImageView) rootView.findViewById(R.id.img1));
                ((ProgressBar) rootView.findViewById(R.id.pbar2)).setProgress(tmeter);

            }
        }

        else {
            String imageUrl1 = "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/blue-jelly-icons-alphanumeric/069596-blue-jelly-icon-alphanumeric-plus-sign-simple.png";
            Glide.with(this).load(imageUrl1).into((ImageView) rootView.findViewById(R.id.img1));
            ((ProgressBar) rootView.findViewById(R.id.pbar1)).setProgress(0);
            ((ProgressBar) rootView.findViewById(R.id.pbar2)).setVisibility(View.INVISIBLE);
        }


        String tmtr = detail.tomatoMeter+"%";
        ((TextView) rootView.findViewById(R.id.grid_tmeter)).setText(tmtr);
        String tmtrat = "Tomato Rating: "+detail.tomatoRating+"/10";
        ((TextView) rootView.findViewById(R.id.grid_tmtrating)).setText(tmtrat);

        if (!detail.tomatoUserMeter.equals("N/A")) {
            int tumeter = Integer.parseInt(detail.tomatoUserMeter);
            if (tumeter < 60) {
                String imageUrl2 = "http://www.directv.com/cms2/technology/receivers/as/rt_lg_06.png";
                Glide.with(this).load(imageUrl2).into((ImageView) rootView.findViewById(R.id.img2));
                ((ProgressBar) rootView.findViewById(R.id.pbar3)).setProgress(tumeter);
                ((ProgressBar) rootView.findViewById(R.id.pbar4)).setVisibility(View.INVISIBLE);
            } else if (tumeter < 75) {
                String imageUrl2 = "http://www.directv.com/cms2/technology/receivers/as/rt_lg_04.png";
                Glide.with(this).load(imageUrl2).into((ImageView) rootView.findViewById(R.id.img2));
                ((ProgressBar) rootView.findViewById(R.id.pbar4)).setProgress(tumeter);

            } else if (tumeter > 74) {
                String imageUrl2 = "http://www.directv.com/cms2/technology/receivers/as/rt_lg_04.png";
                Glide.with(this).load(imageUrl2).into((ImageView) rootView.findViewById(R.id.img2));
                ((ProgressBar) rootView.findViewById(R.id.pbar4)).setProgress(tumeter);

            }
        }

        else {
            String imageUrl2 = "http://cdn.mysitemyway.com/etc-mysitemyway/icons/legacy-previews/icons/blue-jelly-icons-alphanumeric/069596-blue-jelly-icon-alphanumeric-plus-sign-simple.png";
            Glide.with(this).load(imageUrl2).into((ImageView) rootView.findViewById(R.id.img1));
            ((ProgressBar) rootView.findViewById(R.id.pbar3)).setProgress(0);
            ((ProgressBar) rootView.findViewById(R.id.pbar4)).setVisibility(View.INVISIBLE);
        }

        String tmtur = detail.tomatoUserMeter+"%";
        ((TextView) rootView.findViewById(R.id.grid_tumeter)).setText(tmtur);
        String tmturat = "Average Rating: "+detail.tomatoUserRating+"/5";
        ((TextView) rootView.findViewById(R.id.grid_tmturating)).setText(tmturat);

        ((TextView) rootView.findViewById(R.id.grid_turl)).setText(detail.tomatoURL);
        ((TextView) rootView.findViewById(R.id.grid_boxoffice)).setText(detail.BoxOffice);
        ((TextView) rootView.findViewById(R.id.grid_dvd)).setText(detail.DVD);
        ((TextView) rootView.findViewById(R.id.grid_website)).setText(detail.Website);
        ((TextView) rootView.findViewById(R.id.grid_production)).setText(detail.Production);
        ((TextView) rootView.findViewById(R.id.grid_tconsensus)).setText(detail.tomatoConsensus);


        return rootView;
    }


}
