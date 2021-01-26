package com.atzhuang.bean.responseBody;

public class GradeMonthCost {
    public int stu_grade;
    public int moth;
    public Double cost;

    public GradeMonthCost(int grade, int moth, double cost) {
        this.stu_grade = grade;
        this.moth = moth;
        this.cost = cost;
    }
}
