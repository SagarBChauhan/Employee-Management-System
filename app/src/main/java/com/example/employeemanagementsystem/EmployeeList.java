package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EmployeeList extends AppCompatActivity {

    ListView lv_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        lv_1=findViewById(R.id.lv_1);

        DBHelper dbHelper=new DBHelper(getApplicationContext());
        ArrayList<String> EmpList=dbHelper.getAllData();
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,EmpList);
lv_1.setAdapter(adp);
    }
}
