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

public class LoginActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);

        EditText editUsername = view.findViewById(R.id.edit_username);
        EditText editPassword = view.findViewById(R.id.edit_password);
        Button btnLogin = view.findViewById(R.id.login_button);

        btnLogin.setOnClickListener(v -> {
            String username = editUsername.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putString("username", username);

                Navigation.findNavController(view).navigate(
                        R.id.action_loginFragment_to_profileFragment,
                        bundle
                );
            } else {
                Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

