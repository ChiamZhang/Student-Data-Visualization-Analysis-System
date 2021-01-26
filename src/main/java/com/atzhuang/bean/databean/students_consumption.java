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
@Table(name = "students_consumption")
public class students_consumption implements IExcelData {
    @Id
    Integer number;
    Integer year;
    Integer month;
    Integer consumption;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }

    @Override
    public IExcelData importData(Row row) {
        students_consumption sc=new students_consumption(ExcelUtil.stringToInt(row.getCell(0).toString()),ExcelUtil.stringToInt(row.getCell(1).toString()),ExcelUtil.stringToInt(row.getCell(2).toString()),ExcelUtil.stringToInt(row.getCell(3).toString()));
        return sc;
    }

    @Override
    public void setHead(Row row) {
        row.createCell(0).setCellValue("学号");
        row.createCell(1).setCellValue("年");
        row.createCell(2).setCellValue("月");
        row.createCell(3).setCellValue("消费");
    }

    @Override
    public void exportData(Row row) {
        row.createCell(0).setCellValue(this.number.toString());
        row.createCell(1).setCellValue(this.year.toString());
        row.createCell(2).setCellValue(this.month.toString());
        row.createCell(3).setCellValue(this.consumption.toString());
    }
}
