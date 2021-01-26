package com.atzhuang.bean.databean;

import com.atzhuang.inter.IExcelData;
import com.atzhuang.util.ExcelUtil;
import lombok.*;
import org.apache.poi.ss.usermodel.Row;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@ToString
@Getter
@Setter
public class recruit_students implements IExcelData {
    @Id
    private Integer id;
    public String province;
    public Integer quantity;
    public Integer year;

    public recruit_students(int stringToInt, String toString, int stringToInt1, int stringToInt2) {
    }
    public recruit_students() {
    }
    @Override
    public IExcelData importData(Row row) {
        recruit_students re = new recruit_students();
        re.id=ExcelUtil.stringToInt(row.getCell(0).toString());
        re.province=row.getCell(1).toString();
        re.quantity=ExcelUtil.stringToInt(row.getCell(2).toString());
        re.year=ExcelUtil.stringToInt(row.getCell(3).toString());
        return re;
    }

    @Override
    public void setHead(Row row) {
        row.createCell(0).setCellValue("id");
        row.createCell(1).setCellValue("省份");
        row.createCell(2).setCellValue("数量");
        row.createCell(3).setCellValue("年份");
    }

    @Override
    public void exportData(Row row) {
        row.createCell(0).setCellValue(this.id.toString());
        row.createCell(1).setCellValue(this.province);
        row.createCell(2).setCellValue(this.quantity.toString());
        row.createCell(3).setCellValue(this.year.toString());
    }
}
