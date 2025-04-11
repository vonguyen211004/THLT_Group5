package due.giuaky221121514224.Day2_Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import due.giuaky221121514224.R;

public class ProfileActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);

        TextView textUsername = view.findViewById(R.id.tvUsername);
        Button btnEdit = view.findViewById(R.id.btnEdit);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("username")) {
            String username = bundle.getString("username");
            textUsername.setText(username);
        } else {
            textUsername.setText("Không có username");
        }

        btnEdit.setOnClickListener(v -> {
            Bundle editBundle = new Bundle();
            editBundle.putString("username", textUsername.getText().toString());

            // Chuyển sang EditUserFragment
            Navigation.findNavController(view).navigate(
                    R.id.action_profileFragment_to_editUserFragment,
                    editBundle
            );
        });



        return view;
    }
}