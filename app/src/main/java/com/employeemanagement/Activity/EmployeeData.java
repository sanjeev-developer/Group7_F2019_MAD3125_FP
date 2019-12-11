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

        ButterKnife.bind(this);
        card_vae_ed.setOnClickListener(this);

        txt_noe_ed.setText(""+MainActivity.emparray.size());

        for(int i=0; i<MainActivity.emparray.size(); i++)
        {
            for(int y =0; y<MainActivity.emparray.get(i).getVehobj().size(); y++)
            {
                count++;
            }
        }


        txt_nov_ed.setText(""+count);
    }
    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.img_back_edata:

                intent = new Intent(EmployeeData.this, Dashboard.class);
                startActivity(intent);

                break;

            case R.id.card_vae_ed:

                intent = new Intent(EmployeeData.this, EmployeeList.class);
                intent.putExtra("decision","viewemp");
                startActivity(intent);

                break;
        }
    }
}
