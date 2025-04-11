package due.giuaky221121514224.Day2_Listview;
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

public class Day2ListViewFragment extends Fragment {

    private ListView listView;
    private ContactAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day2_listview, container, false);

        listView = view.findViewById(R.id.lv_contacts);

        List<ContactModel> contacts = new ArrayList<>();
        contacts.add(new ContactModel("Trần Trường Sơn", "0988111222", R.drawable.avatar_male));
        contacts.add(new ContactModel("Trần Thị Bình", "0988111333", R.drawable.avatar_skype));
        contacts.add(new ContactModel("Hồ Văn Dũng", "0988111555", R.drawable.avatar_default));
        contacts.add(new ContactModel("Đào Thị Mơ", "0988222333", R.drawable.avatar_green));
        contacts.add(new ContactModel("Ngô Thị Mận", "0988555222", R.drawable.avatar_skype));
        contacts.add(new ContactModel("Trần Trường Sơn", "0988111222", R.drawable.avatar_male));
        contacts.add(new ContactModel("Trần Thị Bình", "0988111333", R.drawable.avatar_skype));
        contacts.add(new ContactModel("Hồ Văn Dũng", "0988111555", R.drawable.avatar_default));
        contacts.add(new ContactModel("Đào Thị Mơ", "0988222333", R.drawable.avatar_green));
        contacts.add(new ContactModel("Ngô Thị Mận", "0988555222", R.drawable.avatar_skype));

        adapter = new ContactAdapter(getContext(), contacts);
        listView.setAdapter(adapter);

        return view;
    }
}


