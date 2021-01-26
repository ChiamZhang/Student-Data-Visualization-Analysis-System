package com.atzhuang.bean.responseBody;

public class NatureGradeCount {
    public long stu_grade;
    public String nature;
    public long quality;

    public NatureGradeCount(long stu_grade, String nature, long quality) {
        this.stu_grade = stu_grade;
        this.nature = nature;
        this.quality = quality;
    }
}
