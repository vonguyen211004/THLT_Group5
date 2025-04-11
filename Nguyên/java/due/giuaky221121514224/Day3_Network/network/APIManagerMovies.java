package due.giuaky221121514224.Day3_Network.network;
import due.giuaky221121514224.Day3_Network.model.Weather;

import java.util.List;

import due.giuaky221121514224.Day3_Network.model.Item;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIManagerMovies {
    String SERVER_URL = "https://imdb-top-250.p.rapidapi.com/api/imdb-top-250/";

    APIManagerMovies apiService = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIManagerMovies.class);
    @Headers({
            "x-rapidapi-host: imdb-top-250.p.rapidapi.com",
            "x-rapidapi-key: 79bc360043msha95ad79a8027b47p131ffajsn2152355af301"
    })


    @GET("/imdb/top250-movies")
    Call<List<Item>> getListData();
}
