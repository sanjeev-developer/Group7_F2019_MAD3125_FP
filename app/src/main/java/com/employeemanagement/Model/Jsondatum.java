package com.employeemanagement.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Jsondatum {

    @SerializedName("@class")
    @Expose
    private String _class;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;
    @SerializedName("schoolName")
    @Expose
    private String schoolName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("salary")
    @Expose
    private Double salary;
    @SerializedName("bonus")
    @Expose
    private Double bonus;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("hoursWorked")
    @Expose
    private Integer hoursWorked;
    @SerializedName("fixedAmount")
    @Expose
    private Double fixedAmount;
    @SerializedName("commissionPercent")
    @Expose
    private Integer commissionPercent;

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Double getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(Double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }

    public Integer getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(Integer commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

}