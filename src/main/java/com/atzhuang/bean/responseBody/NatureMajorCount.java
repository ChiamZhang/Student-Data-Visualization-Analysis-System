package com.atzhuang.bean.responseBody;

public class NatureMajorCount {
    public String major;
    public  String nature;
    public  Long Count;

    public NatureMajorCount(String major, String nature, Long count) {
        this.major = major;
        this.nature = nature;
        Count = count;
    }
}
