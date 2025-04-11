package due.giuaky221121514224.Day3_Network;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import due.giuaky221121514224.R;
import due.giuaky221121514224.Day3_Network.adapter.HourAdapter;
import due.giuaky221121514224.Day3_Network.model.Weather;
import due.giuaky221121514224.Day3_Network.network.APIManagerWeather;


import java.util.List;
import java.util.Locale;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Day3NetworkWeatherFragment extends Fragment {

    private TextView tvCity, tvStatus, tvTemperature;
    private ImageView imgWeather;
    private RecyclerView rvWeather;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day3_network_weather, container, false);

        tvCity = view.findViewById(R.id.tvLocation);
        tvStatus = view.findViewById(R.id.tvStatus);
        tvTemperature = view.findViewById(R.id.tvTem);
        imgWeather = view.findViewById(R.id.icon);
        rvWeather = view.findViewById(R.id.rvHour);

        rvWeather.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        loadWeatherData();

        return view;
    }

    private void loadWeatherData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dataservice.accuweather.com/") // Đổi nếu bạn dùng base URL khác
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManagerWeather api = retrofit.create(APIManagerWeather.class);
        api.getHour().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Weather> list = response.body();
                    Weather current = list.get(0);

                    tvCity.setText("Hà Nội");
                    tvStatus.setText(current.getIconPhrase());
                    tvTemperature.setText((int) current.getTemperature().getValue() + "°");

                    String iconCode = String.format(Locale.getDefault(), "%02d", current.getWeatherIcon());
                    String iconUrl = "https://developer.accuweather.com/sites/default/files/" + iconCode + "-s.png";
                    Glide.with(requireContext()).load(iconUrl).into(imgWeather);

                    rvWeather.setAdapter(new HourAdapter(list));
                } else {
                    tvStatus.setText("Không có dữ liệu");
                }
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                tvStatus.setText("Lỗi kết nối");
            }
        });
    }
}
