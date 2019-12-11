package com.employeemanagement.Activity;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.employeemanagement.Adapters.DashAdapter;
import com.employeemanagement.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeList extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.img_back_el)
    ImageView img_back_el;

    DashAdapter dashAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;