package org.o7planning.financemanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private String[] categories;

    public CategoryAdapter(Context context, String[] categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public Object getItem(int position) {
        return categories[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);
        }

        TextView categoryText = convertView.findViewById(R.id.grid_item_text);
        categoryText.setText(categories[position]);

        return convertView;
    }

    public void setOnItemClickListener(final AdapterView.OnItemClickListener listener) {
        // Thêm onItemClickListener vào Adapter
        // Điều này cho phép MainActivity nhận được sự kiện click
        // và xử lý việc khởi động NewCategoryActivity
    }
}