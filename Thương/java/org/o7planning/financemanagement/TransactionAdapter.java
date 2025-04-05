package org.o7planning.financemanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private List<Transaction> transactionList;

    public TransactionAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_item, parent, false);
        return new TransactionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);
        holder.transactionName.setText(transaction.getName());
        holder.transactionDate.setText(transaction.getDate());
        holder.transactionAmount.setText(String.format("$%.2f", transaction.getAmount()));
        // Bạn có thể thiết lập icon khác nhau dựa trên loại giao dịch nếu cần
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public static class TransactionViewHolder extends RecyclerView.ViewHolder {
        public TextView transactionName;
        public TextView transactionDate;
        public TextView transactionAmount;
        public ImageView transactionIcon;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionName = itemView.findViewById(R.id.transaction_name);
            transactionDate = itemView.findViewById(R.id.transaction_date);
            transactionAmount = itemView.findViewById(R.id.transaction_amount);
            transactionIcon = itemView.findViewById(R.id.transaction_icon);
        }
    }
}