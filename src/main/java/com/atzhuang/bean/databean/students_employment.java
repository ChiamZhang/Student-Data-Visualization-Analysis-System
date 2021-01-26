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
@Table(name = "students_employment")
public class students_employment implements IExcelData {

    @Id
    Integer number;
    String province;
    String city;
    String job_nature;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getJob_nature() {
        return job_nature;
    }

    public void setJob_nature(String job_nature) {
        this.job_nature = job_nature;
    }

    @Override
    public IExcelData importData(Row row) {
        return new students_employment(ExcelUtil.stringToInt(row.getCell(0).toString()),row.getCell(1).toString(),row.getCell(2).toString(),row.getCell(3).toString());
    }

    @Override
    public void setHead(Row row) {
        row.createCell(0).setCellValue("学号");
        row.createCell(1).setCellValue("省份");
        row.createCell(2).setCellValue("城市");
        row.createCell(3).setCellValue("工作");
    }

    @Override
    public void exportData(Row row) {
        row.createCell(0).setCellValue(this.number.toString());
        row.createCell(1).setCellValue(this.province);
        row.createCell(2).setCellValue(this.city);
        row.createCell(3).setCellValue(this.job_nature);
    }
}
