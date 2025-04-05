package org.o7planning.financemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SavingsAdapter extends BaseAdapter {

    private Context context;
    private String[] savingsItems;

    public SavingsAdapter(Context context, String[] savingsItems) {
        this.context = context;
        this.savingsItems = savingsItems;
    }

    @Override
    public int getCount() {
        return savingsItems.length;
    }

    @Override
    public Object getItem(int position) {
        return savingsItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.savings_grid_item_layout, parent, false);
        }

        TextView savingsItemText = convertView.findViewById(R.id.savings_item_text);
        savingsItemText.setText(savingsItems[position]);

        return convertView;
    }
}