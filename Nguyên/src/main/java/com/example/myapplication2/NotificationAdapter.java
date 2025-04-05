package com.example.myapplication2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<Object> notificationList;

    public NotificationAdapter(List<Object> notificationList) {
        this.notificationList = notificationList;
    }

    @Override
    public int getItemViewType(int position) {
        if (notificationList.get(position) instanceof NotificationHeader) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            NotificationHeader header = (NotificationHeader) notificationList.get(position);
            ((HeaderViewHolder) holder).headerTitle.setText(header.getTitle());
        } else {
            NotificationItem item = (NotificationItem) notificationList.get(position);
            ((ItemViewHolder) holder).title.setText(item.getTitle());
            ((ItemViewHolder) holder).message.setText(item.getMessage());
            ((ItemViewHolder) holder).time.setText(item.getTime());
        }
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitle;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTitle = itemView.findViewById(R.id.notificationHeader);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title, message, time;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.notificationTitle);
            message = itemView.findViewById(R.id.notificationMessage);
            time = itemView.findViewById(R.id.notificationTime);
        }
    }
}
