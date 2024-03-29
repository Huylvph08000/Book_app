package com.example.myapplication.Grammar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {
    private Context mcontext;
    private ArrayList<String> titleList;
    private CustomItemClickListener clickListener;


    public TitleAdapter(Context mcontext, ArrayList<String> titleList, CustomItemClickListener clickListener) {
        this.mcontext = mcontext;
        this.titleList = titleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         final View view = LayoutInflater.from(mcontext).inflate(R.layout.title_layout, parent, false);
         final MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(view, viewHolder.getPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.titleText.setText(titleList.get(position).replace("_", " "));
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView titleText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText =(TextView) itemView.findViewById(R.id.title_text);

        }
    }
}
