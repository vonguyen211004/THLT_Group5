package due.giuaky221121514224.Day2_Listview_advanced;
import due.giuaky221121514224.R;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import due.giuaky221121514224.R;
import due.giuaky221121514224.databinding.FragmentDay2ListviewAdvancedBinding;
import java.util.ArrayList;
import java.util.List;

public class Day2ListViewAdvancedFragment extends Fragment implements IOnChildItemClick {
    private FragmentDay2ListviewAdvancedBinding binding;
    private List<ContactModel> listContact = new ArrayList<>();
    private ContactAdapter mAdapter;
    private int[] avatarResources;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDay2ListviewAdvancedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initData();
        initView();

        mAdapter = new ContactAdapter(requireContext(), listContact, avatarResources);
        mAdapter.setListener(this);
        binding.listContacts.setAdapter(mAdapter);

        binding.listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(requireContext(), model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void initView() {
    }

    private void initData() {
        avatarResources = new int[] {
                R.drawable.avatar_default,
                R.drawable.avatar_male,
                R.drawable.avatar_green,
                R.drawable.avatar_skype,
                R.drawable.avatar_male
        };

        // Khởi tạo danh sách liên hệ
        listContact.add(new ContactModel("Trần Trường Sơn", "0357169617", R.drawable.avatar_default));
        listContact.add(new ContactModel("Trần Thị Binh", "0357369617", R.drawable.avatar_male));
        listContact.add(new ContactModel("Hồ Văn Dũng", "0327169617", R.drawable.avatar_green));
        listContact.add(new ContactModel("Trần Trường Sơn", "0357169617", R.drawable.avatar_default));
        listContact.add(new ContactModel("Trần Thị Binh", "0357369617", R.drawable.avatar_male));


    }

    @Override
    public void onCallClicked(int position) {
        ContactModel contact = listContact.get(position);
        String phone = contact.getPhone();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
        startActivity(intent);
    }

    @Override
    public void onEditClicked(int position) {
        ContactModel contact = listContact.get(position);
        binding.tvName.setText(contact.getName());
        binding.ivUser.setImageResource(contact.getAvatarResId());
        mAdapter.setEditingPosition(position);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
