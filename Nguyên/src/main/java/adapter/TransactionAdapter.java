package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.HomeActivity.Transaction;
import com.example.myapplication2.R;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private final List<Transaction> transactions;

    public TransactionAdapter(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);

        holder.tvTransactionTitle.setText(transaction.getTitle());
        holder.tvTransactionTime.setText(transaction.getTime());

        // Format amount with + or - sign
        String amountText = transaction.isIncome() ?
                "+" + String.format("$%.2f", transaction.getAmount()) :
                "-" + String.format("$%.2f", transaction.getAmount());
        holder.tvAmount.setText(amountText);

        // Set color based on income or expense
        holder.tvAmount.setTextColor(holder.itemView.getContext().getResources().getColor(
                transaction.isIncome() ? R.color.colorGreen : R.color.colorRed));

        // Set icon background color based on transaction type
        if (transaction.getTitle().equals("Salary")) {
            holder.cardIcon.setCardBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorBlue));
        } else if (transaction.getTitle().equals("Groceries")) {
            holder.cardIcon.setCardBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorPurple));
        } else {
            holder.cardIcon.setCardBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.colorRed));
        }
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardIcon;
        ImageView ivTransactionIcon;
        TextView tvTransactionTitle;
        TextView tvTransactionTime;
        TextView tvAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardIcon = itemView.findViewById(R.id.cardIcon);
            ivTransactionIcon = itemView.findViewById(R.id.ivTransactionIcon);
            tvTransactionTitle = itemView.findViewById(R.id.tvTransactionTitle);
            tvTransactionTime = itemView.findViewById(R.id.tvTransactionTime);
            tvAmount = itemView.findViewById(R.id.tvAmount);
        }
    }
}