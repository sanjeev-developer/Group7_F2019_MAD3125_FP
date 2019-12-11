package com.employeemanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.employeemanagement.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dashboard extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.ll_addemp)
    LinearLayout ll_addemp;

    @BindView(R.id.ll_view)
    LinearLayout ll_view;

    @BindView(R.id.ll_logout)
    LinearLayout ll_logout;

    @BindView(R.id.ll_addveh)
    LinearLayout ll_addveh;

    @BindView(R.id.ll_deleteemp)
    LinearLayout ll_deleteemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ButterKnife.bind(this);
        ll_addemp.setOnClickListener(this);
        ll_view.setOnClickListener(this);
        ll_logout.setOnClickListener(this);
        ll_addveh.setOnClickListener(this);
        ll_deleteemp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.ll_addemp:

                intent = new Intent(Dashboard.this, AddEmployee.class);
                startActivity(intent);

                break;

            case R.id.ll_logout:

                displaydiag(Dashboard.this, "Are you sure you want to logout?");

                break;
