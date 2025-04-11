package due.giuaky221121514224.Day2_Listview;
import due.giuaky221121514224.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import due.giuaky221121514224.R;

public class ContactAdapter extends ArrayAdapter<ContactModel> {

    public ContactAdapter(Context context, List<ContactModel> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactModel contact = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.tv_contact_name);
        TextView tvPhone = convertView.findViewById(R.id.tv_phone_number);
        ImageView ivContact = convertView.findViewById(R.id.iv_contact);

        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhoneNumber());
        ivContact.setImageResource(contact.getImageResId());

        return convertView;
    }
}