package com.atzhuang.bean.responseBody;

public class CollegeGradeCount {

    public long stu_grade;
    public String college;
    public long quality;

    public CollegeGradeCount(String college, long stu_grade, long quality) {
        this.stu_grade = stu_grade;
        this.college = college;
        this.quality = quality;
    }
}
