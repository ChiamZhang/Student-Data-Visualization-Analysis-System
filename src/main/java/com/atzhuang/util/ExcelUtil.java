package com.atzhuang.util;

import com.atzhuang.inter.IExcelData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ExcelUtil {

    public static void main(String [] args){

    }

    /**
     *
     * 实现文件的导出
     */

    public static int stringToInt(String data)
    {
        return (int)Double.parseDouble(data);
    }
    public static  int isExcel(InputStream inputStream)
    {
        try {
            InputStream is = FileMagic.prepareToCheckMagic(inputStream);
            FileMagic magic=FileMagic.valueOf(is);
            //判断文件为excel文件
            if(Objects.equals(magic,FileMagic.OLE2)||Objects.equals(magic,FileMagic.OOXML))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public static void exportExcel(String path, List<IExcelData> list,String sheetName) {
        if(list.size()==0||path==null||path=="")
        {
            System.out.println("所需内容不完整");
            return;
        }
        Workbook wb=null;
        String[] p = path.split("\\.");
        if(p[p.length-1].equals("xlsx"))
        {
            wb=new XSSFWorkbook();
        }
        else if(p[p.length-1].equals("xls"))
        {
            wb=new HSSFWorkbook();
        }
        else
        {
            System.out.println("文件类型不符");
            return;
        }

        Sheet sheet = wb.createSheet(sheetName);
        Row row= sheet.createRow(0);
        list.get(0).setHead(row);
        Iterator<IExcelData> it=list.iterator();
        int i=1;
        while(it.hasNext())
        {
            IExcelData data=it.next();
            row=sheet.createRow(i);
            data.exportData(row);
            i++;
        }




        try {
            OutputStream fileOut = new FileOutputStream(path);
            wb.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭流
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 FileInputStream
     * */
    public static <T> List<T> importExcel(String path, Class<T> cl) throws Exception {
        if(path==null||path=="")
        {
            System.out.println("所需内容不完整");
            return null;
        }
        /**
         * 判断上传文件是否为excel文件
         */
        try{
            int a=isExcel(new FileInputStream(path));
            if(a==0)
            {
                System.out.println("文件类型不符");
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        List list=new LinkedList<IExcelData>();
        Workbook wb=null;
        try {
            wb = WorkbookFactory.create(new FileInputStream(path));
            //确定要返回对象的类型
            IExcelData ob= (IExcelData) cl.getConstructor().newInstance();
            Sheet sheet = wb.getSheetAt(0);//第一个
            int last=sheet.getLastRowNum();
            for(int i=1;i<=last;i++) {
                Row row = sheet.getRow(i);//获取行
                ob=ob.importData(row);  //获取该行数据
                list.add(ob);           //添加至列表
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            // 关闭流
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
