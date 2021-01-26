package com.atzhuang.bean.responseBody;

public class SexCityCount {

    public String city;
    public String sex;

    public long quality;

    public SexCityCount( String city,String sex, long quality) {
        this.sex = sex;
        this.city = city;
        this.quality = quality;
    }
}
