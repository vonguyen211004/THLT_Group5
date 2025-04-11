package due.giuaky221121514224.Day3_Network;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import due.giuaky221121514224.databinding.FragmentDay3NetworkRecyclerviewBinding;
import due.giuaky221121514224.Day3_Network.adapter.NewsAdapter;
import due.giuaky221121514224.Day3_Network.model.Item;
import due.giuaky221121514224.Day3_Network.network.APIManagerMovies;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Day3NetworkRecyclerviewFragment extends Fragment {
    private FragmentDay3NetworkRecyclerviewBinding binding;

    private RecyclerView rvListNews;
    private List<Item> listData;
    private NewsAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDay3NetworkRecyclerviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //B1: Data source
        getListData();

        //B2: Adapter
        listData = new ArrayList<>();
        adapter = new NewsAdapter(requireActivity(), listData);

        //B3: Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);

        //B4: RecyclerView
        rvListNews = binding.rvListNews;
        rvListNews.setLayoutManager(layoutManager);
        rvListNews.setAdapter(adapter);

        return root;
    }

    private void getListData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManagerMovies.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManagerMovies service = retrofit.create(APIManagerMovies.class);
        service.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.body() != null) {
                    listData = response.body();
                    adapter.reLoadData(listData);
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(requireActivity(), "Fail", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
