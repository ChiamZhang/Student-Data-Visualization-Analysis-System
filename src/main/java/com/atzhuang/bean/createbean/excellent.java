package com.atzhuang.bean.createbean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class excellent {

    private Integer number;
    private double grade;
    private String name;
    private String sex;
    private String college;
    private String stu_major;
    private String phone;

    public excellent(Integer number, double grade, String name, String sex, String college, String stu_major, String phone) {
        this.number = number;
        this.grade = grade;
        this.name = name;
        this.sex = sex;
        this.college = college;
        this.stu_major = stu_major;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "excellent{" +
                "number=" + number +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", college='" + college + '\'' +
                ", stu_major='" + stu_major + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
