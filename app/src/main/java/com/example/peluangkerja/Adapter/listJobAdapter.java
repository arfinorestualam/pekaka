package com.example.peluangkerja.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.peluangkerja.Jobs;
import com.example.peluangkerja.R;
import com.example.peluangkerja.detailJob;

import java.util.ArrayList;

public class listJobAdapter extends RecyclerView.Adapter<listJobAdapter.ViewHolder> {

    private ArrayList<Jobs> jobs= new ArrayList<>();
    private Context context;

    public listJobAdapter(ArrayList<Jobs> jobs, Context context){
        this.jobs = jobs;
        this.context = context;
    };

    public ArrayList<Jobs> getJobList() {
      return jobs;
    };

    @NonNull
    @Override
    public listJobAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_job, parent, false);
        return new ViewHolder(itemRow);
    }


    @Override
    public void onBindViewHolder(@NonNull listJobAdapter.ViewHolder holder, int position) {
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
        RelativeLayout rv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvCompany = itemView.findViewById(R.id.tv_item_place);
            tvSalary = itemView.findViewById(R.id.tv_price);
            tvPlace = itemView.findViewById(R.id.tv_item_kota);
            tvTime = itemView.findViewById(R.id.tv_upload_time);
            rv = itemView.findViewById(R.id.rvListJob);
        }
    }
}
