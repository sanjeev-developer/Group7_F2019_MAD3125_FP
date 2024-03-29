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
        imageCompressionLikeWhatsapp = new ImageCompressionLikeWhatsapp(AddEmployee.this);

        spinnerAdapter = new TypeAdapter(AddEmployee.this, specdata, 0);
        sp_ae.setAdapter(spinnerAdapter);
        //signup_type_sp.setOnItemSelectedListener(this);
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
    }

    public void checkvalidation()
    {
//        if (!image_b) {
//            displayAlert(this, "Please upload image");
//        }else


        if (edt_ae_fullname.getText().toString().equals("")) {
            displayAlert(this, "Full name can't be blank");
        }else if (et_ae_phoneno.getText().toString().equals("")) {
            displayAlert(this, "Mobile Number can't be blank");
        } else if ((et_ae_phoneno.getText().length() < 10)) {
            displayAlert(this, "Mobile Number must be 10 digit");
        } else if (edt_ae_dob.getText().toString().equals("")) {
            displayAlert(this, "Select date of birth");
        } else if (edt_ae_email.getText().toString().equals("")) {
            displayAlert(this, "Email can't be blank");
        }else if (!isValidEmail(edt_ae_email.getText().toString())) {
            displayAlert(this, "Please enter the valid email");
        }  else if (txt_ae_type.getText().toString().equals("Select type")) {
            displayAlert(this, "select type");
        } else
        {
            EmployeeData empobj = new EmployeeData();
            empobj.setEmpname(edt_ae_fullname.getText().toString());
            empobj.setType(txt_ae_type.getText().toString());
            empobj.setPhoneno(et_ae_phoneno.getText().toString());
            empobj.setDateofbirth(edt_ae_dob.getText().toString());
            empobj.setEmail(edt_ae_email.getText().toString());

            if(txt_ae_type.getText().toString().equals("Intern"))
            {
                empobj.setSalary(edt_intern_salary.getText().toString());
                empobj.setSchoolname(edt_intern_schoolname.getText().toString());
            }
            else if(txt_ae_type.getText().toString().equals("FullTime"))
            {
                empobj.setSalary(edt_salary_ft.getText().toString());
                empobj.setBonus(edt_hourworked_ft.getText().toString());
            }
            else if(txt_ae_type.getText().toString().equals("Part time Fixed"))
            {
                empobj.setRate(edt_rate_pfa.getText().toString());
                empobj.setHourWorked(edt_hourworked_pfa.getText().toString());
                empobj.setFixedamount(edt_fixedamount_pfa.getText().toString());
            }
            else if(txt_ae_type.getText().toString().equals("Part time commisioned"))
            {
                empobj.setRate(edt_rate_ptc.getText().toString());
                empobj.setHourWorked(edt_hourworked_ptc.getText().toString());
                empobj.setCommissionpercent(edt_cp_ptc.getText().toString());
            }

            MainActivity.emparray.add(empobj);

            Toast.makeText(AddEmployee.this,"Successfully added employee", Toast.LENGTH_SHORT).show();



            intent = new Intent(AddEmployee.this, Dashboard.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.img_signup_back:

                intent = new Intent(AddEmployee.this, Dashboard.class);
                startActivity(intent);

                break;


            case R.id.edt_ae_dob:

                hidekeyboard();
                showDialog(DATE_DIALOG_ID);

                break;


            case R.id.ll_ae_type:

                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sp_ae.performClick();

                break;

            case R.id.profile_image_signup:

                showchooser();
                break;


            case R.id.but_addemp:

                checkvalidation();

                break;
        }
    }


    public void showchooser() {
        //dialog intialization
        dialog = new Dialog(AddEmployee.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AddEmployee.this.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.choose);
        dialog.setCancelable(false);

        LinearLayout camera_choose = (LinearLayout) dialog.findViewById(R.id.camera_picker);
        LinearLayout gallery_choose = (LinearLayout) dialog.findViewById(R.id.gallery_picker);
        ImageView cross = (ImageView) dialog.findViewById(R.id.cross_dialog_gallery);

        camera_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("CAMERA >>>>>> ");
                try {
                    launchCameraForImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        });

        gallery_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                galleryImageIntent();
                dialog.dismiss();
            }
        });


        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    // for high quality image
    public void launchCameraForImage() throws IOException {
        try {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            photoFile = getPhotoFileUri();
            mediaUri = FileProvider.getUriForFile(AddEmployee.this, "com.employeemanagement.provider", photoFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mediaUri);

            if (intent.resolveActivity(AddEmployee.this.getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_CAMERA);
            }

        } catch (Exception e) {

            try {
                Log.e("launchCameraForImage: ", e.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    void galleryImageIntent() {
        Intent intent = null;
        try {
            intent = ImagePicker.getPickImageIntent(AddEmployee.this);
            startActivityForResult(intent, SELECT_IMAGES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == android.app.Activity.RESULT_OK) {
            if (requestCode == SELECT_IMAGES) {
                if (data != null && data.getData() != null) {
                    imageUri = data.getData();
                    realPth = getRealPathFromURI(imageUri);
                    profile_image_signup.setImageURI(imageUri);
                    compressed_real_path = imageCompressionLikeWhatsapp.compressImage(realPth);
                    image_b = true;
                }
            } else if (requestCode == REQUEST_CAMERA) {
                realPth = photoFile.getPath();
                imageUri = Uri.parse(realPth);
                compressed_real_path = imageCompressionLikeWhatsapp.compressImage(realPth);
                profile_image_signup.setImageURI(imageUri);
                image_b = true;
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        String path = null;
        String[] proj = {MediaStore.MediaColumns.DATA};
        Cursor cursor = AddEmployee.this.getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }

    public File getPhotoFileUri() {
        // Get safe storage directory for photos
        // Use `getExternalFilesDir` on Context to access package-specific directories.
        // This way, we don't need to request external read/write runtime permissions.
        File mediaStorageDir = new File(AddEmployee.this.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "Employee");

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
            Log.e(TAG, "failed to create directory");
        }

        // Return the file target for the photo based on filename
        File file = new File(mediaStorageDir.getPath() + File.separator + System.currentTimeMillis() + ".jpg");

        return file;
    }


    public static boolean isValidEmail(String st_email) {
        if (st_email == null) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(st_email).matches();
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date

                setCurrentDateOnView();

                DatePickerDialog _date = new DatePickerDialog(this, datePickerListener, myear, mmonth, mday) {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        Calendar cal = Calendar.getInstance();
                        cal.add(Calendar.YEAR, -3);
                        System.out.println("Date = " + cal.getTime());

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        Date date1 = null;

                        try {
                            date1 = sdf.parse("" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        } catch (java.text.ParseException e) {
                            e.printStackTrace();
                        }

                        if (year > myear) {
                            view.updateDate(myear, mmonth, mday);
                            Toast.makeText(getApplicationContext(), "Choose a valid date", Toast.LENGTH_LONG).show();
                        }

                        if (monthOfYear > mmonth && year == myear) {
                            view.updateDate(myear, mmonth, mday);
                            Toast.makeText(getApplicationContext(), "Choose a valid date", Toast.LENGTH_LONG).show();
                        }

                        if (dayOfMonth > mday && year == myear && monthOfYear == mmonth) {
                            view.updateDate(myear, mmonth, mday);
                            Toast.makeText(getApplicationContext(), "Choose a valid date", Toast.LENGTH_LONG).show();
                        }

                        if (date1.after(cal.getTime())) {
                            System.out.println("Date1 is after Date2");
                            view.updateDate(myear, mmonth, mday);
                            Toast.makeText(getApplicationContext(), "Choose a valid date", Toast.LENGTH_LONG).show();
                        }

                    }
                };

                _date.show();
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            myear = selectedYear;
            mmonth = selectedMonth;
            mday = selectedDay;

            switch (mmonth + 1) {
                case 1:
                    monthname = "Jan";

                    break;

                case 2:
                    monthname = "Feb";

                    break;

                case 3:
                    monthname = "Mar";

                    break;

                case 4:
                    monthname = "Apr";

                    break;

                case 5:
                    monthname = "May";

                    break;

                case 6:
                    monthname = "Jun";

                    break;

                case 7:
                    monthname = "Jul";

                    break;

                case 8:
                    monthname = "Aug";

                    break;

                case 9:
                    monthname = "Sep";
                    break;

                case 10:
                    monthname = "Oct";
                    break;

                case 11:
                    monthname = "Nov";
                    break;

                case 12:
                    monthname = "Dec";

                    break;
            }
            dob = monthname + " " + mday + ", " + myear;
            edt_ae_dob.setText(dob);
        }
    };

    public void setCurrentDateOnView() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        c = Calendar.getInstance();
        c.add(Calendar.YEAR, -3);
        myear = c.get(c.YEAR);
        mmonth = c.get(c.MONTH);
        mday = c.get(c.DAY_OF_MONTH);
    }

    public void setdata(String s) {

        txt_ae_type.setText(s);
        //signup_type_sp.performClick();

        if(s.equals("Intern"))
        {
            ll_Intern.setVisibility(View.VISIBLE);
            ll_Pfa.setVisibility(View.GONE);
            ll_Ptc.setVisibility(View.GONE);
            ll_fulltime.setVisibility(View.GONE);
        }
        else if(s.equals("FullTime"))
        {
            ll_Intern.setVisibility(View.GONE);
            ll_Pfa.setVisibility(View.GONE);
            ll_Ptc.setVisibility(View.GONE);
            ll_fulltime.setVisibility(View.VISIBLE);
        }
        else if(s.equals("Part time Fixed"))
        {
            ll_Intern.setVisibility(View.GONE);
            ll_Pfa.setVisibility(View.VISIBLE);
            ll_Ptc.setVisibility(View.GONE);
            ll_fulltime.setVisibility(View.GONE);
        }
        else if(s.equals("Part time commisioned"))
        {
            ll_Intern.setVisibility(View.GONE);
            ll_Pfa.setVisibility(View.GONE);
            ll_Ptc.setVisibility(View.VISIBLE);
            ll_fulltime.setVisibility(View.GONE);
        }

        sp_ae.setAdapter(spinnerAdapter);
    }
}