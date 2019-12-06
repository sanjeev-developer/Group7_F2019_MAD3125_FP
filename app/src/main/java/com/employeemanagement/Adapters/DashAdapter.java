package com.employeemanagement.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.employeemanagement.Activity.AddEmployee;
import com.employeemanagement.Activity.AddVehicle;
import com.employeemanagement.Activity.EmployeeDetails;
import com.employeemanagement.Activity.EmployeeList;
import com.employeemanagement.Activity.MainActivity;
import com.employeemanagement.Activity.VehicleList;
import com.employeemanagement.R;
import com.employeemanagement.Utils.EmployeeData;
import java.util.ArrayList;

public class DashAdapter extends RecyclerView.Adapter<DashAdapter.MyViewHolder>
{
    private Context context;
    ArrayList<EmployeeData> emparray ;
    String decision;
    Intent intent;

    public DashAdapter(Context contexts, ArrayList<EmployeeData> emparray, String decision)
    {
        this.context = contexts;
        this.emparray= emparray;
        this.decision = decision;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashlayout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        holder.title.setText(MainActivity.emparray.get(position).getEmpname());
        holder.age.setText(MainActivity.emparray.get(position).getDateofbirth());
        holder.email.setText(MainActivity.emparray.get(position).getEmail());

        holder.ll_card.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if(decision.equals("viewemp"))
                {
                    intent = new Intent(context, EmployeeDetails.class);
                    context.startActivity(intent);
                }

                else if(decision.equals("addempveh"))
                {
                    intent = new Intent(context, VehicleList.class);
                    intent.putExtra("position",position);
                    context.startActivity(intent);
                }

                else if(decision.equals("deleteemp"))
                {
                    ((EmployeeList) context).deletedata(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return emparray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, age, email;
        LinearLayout ll_card;

        public MyViewHolder(View view) {
            super(view);

            title=(TextView)view.findViewById(R.id.text_name);
            ll_card=(LinearLayout) view.findViewById(R.id.ll_card);
            age=(TextView)view.findViewById(R.id.text_age);
            email=(TextView)view.findViewById(R.id.text_email);
        }
    }
}