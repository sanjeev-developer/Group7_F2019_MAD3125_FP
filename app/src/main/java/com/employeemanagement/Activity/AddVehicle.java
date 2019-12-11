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

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {

            case R.id.img_back_addveh:

                intent = new Intent(AddVehicle.this, Dashboard.class);
                startActivity(intent);

                break;

            case R.id.ll_company:

                sp_company.performClick();

                break;

            case R.id.ll_model:

                sp_model.performClick();

                break;

            case R.id.ll_year:

                sp_year.performClick();

                break;

            case R.id.but_add:

                if(txt_company.getText().toString().equals("Select Company"))
                {
                    displayAlert(AddVehicle.this, "Please select the company");
                }
                else if(txt_model.getText().toString().equals("Select Model"))
                {
                    displayAlert(AddVehicle.this, "Please select the Model");
                }
                else if (edt_plateno.getText().toString().equals(""))
                {
                    displayAlert(AddVehicle.this, "Please enter the plate no");
                }
                else if(txt_year.getText().toString().equals("Select year"))
                {
                    displayAlert(AddVehicle.this, "Please select the year");
                }
                else
                {
                    if(getIntent().getIntExtra("option",0) == 2) {
                        MainActivity.emparray.get(position).getVehobj().remove(getIntent().getIntExtra("vposition",0));
                    }

                    EmployeeData empobj = new EmployeeData();
                    Vehicledata vehicledata = new Vehicledata();
                    vehicledata.setCompany(txt_company.getText().toString());
                    vehicledata.setModel(txt_model.getText().toString());
                    vehicledata.setYear(txt_year.getText().toString());
                    vehicledata.setPlate(edt_plateno.getText().toString());
                    MainActivity.emparray.get(position).getVehobj().add(vehicledata);

                    Toast.makeText(AddVehicle.this,"Successfully added vehicle", Toast.LENGTH_SHORT).show();

                    intent = new Intent(AddVehicle.this, Dashboard.class);
                    AddVehicle.this.startActivity(intent);

                    System.out.println(">>>"+empobj);
                }

                break;
        }
    }

    public void setdata(String s, int i,int position) {

        if(i==1)
        {
            txt_company.setText(s);

            if("Honda" == companydata.get(position))
            {
                img_Company.setBackgroundResource(R.drawable.honda);
            }
            else if (companydata.get(position) == "Chervolet")
            {
                img_Company.setBackgroundResource(R.drawable.cheve);
            }
            else if (companydata.get(position) == "BMW")
            {
                img_Company.setBackgroundResource(R.drawable.bmw);
            }
            else if (companydata.get(position) == "Mercedes")
            {
                img_Company.setBackgroundResource(R.drawable.mercedes);
            }
            else if (companydata.get(position) == "Landrover")
            {
                img_Company.setBackgroundResource(R.drawable.landrover);
            }
            else if (companydata.get(position) == "Bajaj")
            {
                img_Company.setBackgroundResource(R.drawable.chetak);
            }
            else if (companydata.get(position) == "Ford")
            {
                img_Company.setBackgroundResource(R.drawable.ford);
            }
            else if (companydata.get(position) == "Suzuki")
            {
                img_Company.setBackgroundResource(R.drawable.suzuki);
            }
            else if (companydata.get(position) == "Audi")
            {
                img_Company.setBackgroundResource(R.drawable.audi);
            }

            spinnerAdapter = new TypeAdapter(AddVehicle.this, companydata, 1);
            sp_company.setAdapter(spinnerAdapter);
        }
        else if (i==2)
        {
            txt_model.setText(s);
            spinnerAdapter = new TypeAdapter(AddVehicle.this, modeldata, 2);
            sp_model.setAdapter(spinnerAdapter);

        }
        else if(i==3)
        {
            txt_year.setText(s);
            spinnerAdapter = new TypeAdapter(AddVehicle.this, yeardata, 3);
            sp_year.setAdapter(spinnerAdapter);
        }
    }
}





