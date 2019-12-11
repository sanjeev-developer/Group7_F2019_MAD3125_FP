package com.employeemanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.employeemanagement.R;
import com.employeemanagement.Utils.EmployeeData;
import com.employeemanagement.Utils.TypeAdapter;
import com.employeemanagement.Utils.Vehicledata;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddVehicle extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.img_back_addveh)
    ImageView img_back_addveh;

    @BindView(R.id.img_Company)
    ImageView img_Company;

    @BindView(R.id.txt_company)
    TextView txt_company;

    @BindView(R.id.sp_company)
    Spinner sp_company;

    @BindView(R.id.ll_company)
    LinearLayout ll_company;

    @BindView(R.id.ll_model)
    LinearLayout ll_model;

    @BindView(R.id.txt_model)
    TextView txt_model;

    @BindView(R.id.sp_model)
    Spinner sp_model;

    @BindView(R.id.ll_year)
    LinearLayout ll_year;

    @BindView(R.id.txt_year)
    TextView txt_year;

    @BindView(R.id.sp_year)
    Spinner sp_year;

    @BindView(R.id.edt_plateno)
    EditText edt_plateno;

    @BindView(R.id.but_add)
    Button but_add;

    ArrayList<String> companydata = new ArrayList<>();
    ArrayList<String> modeldata = new ArrayList<>();
    ArrayList<String> yeardata = new ArrayList<>();
    SpinnerAdapter spinnerAdapter;


    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        ButterKnife.bind(this);