package com.example.peluangkerja;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;


public class listJobFragment extends Fragment {
    private RecyclerView rvJob;
    private ArrayList<Jobs> list = new ArrayList<>();
    private Activity view;

    public listJobFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState){
        super.onViewCreated(view,saveInstanceState);

        rvJob = view.findViewById(R.id.rvListJob);
        rvJob.setHasFixedSize(true);
        list.addAll(JobDatas.getJobList());
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        rvJob.setLayoutManager(new LinearLayoutManager(getActivity()));
        listJobAdapter jobAdapter = new listJobAdapter(JobDatas.getJobList(), getActivity());
        rvJob.addItemDecoration(new DividerItemDecoration(rvJob.getContext(), lm.getOrientation()));
        rvJob.setAdapter(jobAdapter);
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_job, container, false);


    }

}