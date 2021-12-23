package com.example.peluangkerja.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.peluangkerja.MainActivity;
import com.example.peluangkerja.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
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
    private View fragmentView,bottom_sheet;
    private FragmentActivity myContext;
    private BottomSheetBehavior sheetBehavior;
    private BottomSheetDialog sheetDialog;
    private ImageView imgExperience,imgEducation,imgLanguages;

    public profileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        setHasOptionsMenu(true);
        initComponent();
        initToolbar();
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
        imgExperience = fragmentView.findViewById(R.id.img_experience);
        imgEducation = fragmentView.findViewById(R.id.img_education);
        imgLanguages = fragmentView.findViewById(R.id.img_languages);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.age)), spAge);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.categoryprofile)), spCategory);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.experienceprofile)), spExperience);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.salary)), spCurentSalary);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.salary)), spExpecSalary);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.nationaly)), spNationaly);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.nationaly)), spCountry);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.state)), spState);
        setSpinner(Arrays.asList(getResources().getStringArray(R.array.city)), spCity);

        bottom_sheet = fragmentView.findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        imgExperience.setOnClickListener(view -> {
            showBottomSheetDialog("Experience");
        });

        imgEducation.setOnClickListener(view -> {
            showBottomSheetDialog("Education");
        });
        imgLanguages.setOnClickListener(view -> {
            showBottomSheetDialog("Languages");
        });

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
                datetime.setText(formattedTime);
            }
        }, year, month, day);
        datePickerDialog.show(getActivity().getFragmentManager(), "Datepickerdialog");
    }

    private void showBottomSheetDialog(String data) {
        View view = null;
        if (data == "Experience"){
            view = getLayoutInflater().inflate(R.layout.sheet_experience, null);
        }else if (data == "Education"){
            view = getLayoutInflater().inflate(R.layout.sheet_education, null);
        }else if (data == "Languages"){
            view = getLayoutInflater().inflate(R.layout.sheet_languages, null);
        }

        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        view.findViewById(R.id.btnCancel).setOnClickListener(v -> {
            sheetDialog.dismiss();
        });
        sheetDialog = new BottomSheetDialog(getContext());
        sheetDialog.setContentView(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            sheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        sheetDialog.show();
        sheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                sheetDialog = null;
            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = fragmentView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar= ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Profile");
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getActivity().getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#5baad9"));
        }
    }


    //button back toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                //getActivity().onBackPressed();
                return true;
        }
        return true;
    }
}