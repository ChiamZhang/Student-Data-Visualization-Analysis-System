package com.atzhuang.bean.databean;

import com.atzhuang.inter.IExcelData;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students_basic")
public class students_basic implements IExcelData {
    @Id

    private Integer number;
    private String name;
    private String sex;
    private String college;
    private String stu_major;
    private Integer stu_grade;
    private String province;
    private String city;
    private String phone;
    private  String ispoverty;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getStu_major() {
        return stu_major;
    }

    public void setStu_major(String stu_major) {
        this.stu_major = stu_major;
    }

    public int getStu_grade() {
        return stu_grade;
    }

    public void setStu_grade(int stu_grade) {
        this.stu_grade = stu_grade;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIspoverty() {
        return ispoverty;
    }

    public void setIspoverty(String ispoverty) {
        this.ispoverty = ispoverty;
    }

    @Override
    public String toString() {
        return "students_basic{" +
                "name=" + name +
                ",sex=" + sex + '\'' +
                ",college=" + college + '\'' +
                ",stu_major=" + stu_major + '\'' +
                ",stu_grade=" + stu_grade + '\'' +
                ",province=" + province + '\'' +
                ",city=" + city + '\'' +
                ",phone=" + phone +'\'' +
                ",ispoverty=" + ispoverty +
                "}";

    }

    @Override
    public IExcelData importData(Row row) {
        students_basic sc = new students_basic();
        sc.setNumber((int)Double.parseDouble(row.getCell(0).toString()));
        sc.setName(row.getCell(1).toString());
        sc.setSex(row.getCell(2).toString());
        sc.setCollege(row.getCell(3).toString());
        sc.setStu_major(row.getCell(4).toString());
        sc.setStu_grade((int)Double.parseDouble(row.getCell(5).toString()));
        sc.setProvince(row.getCell(6).toString());
        sc.setCity(row.getCell(7).toString());
        sc.setPhone(row.getCell(8).toString());
        sc.setIspoverty(row.getCell(9).toString());
        return sc;
    }

    @Override
    public void setHead(Row row) {
        row.createCell(0).setCellValue("学号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("性别");
        row.createCell(3).setCellValue("学院");
        row.createCell(4).setCellValue("专业");
        row.createCell(5).setCellValue("年级");
        row.createCell(6).setCellValue("省份");
        row.createCell(7).setCellValue("市");
        row.createCell(8).setCellValue("手机号码");
        row.createCell(9).setCellValue("是否贫困");

    }

    @Override
    public void exportData(Row row) {
        row.createCell(0).setCellValue(this.number.toString());
        row.createCell(1).setCellValue(this.name);
        row.createCell(2).setCellValue(this.sex);
        row.createCell(3).setCellValue(this.college);
        row.createCell(4).setCellValue(this.stu_major);
        row.createCell(5).setCellValue(this.stu_grade.toString());
        row.createCell(6).setCellValue(this.province);
        row.createCell(7).setCellValue(this.city);
        row.createCell(8).setCellValue(this.phone);
        row.createCell(9).setCellValue(this.ispoverty);
    }
}

