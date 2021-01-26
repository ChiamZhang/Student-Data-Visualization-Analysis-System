package com.atzhuang.bean.responseBody;

public class ProvinceGradeCount {

    public long stu_grade;
    public String province;

    public long quality;

    public ProvinceGradeCount(String province, long stu_grade, long quality) {
        this.province = province;
        this.stu_grade = stu_grade;
        this.quality = quality;
    }

}
