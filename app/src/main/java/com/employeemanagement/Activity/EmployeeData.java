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