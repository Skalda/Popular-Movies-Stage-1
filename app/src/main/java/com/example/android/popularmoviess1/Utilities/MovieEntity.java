package com.example.android.popularmoviess1.Utilities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by skalda on 07/02/2017.
 */

public class MovieEntity implements Parcelable {

    private Integer id;
    private String originalTitle;
    private String moviePoster;
    private String synopsis;
    private Double userRating;
    private String releaseDate;

    public MovieEntity(
            Integer id,
            String originalTitle,
            String moviePoster,
            String synopsis,
            Double userRating,
            String releaseDate
    ) {
        this.id = id;
        this.originalTitle = originalTitle;
        this.moviePoster = moviePoster;
        this.synopsis = synopsis;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
    }

    private  MovieEntity(Parcel in) {
        this.id = in.readInt();
        this.originalTitle = in.readString();
        this.moviePoster = in.readString();
        this.synopsis = in.readString();
        this.userRating = in.readDouble();
        this.releaseDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(originalTitle);
        dest.writeString(moviePoster);
        dest.writeString(synopsis);
        dest.writeDouble(userRating);
        dest.writeString(releaseDate);
    }

    static final Parcelable.Creator<MovieEntity> CREATOR = new Parcelable.Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel source) {
            return new MovieEntity(source);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Double getUserRating() {
        return userRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
