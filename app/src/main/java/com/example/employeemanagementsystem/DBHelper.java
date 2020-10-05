package com.example.employeemanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="EmployeeManagementSystem";
    private static final String TABLE_NAME="EmployeeManagementSystem";
    private static final int VERSION=1;
    private static final String KEY_ID="ID";
    private static final String KEY_FNAME="FNAME";
    private static final String KEY_MNAME="MNAME";
    private static final String KEY_LNAME="LNAME";
    private static final String KEY_GENDER="GENDER";
    private static final String KEY_DOB="DOB";
    private static final String KEY_DEPARTMENT="DEPARTMENT";
    private static final String KEY_ADDRESS="ADDRESS";
    private static final String KEY_CITY="CITY";
    private static final String KEY_SALARY="SALARY";
    private static final String KEY_CONTACT="CONTACT";
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Query="CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER primary key autoincrement,"+ KEY_FNAME+" TEXT, "+KEY_MNAME +" TEXT, "+KEY_LNAME +" TEXT,"+KEY_GENDER+" TEXT,"+KEY_DOB +" TEXT,"+KEY_DEPARTMENT +" TEXT, "+KEY_ADDRESS+" TEXT, "+KEY_CITY+" TEXT, "+KEY_SALARY+" TEXT, "+KEY_CONTACT+" TEXT)";
        sqLiteDatabase.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+";");
        onCreate(sqLiteDatabase);
    }

    public void AddEmployee(Employee employee)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_FNAME,employee.get_FNAME());
        values.put(KEY_MNAME,employee.get_MNAME());
        values.put(KEY_LNAME,employee.get_LNAME());
        values.put(KEY_GENDER,employee.get_GENDER());
        values.put(KEY_DOB,employee.get_DOB());
        values.put(KEY_DEPARTMENT,employee.get_DEPARTMENTS());
        values.put(KEY_ADDRESS,employee.get_ADDRESS());
        values.put(KEY_CITY,employee.get_CITY());
        values.put(KEY_SALARY,employee.get_SALARY());
        values.put(KEY_CONTACT,employee.get_CONTACT());
        db.insert(TABLE_NAME,null,values);
    }

    public boolean insertData(String fname,String mname,String lname,String gender,String dob,String department,String address,String city,String salary, String contact)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_FNAME,fname);
        values.put(KEY_MNAME,mname);
        values.put(KEY_LNAME,lname);
        values.put(KEY_GENDER,gender);
        values.put(KEY_DOB,dob);
        values.put(KEY_DEPARTMENT,department);
        values.put(KEY_ADDRESS,address);
        values.put(KEY_CITY,city);
        values.put(KEY_SALARY,salary);
        values.put(KEY_CONTACT,contact);
        long result = db.insert(TABLE_NAME,null,values);
        if (result==-1)
            return false;
        else
            return true;
    }

    public ArrayList<String> getAllData()
    {
        ArrayList<String> EmpList=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery("Select * from "+TABLE_NAME,null);
        if (cursor.moveToFirst())
        {
            do {
            }while (cursor.moveToNext());
            EmpList.add(cursor.getString(0)+","+cursor.getString(1)+","+cursor.getString(2)+","+cursor.getString(3));
        }
        return EmpList;
    }

}
