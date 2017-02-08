package com.example.android.popularmoviess1.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skalda on 07/02/2017.
 */

public class JsonParser {

    public static List<MovieEntity> parseJson(String json) {
        List<MovieEntity> movieEntities = new ArrayList<MovieEntity>();
        try {
            JSONObject object = new JSONObject(json);
            JSONArray results = object.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject result = results.getJSONObject(i);
                movieEntities.add(new MovieEntity(
                        result.getInt("id"),
                        result.getString("original_title"),
                        MovieDatabase.buildImageUrl(result.getString("poster_path")),
                        result.getString("overview"),
                        result.getDouble("vote_average"),
                        result.getString("release_date")
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movieEntities;
    }
}
