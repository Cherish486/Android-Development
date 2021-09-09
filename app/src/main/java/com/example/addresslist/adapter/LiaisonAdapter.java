package com.example.addresslist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addresslist.R;

import java.util.List;

import com.example.addresslist.entity.Liaison;

public class LiaisonAdapter extends RecyclerView.Adapter<LiaisonAdapter.ViewHolder>{
    private List<Liaison> liaisons;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView name;
        TextView phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            name = itemView.findViewById(R.id.liaison_name);
            phone = itemView.findViewById(R.id.liaison_phone);
        }
    }

    public LiaisonAdapter(List<Liaison> liaisons) {
        this.liaisons = liaisons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.liaison, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.view.setOnClickListener(view1 -> {
            int position = holder.getAdapterPosition();
            Liaison liaison = liaisons.get(position);
            Toast.makeText(view1.getContext(), "you clicked view " +
                    liaison.getName(),Toast.LENGTH_SHORT).show();
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Liaison liaison = liaisons.get(position);
        holder.name.setText(liaison.getName());
        holder.phone.setText(liaison.getPhone());
    }

    @Override
    public int getItemCount() {
        return liaisons.size();
    }
}
