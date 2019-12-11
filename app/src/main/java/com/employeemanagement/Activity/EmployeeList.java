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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        ButterKnife.bind(this);
        img_back_el.setOnClickListener(this);
        recyclerView = findViewById(R.id.rec_dash);

        dashAdapter = new DashAdapter(EmployeeList.this, MainActivity.emparray, getIntent().getStringExtra("decision"));
        layoutManager = new LinearLayoutManager(EmployeeList.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dashAdapter);
    }

    @Override
    public void onClick(View v)
    {
        intent = new Intent(EmployeeList.this, Dashboard.class);
        startActivity(intent);
    }

    public void deletedata(int position) {


    }
}
