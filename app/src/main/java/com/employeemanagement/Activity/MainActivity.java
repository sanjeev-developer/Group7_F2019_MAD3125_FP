package com.employeemanagement.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.employeemanagement.R;
import com.employeemanagement.Utils.EmployeeData;
import com.employeemanagement.Utils.Vehicledata;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.but_login_splash)
    Button but_login_splash;

    @BindView(R.id.login_email)
    EditText login_email;

    @BindView(R.id.login_password)
    EditText login_password;

    String adminUsername = "Admin";
    String adminPassword = "123456";

    EmployeeData empobj;
    Vehicledata vehicledata;

    public static ArrayList<EmployeeData> emparray ;
    ArrayList<String> userobj = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emparray =  new ArrayList<EmployeeData>();
        ButterKnife.bind(this);
        but_login_splash.setOnClickListener(this);

        userobj.add("naobie");
        userobj.add("Desmond");
        userobj.add("azeio");
        userobj.add("dante");
        userobj.add("chief");
        userobj.add("alex");

        for(int i=1; i<=userobj.size(); i++)
        {
            empobj = new EmployeeData();
            vehicledata = new Vehicledata();
            empobj.setEmpname(userobj.get(i-1));
            empobj.setType("Parttime");
            empobj.setPhoneno("123456789");
            empobj.setDateofbirth("28th april 1992");
            empobj.setEmail("Sanjeevgupta9223@gmail.com");
            empobj.setPassword("12345"+i);

            ArrayList<Vehicledata>vobj = new ArrayList<>();
            vehicledata.setCompany("Honda");
            vehicledata.setModel("classic");
            vehicledata.setYear("2016");
            vehicledata.setPlate("Mx56789");
            vobj.add(vehicledata);
            empobj.setVehobj(vobj);
            emparray.add(empobj);
            System.out.println(""+emparray.size());
        }

        hidekeyboard();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.but_login_splash:

                if(login_email.getText().toString().equals(""))
                {
                    displayAlert( MainActivity.this, "Please enter username");
                }
                else if(login_password.getText().toString().equals(""))
                {
                    displayAlert(MainActivity.this,"Please enter password");
                }
                else
                {
                    if(login_email.getText().toString().equals(adminUsername) && login_password.getText().toString().equals(adminPassword))
                    {
                        intent = new Intent(MainActivity.this, Dashboard.class);
                        startActivity(intent);
                    }
                    else
                    {
                        displayAlert(MainActivity.this,"Please check the Username or password");
                    }
                }

                break;


//            case R.id.but_signup:

//                intent = new Intent(MainActivity.this, SignUpActivity.class);
//                startActivity(intent)

//                break;

        }
    }
}