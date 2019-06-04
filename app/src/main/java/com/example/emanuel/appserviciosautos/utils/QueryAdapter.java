package com.example.emanuel.appserviciosautos.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emanuel.appserviciosautos.R;

import java.util.LinkedList;

public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.QueryItemHolder> {

    LinkedList<QueryItem> list;

    public QueryAdapter(LinkedList<QueryItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public QueryItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.query_item,null,false);
        return new QueryItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QueryItemHolder holder, int position) {
        holder.fields[0].setText(list.get(position).getFields(0));
        holder.fields[1].setText(list.get(position).getFields(1));
        holder.fields[2].setText(list.get(position).getFields(2));
        holder.fields[3].setText(list.get(position).getFields(3));
        holder.setImage(list.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class QueryItemHolder extends RecyclerView.ViewHolder {

        TextView[] fields;
        ImageView imgItem;

        public QueryItemHolder(View itemView) {
            super(itemView);
            fields = new TextView[4];
            fields[0] = itemView.findViewById(R.id.lblField1);
            fields[1] = itemView.findViewById(R.id.lblField2);
            fields[2] = itemView.findViewById(R.id.lblField3);
            fields[3] = itemView.findViewById(R.id.lblField4);
            imgItem = itemView.findViewById(R.id.imgItem);

        }

        public void setImage(int imageIndex){
            if(imageIndex == 0){
                imgItem.setImageResource(R.drawable.user_burned);
                return;
            }
            if(imageIndex == 1){
                imgItem.setImageResource(R.drawable.car_icon);
                return;
            }
            if(imageIndex == 2){
                imgItem.setImageResource(R.drawable.services_icon);
                return;
            }

        }
    }
}

