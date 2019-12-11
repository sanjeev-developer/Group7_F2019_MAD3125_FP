package com.employeemanagement.Activity;

import androidx.core.content.FileProvider;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.employeemanagement.ApiClient.ApiClient;
import com.employeemanagement.ApiInterface.ApiInterface;
import com.employeemanagement.R;
import com.employeemanagement.Utils.EmployeeData;
import com.employeemanagement.Utils.ImageCompressionLikeWhatsapp;
import com.employeemanagement.Utils.ImagePicker;
import com.employeemanagement.Utils.TypeAdapter;
import com.employeemanagement.roomdatabase.AppDatabase;
import com.employeemanagement.roomdatabase.User;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddEmployee extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.img_signup_back)
    ImageView img_signup_back;

    @BindView(R.id.but_addemp)
    Button but_addemp;

    @BindView(R.id.edt_ae_fullname)
    EditText edt_ae_fullname;

    @BindView(R.id.et_ae_phoneno)
    EditText et_ae_phoneno;

    @BindView(R.id.edt_ae_dob)
    TextView edt_ae_dob;

    @BindView(R.id.edt_ae_email)
    EditText edt_ae_email;

    @BindView(R.id.sp_ae)
    Spinner sp_ae;

    @BindView(R.id.profile_image_signup)
    ImageView profile_image_signup;

    @BindView(R.id.ll_ae_type)
    LinearLayout ll_ae_type;

    @BindView(R.id.ll_Intern)
    LinearLayout ll_Intern;

    @BindView(R.id.ll_Pfa)
    LinearLayout ll_Pfa;

    @BindView(R.id.ll_Ptc)
    LinearLayout ll_Ptc;

    @BindView(R.id.ll_fulltime)
    LinearLayout ll_fulltime;

    @BindView(R.id.txt_ae_type)
    TextView txt_ae_type;

    @BindView(R.id.edt_intern_salary)
    EditText edt_intern_salary;

    @BindView(R.id.edt_intern_schoolname)
    EditText edt_intern_schoolname;

    @BindView(R.id.edt_rate_pfa)
    EditText edt_rate_pfa;

    @BindView(R.id.edt_hourworked_pfa)
    EditText edt_hourworked_pfa;

    @BindView(R.id.edt_fixedamount_pfa)
    EditText edt_fixedamount_pfa;

    @BindView(R.id.edt_rate_ptc)
    EditText edt_rate_ptc;

    @BindView(R.id.edt_hourworked_ptc)
    EditText edt_hourworked_ptc;

    @BindView(R.id.edt_cp_ptc)
    EditText edt_cp_ptc;

    @BindView(R.id.edt_salary_ft)
    EditText edt_salary_ft;

    @BindView(R.id.edt_hourworked_ft)
    EditText edt_hourworked_ft;

    ApiInterface apiInterface;

    boolean image_b = false;
    Intent intent;
    int REQUEST_CAMERA = 100;
    int SELECT_IMAGES = 200;
    Dialog dialog;
    Uri mediaUri;
    File photoFile;
    String realPth = "";
    Uri imageUri = null;
    int SignupAs;
    private static final String TAG = "Employee";
    ImageCompressionLikeWhatsapp imageCompressionLikeWhatsapp;
    String compressed_real_path;

    ArrayList<String> specdata = new ArrayList<>();
    private AppDatabase mDb;
    Handler handler;
    static final int DATE_DIALOG_ID = 999;
    private String dob = "";
    private String monthname;
    private int myear;
    private int mmonth;
    private int mday;
    public Calendar c;
    TypeAdapter spinnerAdapter;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        user = new User();

        specdata.add("Intern");
        specdata.add("FullTime");
        specdata.add("Part time Fixed");
        specdata.add("Part time commisioned");

        ButterKnife.bind(this);

        image_b = false;
        but_addemp.setOnClickListener(this);
        img_signup_back.setOnClickListener(this);
        ll_ae_type.setOnClickListener(this);
        edt_ae_dob.setOnClickListener(this);
        profile_image_signup.setOnClickListener(this);
        imageCompressionLikeWhatsapp = new ImageCompressionLikeWhatsapp(AddEmployee.this)

        spinnerAdapter = new TypeAdapter(AddEmployee.this, specdata, 0);
        sp_ae.setAdapter(spinnerAdapter);
        //signup_type_sp.setOnItemSelectedListener(this);
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
    }


