package com.atzhuang.bean.responseBody;

public class CityMajorCount {
    public String Major;
    public String city;

    public Long Count;

    public CityMajorCount(String major, String city, Long count) {
        Major = major;
        this.city = city;
        Count = count;
    }
}
