package com.employeemanagement.Activity;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.employeemanagement.Adapters.VehAdapter;
import com.employeemanagement.Model.Vehicle;
import com.employeemanagement.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VehicleList extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.img_addveh)
    ImageView img_addveh;

    @BindView(R.id.img_addveh_back)
    ImageView img_addveh_back;

    @BindView(R.id.rec_vehlist)
    RecyclerView rec_vehlist;

    VehAdapter vehicleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list);

        ButterKnife.bind(this);
        img_addveh.setOnClickListener(this);
        img_addveh_back.setOnClickListener(this);

        vehicleAdapter = new VehAdapter(VehicleList.this, MainActivity.emparray, getIntent().getIntExtra("position", 0));
        LinearLayoutManager layoutManager = new LinearLayoutManager(VehicleList.this);
        rec_vehlist.setLayoutManager(layoutManager);
        rec_vehlist.setHasFixedSize(true);
        rec_vehlist.setItemAnimator(new DefaultItemAnimator());
        rec_vehlist.setAdapter(vehicleAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.img_addveh:

                intent = new Intent(VehicleList.this, AddVehicle.class);
                startActivity(intent);

                break;


            case R.id.img_addveh_back:

                intent = new Intent(VehicleList.this, EmployeeList.class);
                intent.putExtra("decision","addempveh");
                startActivity(intent);

                break;

        }
    }

    public void deleteveh(int position) {

        //dialog intialization
        Alert = new Dialog(VehicleList.this);
        Alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        Alert.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(VehicleList.this, R.color.transparent)));
        Alert.setContentView(R.layout.chooselayout);

        LinearLayout delete = (LinearLayout) Alert.findViewById(R.id.ll_alert_delete);
        LinearLayout edit = (LinearLayout) Alert.findViewById(R.id.ll_alert_edit);
        LinearLayout cancel = (LinearLayout) Alert.findViewById(R.id.ll_alert_cancel);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MainActivity.emparray.get(getIntent().getIntExtra("position", 0)).getVehobj().remove(position);
                vehicleAdapter.notifyDataSetChanged();
                Alert.cancel();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {   Alert.cancel();
                Intent intent = new Intent(VehicleList.this, AddVehicle.class);
                intent.putExtra("vposition",position);
                intent.putExtra("option",2);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Alert.cancel();
            }
        });

        Alert.show();
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(VehicleList.this, EmployeeList.class);
        intent.putExtra("decision","addempveh");
        startActivity(intent);

    }
}
