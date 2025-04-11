package due.giuaky221121514224.Day2_Listview_advanced;
import due.giuaky221121514224.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class ContactAdapter extends ArrayAdapter<ContactModel> {
    private IOnChildItemClick listener;
    private int editingPosition = -1;
    private int[] avatarResources;

    public ContactAdapter(Context context, List<ContactModel> contacts, int[] avatarResources) {
        super(context, 0, contacts);
        this.avatarResources = avatarResources;
    }

    public void setListener(IOnChildItemClick listener) {
        this.listener = listener;
    }

    public void setEditingPosition(int position) {
        this.editingPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact_advanced, parent, false);
        }

        ContactModel contact = getItem(position);
        ImageView imageAvatar = convertView.findViewById(R.id.image_avatar);
        TextView textName = convertView.findViewById(R.id.text_name);
        TextView textPhone = convertView.findViewById(R.id.text_phone);
        ImageButton btnEdit = convertView.findViewById(R.id.btn_edit);
        ImageButton btnCall = convertView.findViewById(R.id.btn_call);
        LinearLayout editLayout = convertView.findViewById(R.id.edit_layout);
        EditText editNewName = convertView.findViewById(R.id.edit_new_name);
        EditText editNewPhone = convertView.findViewById(R.id.edit_new_phone);
        Spinner spinnerAvatar = convertView.findViewById(R.id.spinner_avatar);
        Button btnSave = convertView.findViewById(R.id.btn_save);

        imageAvatar.setImageResource(contact.getAvatarResId());
        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());

        if (editingPosition == position) {
            editLayout.setVisibility(View.VISIBLE);
            editNewName.setText(contact.getName());
            editNewPhone.setText(contact.getPhone());

            int avatarIndex = 0;
            for (int i = 0; i < avatarResources.length; i++) {
                if (avatarResources[i] == contact.getAvatarResId()) {
                    avatarIndex = i;
                    break;
                }
            }
            spinnerAvatar.setSelection(avatarIndex);
        } else {
            editLayout.setVisibility(View.GONE);
        }

        btnEdit.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEditClicked(position);
            }
        });

        btnCall.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCallClicked(position);
            }
        });

        btnSave.setOnClickListener(v -> {
            String newName = editNewName.getText().toString().trim();
            String newPhone = editNewPhone.getText().toString().trim();
            int selectedAvatarIndex = spinnerAvatar.getSelectedItemPosition();
            if (!newName.isEmpty() && !newPhone.isEmpty()) {
                contact.setName(newName);
                contact.setPhone(newPhone);
                contact.setAvatarResId(avatarResources[selectedAvatarIndex]);
                editingPosition = -1;
                notifyDataSetChanged();
                if (listener != null) {
                    listener.onEditClicked(position);
                }
            }
        });

        return convertView;
    }
}




