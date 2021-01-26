package com.atzhuang.bean.responseBody;

public class CityGradeCount {
    public long stu_grade;
    public String city;
    public long quality;

    public CityGradeCount(String province, long stu_grade, long quality) {
        this.city = province;
        this.stu_grade = stu_grade;
        this.quality = quality;
    }

}
