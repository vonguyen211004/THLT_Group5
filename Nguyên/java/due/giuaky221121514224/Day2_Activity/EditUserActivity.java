package due.giuaky221121514224.Day2_Activity;
import due.giuaky221121514224.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import due.giuaky221121514224.R;

public class EditUserActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_edit_user, container, false);

        EditText editNewUsername = view.findViewById(R.id.username_edit_text);
        Button btnDone = view.findViewById(R.id.btnDone);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("username")) {
            String username = bundle.getString("username");
            editNewUsername.setText(username);
        }

        btnDone.setOnClickListener(v -> {
            String newUsername = editNewUsername.getText().toString().trim();
            if (!newUsername.isEmpty()) {
                Bundle newBundle = new Bundle();
                newBundle.putString("username", newUsername);

                Navigation.findNavController(view).navigate(
                        R.id.action_editUserFragment_to_profileFragment,
                        newBundle
                );
            } else {
                Toast.makeText(getContext(), "Username không được để trống", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

