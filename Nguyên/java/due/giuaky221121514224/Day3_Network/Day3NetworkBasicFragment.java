package due.giuaky221121514224.Day3_Network;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.List;

import due.giuaky221121514224.R;
import due.giuaky221121514224.Day3_Network.model.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.List;

import due.giuaky221121514224.databinding.FragmentDay3NetworkBasicBinding;
import due.giuaky221121514224.Day3_Network.network.APIManagerMovies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Day3NetworkBasicFragment extends Fragment {
    private FragmentDay3NetworkBasicBinding binding;
    private TextView tvDate, tvTitle, tvContent;
    private ImageView ivCover;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDay3NetworkBasicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initView();
        getData();

        return root;
    }

    private void initView() {
        tvTitle = binding.tvTitle;
        tvContent = binding.tvContent;
        tvDate = binding.tvDate;
        ivCover = binding.ivCover;
    }

    private void getData() {
        APIManagerMovies.apiService.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.body() == null) {
                    Toast.makeText(getContext(), "Không có dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Item> models = response.body();
                if (models.size() > 0) {
                    Item model = models.get(0);

                    tvTitle.setText(model.getTitle());
                    tvDate.setText(model.getDate());
                    tvContent.setText(model.getDescription());

                    Glide.with(Day3NetworkBasicFragment.this)
                            .load(model.getImage())
                            .into(ivCover);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.e("BasicFragment", "onFailure: " + t.getMessage());
                Toast.makeText(getContext(), "Lỗi: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}