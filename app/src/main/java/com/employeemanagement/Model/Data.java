package com.employeemanagement.Model;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

        @SerializedName("jsondata")
        @Expose
        private ArrayList<Jsondatum> jsondata = null;

        public ArrayList<Jsondatum> getJsondata() {
            return jsondata;
        }

        public void setJsondata(ArrayList<Jsondatum> jsondata) {
            this.jsondata = jsondata;
        }

    }

