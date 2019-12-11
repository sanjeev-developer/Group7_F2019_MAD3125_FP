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
