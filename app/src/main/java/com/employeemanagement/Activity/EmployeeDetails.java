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