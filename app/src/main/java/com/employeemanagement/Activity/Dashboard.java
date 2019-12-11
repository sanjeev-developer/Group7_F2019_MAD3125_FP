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