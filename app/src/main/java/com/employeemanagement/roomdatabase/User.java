package com.employeemanagement.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public long id;
    public String empfullname;
    public String emptype;
    public String empemail;
    public String empdob;
    public String emppassword;
    public String empmobile;

   // List<Vehicle> vehiclesarry = new List<Vehicle>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpfullname() {
        return empfullname;
    }

    public void setEmpfullname(String empfullname) {
        this.empfullname = empfullname;
    }

    public String getEmptype() {
        return emptype;
    }

    public void setEmptype(String emptype) {
        this.emptype = emptype;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public String getEmpdob() {
        return empdob;
    }

    public void setEmpdob(String empdob) {
        this.empdob = empdob;
    }

    public String getEmppassword() {
        return emppassword;
    }

    public void setEmppassword(String emppassword) {
        this.emppassword = emppassword;
    }

    public String getEmpmobile() {
        return empmobile;
    }

    public void setEmpmobile(String empmobile) {
        this.empmobile = empmobile;
    }

//    public List<Vehicle> getVehiclesarry() {
//        return vehiclesarry;
//    }
//
//    public void setVehiclesarry(List<Vehicle> vehiclesarry) {
//        this.vehiclesarry = vehiclesarry;
//    }
}