package com.atzhuang.bean.responseBody;

public class NatureCollegeCount {
    public String college;
    public  String nature;

    public  Long Count;

    public NatureCollegeCount(String college, String nature, Long count) {
        this.college = college;
        this.nature = nature;
        Count = count;
    }
}
