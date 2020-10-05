package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_DOB;
    EditText fname,mname,lname,address,city,salary,contact;
    Spinner department;
    RadioGroup gender;
    Button btn_Save;
    String gen="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        datePickerDialog();
        radio();
        add();
    }

    private void radio() {
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i)
                {
                    case R.id.radio_Male:
                        gen="Male";
                        break;
                    case R.id.radio_Female:
                        gen="Female";
                        break;
                }
            }
        });
    }

    private void add() {
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DBHelper dbHelper=new DBHelper(getApplicationContext());
//                    dbHelper.AddEmployee(new Employee(fname.getText().toString(),mname.getText().toString(),lname.getText().toString(),gen,tv_DOB.getText().toString(),
//                            department.getSelectedItem().toString(),address.getText().toString(),city.getText().toString(),salary.getText().toString(),
//                            contact.getText().toString()));

//                    dbHelper.insertData(fname.getText().toString(),mname.getText().toString(),lname.getText().toString(),gen,tv_DOB.getText().toString(),
//                            department.getSelectedItem().toString(),address.getText().toString(),city.getText().toString(),salary.getText().toString(),
//                            contact.getText().toString());

                Notification.Builder builder=new Notification.Builder(getApplicationContext())
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle("New Employee")
                        .setContentText("Employee Inserted successfully..")
                        .setAutoCancel(true);
                Intent i = new Intent(getApplicationContext(),EmployeeList.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0,i,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(1,builder.build());
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void datePickerDialog() {
        tv_DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tv_DOB.setText(i2+"/"+i1+1+"/"+i);
                    }
                },2000,12,1);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }

    private void init() {
        tv_DOB=findViewById(R.id.txt_Date);
        fname=findViewById(R.id.etxt_FName);
        mname=findViewById(R.id.etxt_MName);
        lname=findViewById(R.id.etxt_LName);
        address=findViewById(R.id.etxt_Address);
        city=findViewById(R.id.etxt_City);
        salary=findViewById(R.id.etxt_Salary);
        contact=findViewById(R.id.etxt_Contact);
        department=findViewById(R.id.spinner_department);
        gender=findViewById(R.id.radio_group_Gender);
        btn_Save=findViewById(R.id.btn_Save);
    }
}
