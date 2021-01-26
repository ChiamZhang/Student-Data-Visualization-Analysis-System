package com.atzhuang.bean.responseBody;

public class CityCollegeCount {
    public String college;
    public  String city;

    public  Long Count;

    public CityCollegeCount(String city, String college, Long count) {
        this.city = city;
        this.college = college;
        Count = count;
    }
}
