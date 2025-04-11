package due.giuaky221121514224.Day3_Network.network;
import due.giuaky221121514224.Day3_Network.model.DailyForecastResponse;

import java.util.List;

import due.giuaky221121514224.Day3_Network.model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIManagerWeather {
    public static String BASE_URL = "https://dataservice.accuweather.com";
    @GET("/forecasts/v1/hourly/12hour/353412?apikey=tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh&language=vi-vn&metric=true")
    Call<List<Weather>> getHour();

}
