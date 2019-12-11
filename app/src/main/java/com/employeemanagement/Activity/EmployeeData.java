package com.employeemanagement.Activity;

import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.employeemanagement.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeeData extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.txt_noe_ed)
    TextView txt_noe_ed;

    @BindView(R.id.txt_nov_ed)
    TextView txt_nov_ed;

    @BindView(R.id.txt_total_ed)
    TextView txt_total_ed;

    @BindView(R.id.img_back_edata)
    ImageView img_back_edata;

    @BindView(R.id.card_vae_ed)
    CardView card_vae_ed;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_data);