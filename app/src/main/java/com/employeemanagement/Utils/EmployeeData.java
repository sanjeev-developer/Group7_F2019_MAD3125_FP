package com.employeemanagement.Utils;

import java.util.ArrayList;

public class EmployeeData {

    String empname ;
    String empid ;
    String schoolname ;
    String dateofbirth ;
    String password ;
    String email ;
    String phoneno ;
    String type ;
    String salary ;
    String rate ;
    String HourWorked ;
    String bonus ;
    String fixedamount ;
    String commissionpercent ;

    ArrayList<Vehicledata> vehobj = new ArrayList<Vehicledata>();

    public String getEmpname() {
        return empname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getHourWorked() {
        return HourWorked;
    }

    public void setHourWorked(String hourWorked) {
        HourWorked = hourWorked;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getFixedamount() {
        return fixedamount;
    }

    public void setFixedamount(String fixedamount) {
        this.fixedamount = fixedamount;
    }

    public String getCommissionpercent() {
        return commissionpercent;
    }

    public void setCommissionpercent(String commissionpercent) {
        this.commissionpercent = commissionpercent;
    }

    public ArrayList<Vehicledata> getVehobj() {
        return vehobj;
    }

    public void setVehobj(ArrayList<Vehicledata> vehobj) {
        this.vehobj = vehobj;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
