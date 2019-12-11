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

        companydata.add("Honda");
        companydata.add("Chervolet");
        companydata.add("BMW");
        companydata.add("Mercedes");
        companydata.add("Landrover");
        companydata.add("Bajaj");
        companydata.add("Ford");
        companydata.add("Audi");

        modeldata.add("Base");
        modeldata.add("Mid-range");
        modeldata.add("Classic");
        modeldata.add("Magnum");
        modeldata.add("Supra");
        modeldata.add("xdvt");
        modeldata.add("Magnum-turbo");
        modeldata.add("elegant");

        yeardata.add("2004");
        yeardata.add("2005");
        yeardata.add("2005");
        yeardata.add("2006");
        yeardata.add("2007");
        yeardata.add("2008");
        yeardata.add("2009");
        yeardata.add("2010");
        yeardata.add("2011");
        yeardata.add("2012");
        yeardata.add("2013");
        yeardata.add("2014");
        yeardata.add("2015");
        yeardata.add("2016");

        but_add.setOnClickListener(this);
        img_back_addveh.setOnClickListener(this);
        ll_company.setOnClickListener(this);
        ll_model.setOnClickListener(this);
        ll_year.setOnClickListener(this);

        position = getIntent().getIntExtra("position",0);

        spinnerAdapter = new TypeAdapter(AddVehicle.this, companydata, 1);
        sp_company.setAdapter(spinnerAdapter);

        spinnerAdapter = new TypeAdapter(AddVehicle.this, modeldata, 2);
        sp_model.setAdapter(spinnerAdapter);

        spinnerAdapter = new TypeAdapter(AddVehicle.this, yeardata, 3);
        sp_year.setAdapter(spinnerAdapter);

        if(getIntent().getIntExtra("option",0) == 2)
        {
            txt_company.setText(MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany());
            txt_model.setText(MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getModel());
            txt_year.setText(MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getYear());
            edt_plateno.setText(MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getPlate());

            if("Honda" == MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany())
            {
                img_Company.setBackgroundResource(R.drawable.honda);
            }
            else if (MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany() == "Chervolet")
            {
                img_Company.setBackgroundResource(R.drawable.cheve);
            }
            else if (MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany() == "BMW")
            {
                img_Company.setBackgroundResource(R.drawable.bmw);
            }
            else if (MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany() == "Mercedes")
            {
                img_Company.setBackgroundResource(R.drawable.mercedes);
            }
            else if (MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany() == "Landrover")
            {
                img_Company.setBackgroundResource(R.drawable.landrover);
            }
            else if (MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany() == "Bajaj")
            {
                img_Company.setBackgroundResource(R.drawable.chetak);
            }
            else if (MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany() == "Ford")
            {
                img_Company.setBackgroundResource(R.drawable.ford);
            }
            else if (MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany() == "Suzuki")
            {
                img_Company.setBackgroundResource(R.drawable.suzuki);
            }
            else if (MainActivity.emparray.get(position).getVehobj().get(getIntent().getIntExtra("vposition",0)).getCompany() == "Audi")
            {
                img_Company.setBackgroundResource(R.drawable.audi);
            }

        }
    }

