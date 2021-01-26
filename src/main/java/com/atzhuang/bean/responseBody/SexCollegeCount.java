package com.atzhuang.bean.responseBody;

public class SexCollegeCount {
    public String college;
    public String sex;

    public long quality;

    public SexCollegeCount( String college,String sex, long quality) {
        this.sex = sex;
        this.college = college;
        this.quality = quality;
    }
}
