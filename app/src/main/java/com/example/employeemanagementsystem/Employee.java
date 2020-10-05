package com.example.employeemanagementsystem;

public class Employee {
    int _ID;
    String _FNAME;
    String _MNAME;
    String _LNAME;
    String _GENDER;
    String _DOB;
    String _DEPARTMENTS;
    String _ADDRESS;
    String _CITY;
    String _SALARY;
    String _CONTACT;

    public Employee() {    }

    public Employee(int _ID) {
        this._ID = _ID;
    }

    public Employee(String _FNAME, String _MNAME, String _LNAME, String _GENDER, String _DOB, String _DEPARTMENTS, String _ADDRESS, String _CITY, String _SALARY, String _CONTACT) {
        this._FNAME = _FNAME;
        this._MNAME = _MNAME;
        this._LNAME = _LNAME;
        this._GENDER = _GENDER;
        this._DOB = _DOB;
        this._DEPARTMENTS = _DEPARTMENTS;
        this._ADDRESS = _ADDRESS;
        this._CITY = _CITY;
        this._SALARY = _SALARY;
        this._CONTACT = _CONTACT;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String get_FNAME() {
        return _FNAME;
    }

    public void set_FNAME(String _FNAME) {
        this._FNAME = _FNAME;
    }

    public String get_MNAME() {
        return _MNAME;
    }

    public void set_MNAME(String _MNAME) {
        this._MNAME = _MNAME;
    }

    public String get_LNAME() {
        return _LNAME;
    }

    public void set_LNAME(String _LNAME) {
        this._LNAME = _LNAME;
    }

    public String get_GENDER() {
        return _GENDER;
    }

    public void set_GENDER(String _GENDER) {
        this._GENDER = _GENDER;
    }

    public String get_DOB() {
        return _DOB;
    }

    public void set_DOB(String _DOB) {
        this._DOB = _DOB;
    }

    public String get_DEPARTMENTS() {
        return _DEPARTMENTS;
    }

    public void set_DEPARTMENTS(String _DEPARTMENTS) {
        this._DEPARTMENTS = _DEPARTMENTS;
    }

    public String get_ADDRESS() {
        return _ADDRESS;
    }

    public void set_ADDRESS(String _ADDRESS) {
        this._ADDRESS = _ADDRESS;
    }

    public String get_CITY() {
        return _CITY;
    }

    public void set_CITY(String _CITY) {
        this._CITY = _CITY;
    }

    public String get_SALARY() {
        return _SALARY;
    }

    public void set_SALARY(String _SALARY) {
        this._SALARY = _SALARY;
    }

    public String get_CONTACT() {
        return _CONTACT;
    }

    public void set_CONTACT(String _CONTACT) {
        this._CONTACT = _CONTACT;
    }
}
