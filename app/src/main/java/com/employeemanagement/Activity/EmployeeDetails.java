package com.employeemanagement.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.employeemanagement.Adapters.DashAdapter;
import com.employeemanagement.Adapters.VehAdapter;
import com.employeemanagement.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeDetails extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.txt_name)
    TextView txt_name;

    @BindView(R.id.txt_dob)
    TextView txt_dob;

    @BindView(R.id.txt_empstatus)
    TextView txt_empstatus;

    @BindView(R.id.txt_vstatus)
    TextView txt_vstatus;

    @BindView(R.id.ll_intern)
    LinearLayout ll_intern;

    @BindView(R.id.txt_sn_intern)
    TextView txt_sn_intern;

    @BindView(R.id.txt_salary_intern)
    TextView txt_salary_intern;

    @BindView(R.id.ll_fulltime)
    LinearLayout ll_fulltime;

    @BindView(R.id.txt_salary_fulltime)
    TextView txt_salary_fulltime;

    @BindView(R.id.txt_bonus_fulltime)
    TextView txt_bonus_fulltime;

    @BindView(R.id.ll_ptf)
    LinearLayout ll_ptf;

    @BindView(R.id.txt_ptf_rate)
    TextView txt_ptf_rate;

    @BindView(R.id.txt_ptf_hw)
    TextView txt_ptf_hw;

    @BindView(R.id.txt_ptf_fa)
    TextView txt_ptf_fa;

    @BindView(R.id.ll_ptc)
    LinearLayout ll_ptc;

    @BindView(R.id.txt_rate_ptc)
    TextView txt_rate_ptc;

    @BindView(R.id.txt_hw_ptc)
    TextView txt_hw_ptc;

    @BindView(R.id.txt_com_ptc)
    TextView txt_com_ptc;

    @BindView(R.id.txt_total_ed)
    TextView txt_total_ed;

    @BindView(R.id.rec_empdetails)
    RecyclerView rec_empdetails;

    @BindView(R.id.img_back_ed)
    ImageView img_back_ed;

    VehAdapter vehAdapter;
    LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        ButterKnife.bind(this);
        img_back_ed.setOnClickListener(this);

        if(MainActivity.emparray.get(getIntent().getIntExtra("position",0)).getType() == "Intern")
        {

        }
        else if(MainActivity.emparray.get(getIntent().getIntExtra("position",0)).getType() == "FullTime")
        {

        }
        else if(MainActivity.emparray.get(getIntent().getIntExtra("position",0)).getType() == "Part time Fixed")
        {

        }
        else if(MainActivity.emparray.get(getIntent().getIntExtra("position",0)).getType() == "Part time commisioned")
        {

        }

        vehAdapter = new VehAdapter(EmployeeDetails.this, MainActivity.emparray, getIntent().getIntExtra("position",0));
        layoutManager = new LinearLayoutManager(EmployeeDetails.this);
        rec_empdetails.setLayoutManager(layoutManager);
        rec_empdetails.setHasFixedSize(true);
        rec_empdetails.setItemAnimator(new DefaultItemAnimator());
        rec_empdetails.setAdapter(vehAdapter);
    }

    @Override
    public void onClick(View v) {

        intent = new Intent(EmployeeDetails.this, EmployeeList.class);
        intent.putExtra("decision","viewemp");
        startActivity(intent);

    }
}