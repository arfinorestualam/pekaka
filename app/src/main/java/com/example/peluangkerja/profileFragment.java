package com.example.peluangkerja;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class profileFragment extends Fragment {

    private Spinner spAge,spCategory,spExperience, spCurentSalary,spExpecSalary,spNationaly,spCountry,spState,
            spCity;
    private TextView etDate;
    private View fragmentView;
    private FragmentActivity myContext;

    public profileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        initComponent();
        return fragmentView;
    }

    private void initComponent(){
        spAge = fragmentView.findViewById(R.id.spAge_profile);
        spCategory = fragmentView.findViewById(R.id.spCategory_profile);
        spExperience = fragmentView.findViewById(R.id.spExperience_profile);
        spCurentSalary = fragmentView.findViewById(R.id.spSalaryCurent_profile);
        spExpecSalary = fragmentView.findViewById(R.id.spSalaryExpected_profile);
        spNationaly = fragmentView.findViewById(R.id.spNationality_profile);
        spCountry = fragmentView.findViewById(R.id.spCountry_profile);
        spState = fragmentView.findViewById(R.id.spState_profile);
        spCity = fragmentView.findViewById(R.id.spCity_profile);
        etDate = fragmentView.findViewById(R.id.etDateOfBirth_Profile);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.age)), spAge);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.categoryprofile)), spCategory);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.experienceprofile)), spExperience);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.salary)), spCurentSalary);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.salary)), spExpecSalary);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.nationaly)), spNationaly);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.nationaly)), spCountry);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.state)), spState);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.city)), spCity);
        etDate.setOnClickListener(view -> {
            Datepicker(etDate);
        });
    }

    public void setSpinner(List<?> listItem, Spinner spinner) {
        ArrayAdapter<?> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listItem);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void Datepicker(TextView datetime) {
        final Calendar cldr = Calendar.getInstance();
        final int day = cldr.getActualMinimum(Calendar.DAY_OF_MONTH);
        final int month = cldr.get(Calendar.MONTH);
        final int year = cldr.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String newDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                Date date = null;
                try {
                    date = sdf.parse(newDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String formattedTime = sdf.format(date);
                //tanggalString += formattedTime;
                datetime.setText(formattedTime);
            }
        }, year, month, day);
        datePickerDialog.show(getActivity().getFragmentManager(), "Datepickerdialog");
    }

}