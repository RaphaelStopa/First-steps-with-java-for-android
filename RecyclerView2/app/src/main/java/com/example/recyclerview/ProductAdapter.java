package com.example.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        public  ViewHolder(View itemView){
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(
                R.layout.recycler_view_item,
                parent,
                false
        );
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = DataModel.getInstance().products.get(position);
        holder.textView1.setText(p.getName());
        holder.textView2.setText("" + p.getValue());
        Log.v("ProductAdapter", "Item[" + position + "]:" +p.getName());
    }

    @Override
    public int getItemCount() {
        return DataModel.getInstance().products.size();
    }}

