package com.atzhuang.bean.databean;

import com.atzhuang.inter.IExcelData;
import com.atzhuang.util.ExcelUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "students_grade")
public class students_grade implements IExcelData {

    @Id
    Integer number;

    Integer schoolyear;

    Integer semester;

    double grade;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(int schoolyear) {
        this.schoolyear = schoolyear;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "students_grade{" +
                "number=" + number +
                ",schoolyear=" + schoolyear + '\'' +
                ",semester=" + semester + '\'' +
                ",grade=" + grade +
                "}";

    }

    @Override
    public IExcelData importData(Row row) {
       return new students_grade(ExcelUtil.stringToInt(row.getCell(0).toString()),ExcelUtil.stringToInt(row.getCell(1).toString()),ExcelUtil.stringToInt(row.getCell(2).toString()),Double.parseDouble(row.getCell(3).toString()));
    }

    @Override
    public void setHead(Row row) {
        row.createCell(0).setCellValue("学号");
        row.createCell(1).setCellValue("学年");
        row.createCell(2).setCellValue("学期");
        row.createCell(3).setCellValue("绩点");

    }

    @Override
    public void exportData(Row row) {
        row.createCell(0).setCellValue(this.number.toString());
        row.createCell(1).setCellValue(this.schoolyear.toString());
        row.createCell(2).setCellValue(this.semester.toString());
        row.createCell(3).setCellValue(this.grade
        );
    }
}
