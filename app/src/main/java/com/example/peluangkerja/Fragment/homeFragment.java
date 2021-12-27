package com.example.peluangkerja.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.peluangkerja.Adapter.listJobHomeAdapter;
import com.example.peluangkerja.Adapter.listRecomededJobAdapter;
import com.example.peluangkerja.JobDatas;
import com.example.peluangkerja.Jobs;
import com.example.peluangkerja.MainActivity;
import com.example.peluangkerja.R;
import com.example.peluangkerja.loginActivity;

import java.util.ArrayList;


public class homeFragment extends Fragment {

    private RecyclerView rvJob, rvRecomend;
    private ArrayList<Jobs> list = new ArrayList<>();
    private Activity view;
    private ImageView btnLogout;
    public homeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState){
        super.onViewCreated(view,saveInstanceState);
        btnLogout = view.findViewById(R.id.btnLogout);
        rvJob = view.findViewById(R.id.rvListJob);
        rvJob.setHasFixedSize(true);
        list.addAll(JobDatas.getJobList());
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        rvJob.setLayoutManager(new LinearLayoutManager(getActivity()));
        listJobHomeAdapter jobAdapter = new listJobHomeAdapter(JobDatas.getJobList(), getActivity());
        rvJob.addItemDecoration(new DividerItemDecoration(rvJob.getContext(), lm.getOrientation()));
        rvJob.setAdapter(jobAdapter);

        rvRecomend = view.findViewById(R.id.rvRecomendedJob);
        rvRecomend.setHasFixedSize(true);

        LinearLayoutManager lm2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rvRecomend.setLayoutManager(lm2);
        listRecomededJobAdapter jobAdapter2 = new listRecomededJobAdapter(JobDatas.getJobList(), getActivity());
        rvRecomend.addItemDecoration(new DividerItemDecoration(rvRecomend.getContext(), lm2.getOrientation()));
        rvRecomend.setAdapter(jobAdapter2);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), loginActivity.class));
            }
        });
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}