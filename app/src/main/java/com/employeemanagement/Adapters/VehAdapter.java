package com.employeemanagement.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.employeemanagement.Activity.MainActivity;
import com.employeemanagement.Activity.VehicleList;
import com.employeemanagement.R;
import com.employeemanagement.Utils.EmployeeData;

import java.util.ArrayList;

public class VehAdapter extends RecyclerView.Adapter<VehAdapter.MyViewHolder>
{
    private Context context;
    ArrayList<EmployeeData> emparray ;
    int decision;
    Intent intent;

    public VehAdapter(Context contexts, ArrayList<EmployeeData> emparray, int decision)
    {
        this.context = contexts;
        this.emparray= emparray;
        this.decision = decision;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.veh_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        if("Honda" == MainActivity.emparray.get(decision).getVehobj().get(position).getCompany())
        {
            holder.img_veh.setBackgroundResource(R.drawable.honda);
        }
        else if (MainActivity.emparray.get(decision).getVehobj().get(position).getCompany() == "Chervolet")
        {
            holder.img_veh.setBackgroundResource(R.drawable.cheve);
        }
        else if (MainActivity.emparray.get(decision).getVehobj().get(position).getCompany() == "BMW")
        {
            holder.img_veh.setBackgroundResource(R.drawable.bmw);
        }
        else if (MainActivity.emparray.get(decision).getVehobj().get(position).getCompany() == "Mercedes")
        {
            holder.img_veh.setBackgroundResource(R.drawable.mercedes);
        }
        else if (MainActivity.emparray.get(decision).getVehobj().get(position).getCompany() == "Landrover")
        {
            holder.img_veh.setBackgroundResource(R.drawable.landrover);
        }
        else if (MainActivity.emparray.get(decision).getVehobj().get(position).getCompany() == "Bajaj")
        {
            holder.img_veh.setBackgroundResource(R.drawable.chetak);
        }
        else if (MainActivity.emparray.get(decision).getVehobj().get(position).getCompany() == "Ford")
        {
            holder.img_veh.setBackgroundResource(R.drawable.ford);
        }
        else if (MainActivity.emparray.get(decision).getVehobj().get(position).getCompany() == "Suzuki")
        {
            holder.img_veh.setBackgroundResource(R.drawable.suzuki);
        }
        else if (MainActivity.emparray.get(decision).getVehobj().get(position).getCompany() == "Audi")
        {
            holder.img_veh.setBackgroundResource(R.drawable.audi);
        }

        holder.cname.setText(MainActivity.emparray.get(decision).getVehobj().get(position).getCompany());
        holder.cmodel.setText(MainActivity.emparray.get(decision).getVehobj().get(position).getModel());
        holder.cyear.setText(MainActivity.emparray.get(decision).getVehobj().get(position).getYear());

        holder.ll_vcard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                ((VehicleList) context).deleteveh(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return emparray.get(decision).getVehobj().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cname, cmodel, cyear;
        LinearLayout ll_vcard;
        ImageView img_veh;

        public MyViewHolder(View view) {
            super(view);

            ll_vcard=(LinearLayout) view.findViewById(R.id.ll_vcard);
            cname=(TextView)view.findViewById(R.id.text_cname);
            cmodel=(TextView) view.findViewById(R.id.text_model);
            cyear=(TextView)view.findViewById(R.id.text_year);
            img_veh=(ImageView)view.findViewById(R.id.img_veh);
        }
    }
}