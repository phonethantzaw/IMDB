package com.kophone.rapidapi.IMDB.Service;

import com.google.gson.Gson;
import com.kophone.rapidapi.IMDB.Model.IMDBDetail;
import com.kophone.rapidapi.IMDB.Model.IMDBSearch;
import com.kophone.rapidapi.IMDB.Model.Search;
import com.kophone.rapidapi.IMDB.Model.TitleParam;
import com.kophone.rapidapi.IMDB.Utils.Constant;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author ko phone
 */
@Service
public class SearchRepository {

    private Gson gson = new Gson();

    public List<Search> getIMDBSearch(TitleParam mRequest) throws IOException {

        String query = String.format("s=%s", URLEncoder.encode(mRequest.getmTitle(), Constant.CHARSET));
        IMDBSearch search = gson.fromJson(jsonResponse(query), IMDBSearch.class);
        return search.getSearch();
    }

    public IMDBDetail getIMDBDetail(TitleParam mRequest) throws IOException {

        String query = "i=" + mRequest.getmTitle() + "&r=json";
        return gson.fromJson(jsonResponse(query), IMDBDetail.class);

    }

    private String jsonResponse(String query) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(Constant.HOST + "?" + query)
                .addHeader("x-rapidapi-host", Constant.x_rapidapi_host)
                .addHeader("x-rapidapi-key", Constant.x_rapidapi_key)
                .build();

        return client.newCall(request).execute().body().string();
    }

}
