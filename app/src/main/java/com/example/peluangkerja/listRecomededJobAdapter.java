package com.example.peluangkerja;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listRecomededJobAdapter extends RecyclerView.Adapter<listRecomededJobAdapter.ViewHolder> {

    private ArrayList<Jobs> jobs= new ArrayList<>();
    private Context context;

    public listRecomededJobAdapter(ArrayList<Jobs> jobs, Context context){
        this.jobs = jobs;
        this.context = context;
    };

    public ArrayList<Jobs> getJobList() {
        return jobs;
    };

    @NonNull
    @Override
    public listRecomededJobAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recomended_job, parent, false);
        return new ViewHolder(itemRow);
    }


    @Override
    public void onBindViewHolder(@NonNull listRecomededJobAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(getJobList().get(position).getJobImage());
        holder.tvName.setText(getJobList().get(position).getJob());
        holder.tvCompany.setText(getJobList().get(position).getCompany());
        holder.tvSalary.setText(getJobList().get(position).getSalary());
        holder.tvPlace.setText(getJobList().get(position).getCity());
        holder.tvTime.setText(getJobList().get(position).getTime());
        holder.rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, detailJob.class);
                context.startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return getJobList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView tvName, tvCompany, tvSalary, tvPlace, tvTime;
        LinearLayout rv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgJob);
            tvName = itemView.findViewById(R.id.tvJob);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            tvSalary = itemView.findViewById(R.id.tvPaid);
            tvPlace = itemView.findViewById(R.id.tvCity);
            tvTime = itemView.findViewById(R.id.tvTimePost);
            rv = itemView.findViewById(R.id.lvRecomend);
        }
    }
}
