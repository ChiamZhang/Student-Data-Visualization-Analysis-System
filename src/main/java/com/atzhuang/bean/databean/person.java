package com.atzhuang.bean.databean;

import com.atzhuang.inter.IExcelData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.Id;

import javax.persistence.Entity;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class person implements IExcelData {

    @Id
    private  int id;

    private String name;

    private String password;

    private String xuehao;

    private String power;

    public person(String name, String password, String xuehao, String power) {
        this.name = name;
        this.password = password;
        this.xuehao = xuehao;
        this.power = power;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }



    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", xuehao='" + xuehao + '\'' +
                ", power='" + power + '\'' +
                '}';
    }

    @Override
    public IExcelData importData(Row row) {
        person p=new person(row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(1).toString(),row.getCell(4).toString());
        p.setId((int)Double.parseDouble(String.valueOf(row.getCell(0))));
        return p;
    }

    @Override
    public void setHead(Row row) {
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("学号");
        row.createCell(2).setCellValue("姓名");
        row.createCell(3).setCellValue("密码");
        row.createCell(4).setCellValue("权限");    
    }

    @Override
    public void exportData(Row row) {
        row.createCell(0).setCellValue(this.getId());
        row.createCell(1).setCellValue(this.getXuehao());
        row.createCell(2).setCellValue(this.getName());
        row.createCell(3).setCellValue(this.getPassword());
        row.createCell(4).setCellValue(this.getPower());
    }


}
