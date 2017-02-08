package com.example.android.popularmoviess1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.android.popularmoviess1.Helpers.IntentItems;
import com.example.android.popularmoviess1.Utilities.MovieEntity;
import com.squareup.picasso.Picasso;


public class MovieDetailActivity extends AppCompatActivity {

    private TextView mMovieTitleTextView;
    private TextView mMovieRatingTextView;
    private TextView mMovieReleaseDateTextView;
    private TextView mMovieSynopsisTextView;
    private ImageView mMoviePosterImageView;
    private TextView mDetailErrorTextView;
    private ScrollView mDetailScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mMovieTitleTextView = (TextView) findViewById(R.id.tv_movie_title);
        mMovieRatingTextView = (TextView) findViewById(R.id.tv_movie_rating);
        mMovieReleaseDateTextView = (TextView) findViewById(R.id.tv_movie_releaseDate);
        mMovieSynopsisTextView = (TextView) findViewById(R.id.tv_movie_synopsis);
        mMoviePosterImageView = (ImageView) findViewById(R.id.iv_movie_poster);
        mDetailErrorTextView = (TextView) findViewById(R.id.tv_detail_error);
        mDetailScrollView = (ScrollView) findViewById(R.id.sv_movie_detail);

        Intent intentThatStartedThisActivity = getIntent();

        if(intentThatStartedThisActivity.hasExtra(IntentItems.MOVIE_ENTITY)) {
            MovieEntity movieEntity = intentThatStartedThisActivity.getParcelableExtra(IntentItems.MOVIE_ENTITY);

            if(movieEntity != null) {
                showResults();
                mMovieTitleTextView.setText(movieEntity.getOriginalTitle());
                mMovieRatingTextView.setText(getString(R.string.average_rating) + movieEntity.getUserRating().toString());
                mMovieReleaseDateTextView.setText(getString(R.string.release_date) + movieEntity.getReleaseDate());
                mMovieSynopsisTextView.setText(movieEntity.getSynopsis());
                Picasso.with(this).load(movieEntity.getBackdropImage()).into(mMoviePosterImageView);
            } else {
                showErrors();
            }

        } else {
            showErrors();
        }
    }

    private void showErrors() {
        mDetailErrorTextView.setVisibility(View.VISIBLE);
        mDetailScrollView.setVisibility(View.INVISIBLE);
    }

    private void showResults() {
        mDetailErrorTextView.setVisibility(View.INVISIBLE);
        mDetailScrollView.setVisibility(View.VISIBLE);
    }

}
