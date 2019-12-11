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