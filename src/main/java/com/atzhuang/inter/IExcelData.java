package com.atzhuang.inter;

import org.apache.poi.ss.usermodel.Row;

public interface IExcelData {
    //获取一行的内容封装成为对象
    public IExcelData importData(Row row);
    //设置标题
    public void setHead(Row row);
    //将数据存储在一行中
    public void exportData(Row row);
}
